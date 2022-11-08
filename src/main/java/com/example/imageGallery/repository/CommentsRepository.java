package com.example.imageGallery.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.imageGallery.entity.Comments;

public interface CommentsRepository extends CrudRepository<Comments, Long>{

}
