package com.tweak.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweak.DAO.ForumDAOImp;
import com.tweak.modal.Forum;

@Service
@Transactional
public class ForumService 
{
	@Autowired
	ForumDAOImp forumDAOImp;
	public void addForum(Forum forum)
	{
		forumDAOImp.addForum(forum);
	}
	public List<Forum> displayForum()
	{
		return forumDAOImp.displayForum();
	}
	public Forum updateForum(int forumId)
	{
		return forumDAOImp.updateForum(forumId);
	}
	public void deleteForum(int forumId)
	{
		forumDAOImp.deleteForum(forumId);
	}
	public void updateCommentCount(int count,int forumId)
	{
		forumDAOImp.updateCommentCount(count, forumId);
	}
	public void updateLikeCount(int count,int forumId)
	{
		forumDAOImp.updateLikeCount(count, forumId);
	}
	public List<Forum> getForumOfUser(int userId)
	{
		return forumDAOImp.getForumOfUser(userId);
	}
}
