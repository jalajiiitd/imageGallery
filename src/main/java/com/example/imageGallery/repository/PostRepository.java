package com.example.imageGallery.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.imageGallery.entity.Post;

public interface PostRepository extends CrudRepository<Post, Long> {

}
