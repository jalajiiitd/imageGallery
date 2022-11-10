package com.example.imageGallery.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.imageGallery.entity.Comments;
import com.example.imageGallery.entity.Post;
import com.example.imageGallery.service.CommentsService;

@Controller
public class CommentsController {

	private final CommentsService commentsService;

	public CommentsController(CommentsService commentsService) {
		this.commentsService = commentsService;
	}
	
	
	@RequestMapping("/postComment")
	@ResponseBody
	public String addComment(@RequestParam("commentText") String commentText, @RequestParam("photoId") Long photoId) {
		
		try {
			commentsService.storeComment(photoId, commentText);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "OK";
	}
	
	@RequestMapping(value = "/getComments", method = RequestMethod.GET, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Comments> getComments(@RequestParam("photoId") Long photoId) {
		List<Comments> allComments = List.copyOf(commentsService.getCommentByPostId(photoId));
		return allComments;
	}
}
