package com.example.entity;

import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable{
	
	protected String username;
	protected String password;
	protected String androidGcmaToken;
	protected String nick;
	protected Date created;
	protected Integer nomberStick;
	protected String stick;
	
	public User(String nick, String stick, Integer nbStick){
		this.nick = nick;
		this.stick = stick;
		this.nomberStick = nbStick;
	}
	
	public Integer getNomberStick() {
		return nomberStick;
	}

	public void setNomberStick(Integer nomberStick) {
		this.nomberStick = nomberStick;
	}

	public String getStick() {
		return stick;
	}

	public void setStick(String stick) {
		this.stick = stick;
	}

	@Override
	public String toString(){
		return String.format("%s %s",this);
	}
	
	private User(){
		
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

	public String getAndroidGcmaToken() {
		return androidGcmaToken;
	}

	public void setAndroidGcmaToken(String androidGcmaToken) {
		this.androidGcmaToken = androidGcmaToken;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
}
