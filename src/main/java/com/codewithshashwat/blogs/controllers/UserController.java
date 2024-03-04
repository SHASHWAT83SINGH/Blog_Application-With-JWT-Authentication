package com.codewithshashwat.blogs.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithshashwat.blogs.payloads.ApiResponse;
import com.codewithshashwat.blogs.payloads.UserDto;
import com.codewithshashwat.blogs.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController 
{
	@Autowired
	private UserService userService;

	
	//POST create user
	@PostMapping("/")   //@RequestBody ki maddat se userDto ka sara data nikal lete hai
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto)
	{
		UserDto createUserDto=this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
	}
	
	//PUT update User
	@PutMapping("/{userId}") //{userId} isse springboot ke language me path uri variable kehte hai.. iska istemal isliye kiye hai taki user ki id mil sake...
	public ResponseEntity<UserDto> updateUser( @Valid @RequestBody UserDto userDto,@PathVariable Integer userId) //iss path uri me jo data ayega usse fetch karne ke liye we use @PathVariable
	{
		UserDto updatedUser=this.userService.updateUser(userDto, userId);
		return ResponseEntity.ok(updatedUser);
	}
	
	//DELETE remove User
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping ("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId)
	{
		this.deleteUser(userId);// isse kisi variable me isi liye nhi store kiya gaya hai kyu ki it will not return anything...
	  return  new ResponseEntity(new ApiResponse("User Deleted Successfully",true),HttpStatus.OK);//yaha par agar hume koi message return karna hai so we are using map here....
	}
	
	//GET  getting user details
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers()
	{
		return ResponseEntity.ok(this.userService.getAllUsers());
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingleUsers(@PathVariable Integer userId) {
		return ResponseEntity.ok(this.userService.getUserById(userId));
	}
}
