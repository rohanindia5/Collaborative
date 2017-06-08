package com.tweak.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Friends 
{
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int friendId;
	private String friendFirstName;
	private String friendLastName;
	private int userId;
	@ManyToOne
	@JoinColumn(name="userId",nullable=false,insertable=false,updatable=false)
	private UserTable user;
	public int getFriendId() {
		return friendId;
	}
	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}
	public String getFriendFirstName() {
		return friendFirstName;
	}
	public void setFriendFirstName(String friendFirstName) {
		this.friendFirstName = friendFirstName;
	}
	public String getFriendLastName() {
		return friendLastName;
	}
	public void setFriendLastName(String friendLastName) {
		this.friendLastName = friendLastName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public UserTable getUser() {
		return user;
	}
	public void setUser(UserTable user) {
		this.user = user;
	}
	
}
