package com.ria.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserModel {

	private String username;
	private String name;
	private String role;
	
	private static UserModel user;
	
	public static UserModel getUserModel()
	{
		return user;
	}
	
	public static void setUserModel(String username,String name, String role)
	{
		user=new UserModel(username,name,role);
	}
}
