package com.codewithshashwat.blogs.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
public class Categories {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;
	@Column(name = "title")
	private String categoryTitle;
	@Column(name = "description")
	private String categoryDescription;

	//one categories can have many posts..
	@OneToMany(mappedBy = "categories", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Post> posts = new ArrayList<>();// making a list for post in which category mapping will be done..
}
//Cascade ka istamal isliye kiya gaya hai kyu ki 
//agar koi changes parents me ho to wo saree changes uske
//child me bbhi reflect kare...

//or jo mappedby="categoreis" ka istemal kiye hai wo wahi 
//variable hai jo (post.java) enitites me sabse nicche declare kiye hai..
