package com.codewithshashwat.blogs.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="post")
@Getter
@Setter
@NoArgsConstructor
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer postId;
	@Column(name="post_title",length=100,nullable=false)
	private String title;
	@Column(name="post_Content")
	private String content;
	@Column(name="post_Image")
	private String imageName;
	@Column(name="post_added_date")
	private Date AddedDate;
	
	
	@ManyToOne 
	@JoinColumn(name="category_id")
	//jo join coloumn bana hai DB me uske name ko change karne ke liye
	private Categories categories;
	@ManyToOne	
	private User user;
	
	@OneToMany(mappedBy = "post" ,cascade = CascadeType.ALL)
	private Set<Comment> comments =new HashSet<>();

	//@ManyToOne ka istemal isliye kiya gaya
	//hai kyu ki iske coressponding sabhi class me @OneToMany ka use hua hoga.
}
