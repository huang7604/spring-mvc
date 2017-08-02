package com.springmvc.bean;

import java.io.Serializable;

public class JsonInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int age;
	private String sex;
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setAge(int age){
		this.age=age;
	}
	
	public int getAge(){
		return age;
	}
	
	public void setSex(String sex){
		this.sex=sex;
	}
	
	public String getSex(){
		return sex;
	}

}
