package com.exercise.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="User")
public class User implements Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -2684470392755600966L;
	
	@Id
    private String id;
    private AuthParams auth;
    private String role;
    private String gender;
     
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public AuthParams getAuth() {
		return auth;
	}
	public void setAuth(AuthParams auth) {
		this.auth = auth;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
        .append(id)
        .append(auth)
        .append(gender)
        .append(role)
        .toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof User){
	        final User other = (User) obj;
	        return new EqualsBuilder()
	        	.append(id, other.id)
	            .append(auth, other.auth)
	            .append(gender, other.gender)
	            .append(role, other.role)
	            .isEquals();
	    } else {
	        return false;
	    }
	}
}