package com.tweak.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweak.DAO.ForumLikeDAOImp;
import com.tweak.modal.ForumLike;



@Service
@Transactional
public class ForumLikeService 
{
	@Autowired
	ForumLikeDAOImp forumLikeDAOImp;
	
	public void addLike(ForumLike forumLike)
	{
		forumLikeDAOImp.addLike(forumLike);
	}
	
	public ForumLike getForumLike(int userId,int forumId)
	{
		return forumLikeDAOImp.getForumLike(userId, forumId);
	}
}
