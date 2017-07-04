package com.tweak.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tweak.modal.UserTable;

@Repository("userDAOImp")
public class UserDAOImp implements UserDAO 
{

	@Autowired
	SessionFactory sessionFactory;
	public UserDAOImp(SessionFactory sessionFactory) {
	this.sessionFactory=sessionFactory;
	}
	
	
	@Override
	public void addUser(UserTable userTable) 
	{
		sessionFactory.getCurrentSession().saveOrUpdate(userTable);		
	}

	@Override
	public List<UserTable> displayUser()
	{
		List<UserTable> list=sessionFactory.getCurrentSession().createQuery("from UserTable").getResultList();
		return list;
	}

	@Override
	public UserTable updateUser(int userId) 
	{
		List<UserTable> list=sessionFactory.getCurrentSession().createQuery("from UserTable where userId="+userId).getResultList();
		return list.get(0);
	}
	
	@Override
	public void deleteUser(int userID) {
		UserTable userDelete=new UserTable();
		userDelete.setUserId(userID);
		sessionFactory.getCurrentSession().delete(userDelete);		
	}
	
	public UserTable authenticateUser(String username, String password) {
		List<UserTable> usercred=sessionFactory.getCurrentSession().createQuery("from UserTable where userName='"+username+"' and password='"+password+"'").getResultList();
		return usercred.get(0);
	}
	
	public UserTable getUserByName(String username) {
		List<UserTable> usercred=sessionFactory.getCurrentSession().createQuery("from UserTable where userName='"+username+"'").getResultList();
		return usercred.get(0);
	}

}
