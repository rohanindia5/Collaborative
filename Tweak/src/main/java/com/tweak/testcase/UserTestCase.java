package com.tweak.testcase;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tweak.DAO.BlogDAOImp;
import com.tweak.DAO.UserDAOImp;
import com.tweak.modal.UserTable;
import com.tweak.service.UserService;

public class UserTestCase 
{
	public static void main(String[] args) 
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.tweak");
		context.refresh();
		
		UserService userService=(UserService)context.getBean("userDAOImp");
		
		UserTable user=new UserTable();
		
		user.setUserId(1);
		user.setFirstName("rohan");
		user.setLastName("modi");
		user.setEmail("rohan@gmailcom");
		userService.addUser(user);
		System.out.println("Blog Details Added");
	}
}