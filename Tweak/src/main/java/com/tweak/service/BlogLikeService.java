package com.tweak.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweak.DAO.BlogLikeDAOImp;
import com.tweak.modal.BlogLike;
@Service
@Transactional
public class BlogLikeService 
{
	@Autowired
	BlogLikeDAOImp blogLikeDAOImp;
	public void addLike(BlogLike bloglike)
	{
		blogLikeDAOImp.addLike(bloglike);
	}
	
	public BlogLike getLike(int userId,int blogId){
		return blogLikeDAOImp.getLike(userId, blogId);
	}
}
