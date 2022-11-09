package com.example.imageGallery.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="post_id")
	private Long photoId;
	
	@Lob
	@Column(name="photo", nullable=false, columnDefinition="mediumblob")
	private byte[] photo;
	
	private Long likeCount;
	
//	@OneToMany // EAGER, FETCH, LAZY 
//	@JoinColumn(name="commentId")
//	private Set<Comments> comments = new HashSet<>();
	
	public Post() {
	}
	
	public Post(byte[] photo) {
		this.photo = photo;
		this.likeCount = 0L;
	}
	
//	public Set<Comments> getComments() {
//		return comments;
//	}
//	public void setComments(Set<Comments> comments) {
//		this.comments = comments;
//	}
	public Long getPhotoId() {
		return photoId;
	}
	public void setPhotoId(Long photoId) {
		this.photoId = photoId;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public Long getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(Long likeCount) {
		this.likeCount = likeCount;
	}
	
}
