package com.entities;

import java.util.Date;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Note {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String content;
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date addedDate;
	
	
	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Note(String title, String content, Date addedDate) {
		super();
		
		this.title = title;
		this.content = content;
//		this.addedDate = addedDate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
////	public Date getAddedDate() {
////		return addedDate;
////	}
////	public void setAddedDate(Date addedDate) {
////		this.addedDate = addedDate;
////	}
//	
	
	

}
