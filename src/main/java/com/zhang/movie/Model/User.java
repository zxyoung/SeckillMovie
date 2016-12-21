package com.zhang.movie.Model;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * 用户表
 * 
 * @author Administrator
 *
 */

@PersistenceCapable(table = "user")
public class User {

	/**
	 * 用户id
	 */
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private int id;

	/**
	 * 用户名
	 */
	@Column(name = "name")
	private String username;

	/**
	 * 用户密码
	 */
	@Column(name = "password", length = 16)
	private String password;

	/**
	 * 用户email
	 */
	@Column(name = "email", length = 30)
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", registerTime=" + "]";
	}
}
