package com.example.gateway.service.serviceimpl;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.gateway.bean.auth.JwtToken;
import com.example.gateway.bean.auth.User;
import com.example.gateway.exception.CustomException;
import com.example.gateway.repository.JwtTokenRepository;
import com.example.gateway.repository.UserRepository;
import com.example.gateway.security.JwtTokenProvider;
import com.example.gateway.service.ILoginService;

@Service
public class LoginService implements ILoginService
{
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private JwtTokenRepository jwtTokenRepository;

	@Transient
	@PostConstruct
	public void postConstruct () {
		User user = new User();
		user.setId("admin@gmail.com");
		user.setLastName("admin");
		user.setName("admin");
		user.setPassword(passwordEncoder.encode("admin"));
		user.setEmail("admin@gmail.com");
		
		/*Role role1 = new Role();
		role1.setId("admin@gmail.com");
		role1.setRole("ADMIN");
		
		Role role2 = new Role();
		role2.setId("admin@gmail.com");
		role2.setRole("USER");
		
		Set<Role> roles = new HashSet<>();
		roles.add(role1);
		roles.add(role2);		
		
		user.setRole(roles);*/
				
		userRepository.save(user);    

		String token =  jwtTokenProvider.createToken(user.getEmail(), /*user.getRole().stream()
                  .map((Role role)-> "ROLE_"+role.getRole()).filter(Objects::nonNull).collect(Collectors.toList())*/ Arrays.asList("USER", "ADMIN"));
		jwtTokenRepository.save(new JwtToken(token));    
	}

	public String login(String username, String password) {
		try {
			//authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			User user = userRepository.findByEmail(username);
			if (user == null /*|| user.getRole() == null || user.getRole().isEmpty()*/ || !passwordEncoder.matches(password, user.getPassword())) {
				throw new CustomException("Invalid username or password.", HttpStatus.UNAUTHORIZED);
			}
			String token =  jwtTokenProvider.createToken(username, /*user.getRole().stream()
                    .map((Role role)-> "ROLE_"+role.getRole()).filter(Objects::nonNull).collect(Collectors.toList())*/ Arrays.asList("USER"));
			return token;

		} catch (AuthenticationException e) {
			throw new CustomException("Invalid username or password.", HttpStatus.UNAUTHORIZED);
		}
	}

	@Override
	public User saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()) );
		return userRepository.save(user);
	}

	@Override
	public boolean logout(String token) {
		jwtTokenRepository.delete(new JwtToken(token));
		return true;
	}

	@Override
	public Boolean isValidToken(String token) {
		return jwtTokenProvider.validateToken(token);
	}

	@Override
	public String createNewToken(String token) {
		String username = jwtTokenProvider.getUsername(token);
		List<String>roleList = jwtTokenProvider.getRoleList(token);
		String newToken =  jwtTokenProvider.createToken(username,roleList);
		return newToken;
	}
}
