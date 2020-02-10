package com.springboot.blockchain.util;

import static com.springboot.blockchain.constants.SecurityConstants.AUTHORIZATION;
import static com.springboot.blockchain.constants.SecurityConstants.SECRET;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.springboot.blockchain.constants.SecurityConstants;
import com.springboot.blockchain.dao.JwtTokenRepository;
import com.springboot.blockchain.exceptions.SecurityException;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Utility class for JWT token
 * 
 * @author Anil
 *
 */
@Component
public class JwtTokenUtil {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtTokenRepository jwtTokenRepository;

	/**
	 * Create JWT token
	 * 
	 * @param id
	 * @param issuer
	 * @param subject
	 * @param ttlMillis
	 * @return String
	 */
	public String createJWT(String id, String issuer, String subject, long ttlMillis) {

		// The JWT signature algorithm we will be using to sign the token
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		// We will sign our JWT with our ApiKey secret
		byte[] apiKeySecretBytes = SecurityConstants.SECRET.getBytes();
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		// Let's set the JWT Claims
		JwtBuilder builder = Jwts.builder().setId(id).setIssuedAt(now).setSubject(subject).signWith(signatureAlgorithm, signingKey);

		// if it has been specified, let's add the expiration
		if (ttlMillis > 0) {
			long expMillis = nowMillis + ttlMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
		}

		// Builds the JWT and serializes it to a compact, URL-safe string
		return builder.compact();
	}

	/**
	 * Read JWT token from HttpServletRequest object
	 * 
	 * @param req
	 * @return String
	 */
	public String resolveToken(HttpServletRequest req) {
		String bearerToken = req.getHeader(AUTHORIZATION);
		/*
		 * if (bearerToken != null && bearerToken.startsWith("Bearer ")) { return
		 * bearerToken.substring(7, bearerToken.length()); }
		 */
		if (bearerToken != null) {
			return bearerToken;
		}
		return null;
	}

	/**
	 * Validate JWT token
	 * 
	 * @param token
	 * @return boolean
	 * @throws Exception - when provided jwt token is invalid
	 */
	public boolean validateToken(String token) throws Exception {
		Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(token);
		return true;
	}

	/**
	 * Read username from given jwt token
	 * 
	 * @param token
	 * @return String
	 */
	public String getUsername(String token) {
		return Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(token).getBody().getSubject();
	}

	/**
	 * Generate Authentication from given jwt token
	 * 
	 * @param token
	 * @return Authentication
	 */
	public Authentication getAuthentication(String token) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(getUsername(token));
		return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
	}

	/**
	 * Checks given jwt token exists or not in DB
	 * @param token
	 */
	public void isTokenExistsinDB(String token) {
		boolean flag = jwtTokenRepository.existsById(token);
		if (!flag) {
			throw new SecurityException("Invalid JWT token", HttpStatus.UNAUTHORIZED);
		}
		
	}

}
