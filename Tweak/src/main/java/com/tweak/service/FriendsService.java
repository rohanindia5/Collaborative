package com.tweak.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweak.DAO.FriendsDAOImp;
import com.tweak.modal.Friends;

@Service
@Transactional
public class FriendsService 
{
	@Autowired
	FriendsDAOImp friendsDAOImp;
	public void addFriends(Friends friends)
	{
		friendsDAOImp.addFriends(friends);
	}
	public List<Friends> displayFriends()
	{
		return friendsDAOImp.displayFriends();
	}
	public Friends updateFriends(int friendsId)
	{
		return friendsDAOImp.updateFriends(friendsId);
	}
	public void deletefriends(int friendsId)
	{
		friendsDAOImp.deletefriends(friendsId);
	}
}
