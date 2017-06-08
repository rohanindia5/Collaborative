package com.tweak.DAO;

import java.util.List;

import com.tweak.modal.Forum;

public interface ForumDAO 
{
	public void addForum(Forum forum);
	public List<Forum> displayForum();
	public Forum updateForum(int forumId);
	public void deleteForum(int forumId);
}
