package com.codewithshashwat.blogs.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
//iska istamal hoga for the transfer of data humlog UserDto ka istamal kaenge n ki User(entity ko expose nhi karenge..)
public class UserDto {

	private int id;
	@NotEmpty
	@Size(min=4,message="UserName Must be greater then 4 !!")
	private String name;
	@Email(message ="Email is invlaid !!")
	private String email;
	@NotEmpty
	@Size(min=3,max=10,message="password must be within valid 3 to 10 characters !!")
	//@Pattern (regx= )isme app set kar sakte ho ki apka password kaisa hona chaiye 
	private String password;
	@NotEmpty
	private String about;
}
