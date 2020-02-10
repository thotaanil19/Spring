package com.example.gateway.bean.auth;



//@Entity
public class Role {
	
	//@Id
    private String id;
	
	//@Column
    private String role;
	
	//@ManyToOne
	//@JoinColumn(name="id", insertable=false, updatable=false)
	private User user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }
}
