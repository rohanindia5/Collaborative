package com.tweak.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweak.DAO.UserDAOImp;
import com.tweak.modal.UserTable;

@Transactional
@Service
public class UserService 
{
	@Autowired
	UserDAOImp userDAOImp;
	
	public void addUser(UserTable userTable)
	{
		userDAOImp.addUser(userTable);
	}
	public List<UserTable> displayUser()
	{
		return userDAOImp.displayUser();
	}
	public UserTable updateUser(int userId)
	{
		return userDAOImp.updateUser(userId);
	}
	
	public void deleteUser(int userID)
	{
		userDAOImp.deleteUser(userID);
	}
	
	public UserTable authenticateUser(String username, String password) 
	{
		return userDAOImp.authenticateUser(username, password);
	}
	
	public UserTable getUserByName(String username)
	{
		return userDAOImp.getUserByName(username);
	}
	
}
