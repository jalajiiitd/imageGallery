package com.example.imageGallery.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.imageGallery.entity.Comments;
import com.example.imageGallery.entity.Post;
import com.example.imageGallery.repository.CommentsRepository;

@Service
public class CommentsService {

	private final CommentsRepository commentsRepository;
	@Autowired
	PostStorageService postStorageService; 

	public CommentsService(CommentsRepository commentsRepository) {
		this.commentsRepository = commentsRepository;
	}
	
	public Comments storeComment(Long postid, String comment) {
		Comments obj = new Comments(comment, postid);
		commentsRepository.save(obj);
		return obj;
	}
	
	public Set<Comments> getCommentByPostId(Long postid) {
		Post p = postStorageService.getPost(postid);
		return p.getComments();
	}
	
}
