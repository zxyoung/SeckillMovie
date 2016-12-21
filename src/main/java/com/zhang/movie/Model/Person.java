package com.zhang.movie.Model;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


/**
 * ≤‚ ‘”√
 * @author Administrator
 *
 */
@PersistenceCapable(table="PERSON")
public class Person{
	
	@PrimaryKey
	@Column(name="P_ID")
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private Integer id;
	
	@Column(name="P_NAME")
	private String name;
	
	@Column(name="P_AGE")  
	private int age;
	
	@Column(name="P_EMAIL")  
	private String email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", emai=" + email + "]";
	}
	
	
	
}
