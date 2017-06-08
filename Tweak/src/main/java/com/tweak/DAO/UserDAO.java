package com.tweak.DAO;

import java.util.List;

import com.tweak.modal.UserTable;

public interface UserDAO 
{
	public void addUser(UserTable user);
	public List<UserTable> displayUser();
	public UserTable updateUser(int userId);
	public void deleteUser(int userId);
}
