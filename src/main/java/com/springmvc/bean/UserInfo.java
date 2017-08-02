package com.springmvc.bean;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class UserInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String password;
	private String email;
	
	public void setNmae(String name){
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setPassword(String password){
		this.password=password;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setEmail(String email){
		this.email=email;
	}
	
	public String getEmail(){
		return email;
	}

}
