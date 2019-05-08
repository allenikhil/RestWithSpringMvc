package org.jsp.app.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import org.jsp.app.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerDemo {
	@RequestMapping("/getRegisterDetails")
	public User getobjectproperties()
	{
		User user = null; 
	      try { 
	            File file = new File("D:\\register.dat"); 
	            FileInputStream fis = new FileInputStream(file); 
	            ObjectInputStream ois = new ObjectInputStream(fis); 
	            user =  (User) ois.readObject(); 
	            ois.close(); 
	     
	      } catch (IOException | ClassNotFoundException e) { 
	         e.printStackTrace(); 
	      }   
	      return user; 	
	}
	@RequestMapping(value= "/getstring")
	public String getobjectpropertie1s()
	{
	
		return "HelloWorld";
		
		
	}

}
