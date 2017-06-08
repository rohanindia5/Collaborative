package com.tweak.DAO;

import java.util.List;

import com.tweak.modal.Friends;

public interface FriendsDAO {
	public void addFriends(Friends friends);
	public List<Friends> displayFriends();
	public Friends updateFriends(int friendsId);
	public void deletefriends(int friendsId);
}
