package com.example.imageGallery.service;

import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.imageGallery.entity.Post;
import com.example.imageGallery.repository.PostRepository;

import org.springframework.util.StringUtils;

@Service
public class PostStorageService {

	private final PostRepository postRepository;

	public PostStorageService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	public Post storePost(MultipartFile file) throws Exception {
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		
		try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new Exception("Sorry! Filename contains invalid path sequence " + fileName);
            }

            Post post = new Post(file.getBytes());

            return postRepository.save(post);
        } catch (IOException ex) {
            throw new Exception("Could not store file " + fileName + ". Please try again!", ex);
        }
		
	}
	
	public Post getPost(Long photoId) {
		return postRepository.findById(photoId)
				.orElseThrow(() -> new FileSystemNotFoundException("File not found with id " + photoId));
	}
	
	
}
