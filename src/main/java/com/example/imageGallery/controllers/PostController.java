package com.example.imageGallery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.imageGallery.entity.Post;
import com.example.imageGallery.service.PostStorageService;

@Controller
public class PostController {
	
	@Autowired
	private PostStorageService storageService;
	

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Post> show() {
		List<Post> allPosts = storageService.getAllPosts();
		return allPosts;
	}
	
	@GetMapping("/posts") 
	public String displayUploadForm() {
        return "post/index";
    }
	
	@RequestMapping("/upload")
	public String addPost(@RequestParam("image") MultipartFile file) {
		
		try {
			storageService.storePost(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "post/index";
		
	}
	
	@GetMapping("/count")
	@ResponseBody
	public String increaseLike(@RequestParam Long photoId) {
		return storageService.saveLike(photoId);
	}
	
}
