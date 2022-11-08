package com.example.imageGallery.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.example.imageGallery.service.PostStorageService;

@Controller
public class PostController {
	
	@Autowired
	private PostStorageService storageService;
	

	@GetMapping("/posts") 
	public String displayUploadForm() {
        return "post/index";
    }
	
	@RequestMapping("/upload")
	public String addPost(@RequestParam("image") MultipartFile file) {
		
		System.out.println(file);
		try {
			storageService.storePost(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "post/index";
		
	}
	
}
