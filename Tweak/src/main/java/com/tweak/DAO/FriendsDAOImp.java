package com.tweak.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tweak.modal.Friends;
@Repository
public class FriendsDAOImp implements FriendsDAO 
{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addFriends(Friends friends) {
		sessionFactory.getCurrentSession().saveOrUpdate(friends);
		
	}

	@Override
	public List<Friends> displayFriends() {
		List<Friends> list=sessionFactory.getCurrentSession().createQuery("from Friends").getResultList();
		return list;
	}

	@Override
	public Friends updateFriends(int friendsId) {
		List<Friends> list=sessionFactory.getCurrentSession().createQuery("from Friends where friendsId="+friendsId).getResultList();
		return list.get(0);
	}

	@Override
	public void deletefriends(int friendsId) {
		Friends friendsDelete=new Friends();
		friendsDelete.setFriendId(friendsId);
		sessionFactory.getCurrentSession().delete(friendsDelete);
		
	}

}
