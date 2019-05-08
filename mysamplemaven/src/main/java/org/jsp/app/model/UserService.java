package org.jsp.app.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.jsp.app.Dao.UserDao;
import org.springframework.stereotype.Service;



@Service
public class UserService {
	

	public User validateUser(Login login) {
		// TODO Auto-generated method stub
		User user = null; 
	      try { 
	            File file = new File("D:\\register.dat"); 
	            FileInputStream fis = new FileInputStream(file); 
	            ObjectInputStream ois = new ObjectInputStream(fis); 
	            user =  (User) ois.readObject(); 
	           if (user.getUsername().equals(login.getUsername())&&user.getPassword().equals(login.getPassword()))
	           {
	        	   return user;
	           }
	           else
	           {
	        	   user=null;
	           }
	            ois.close(); 
	     
	      } catch (IOException | ClassNotFoundException e) { 
	         e.printStackTrace(); 
	      }   
	      return user;
	}

	public void register(User user) {
		// TODO Auto-generated method stub
		/*user.setUsername(user.getUsername());
		user.setPassword(user.getPassword());
		user.setFirstname(user.getFirstname());
		user.setLastname(user.getLastname());
		user.setEmail(user.getEmail());
		user.setAddress(user.getAddress());
		user.setPhone(user.getPhone());	*/
		
		try { 
	         File file = new File("D:\\register.dat"); 
	         FileOutputStream fos;  
	         fos = new FileOutputStream(file); 
	         ObjectOutputStream oos = new ObjectOutputStream(fos); 
	         oos.writeObject(user); 
	         oos.close(); 
	      }  catch (IOException e) { 
	         e.printStackTrace(); 
	      } 
		
	}	
	
	//For Rest Service
	 public List<User> getAllUsers(){ 
	      
	      List<User> userList = null; 
	      try { 
	         File file = new File("D:\\register.dat"); 
	         if (!file.exists()) { 
	        	 
	         } 
	         else{ 
	            FileInputStream fis = new FileInputStream(file); 
	            ObjectInputStream ois = new ObjectInputStream(fis); 
	            userList = (List<User>) ois.readObject(); 
	            ois.close(); 
	         } 
	      } catch (IOException e) { 
	         e.printStackTrace(); 
	      } catch (ClassNotFoundException e) { 
	         e.printStackTrace(); 
	      }   
	      return userList; 
	   } 
	   
	 
		   /*public int updateUser(User pUser){
		      List<User> userList = getAllUsers();

		      for(User user: userList){
		         if(user.getId() == pUser.getId()){
		            int index = userList.indexOf(user);			
		            userList.set(index, pUser);
		            saveUserList(userList);
		            return 1;
		         }
		      }		
		      return 0;
		   }

		   public int deleteUser(int id){
		      List<User> userList = getAllUsers();

		      for(User user: userList){
		         if(user.getId() == id){
		            int index = userList.indexOf(user);			
		            userList.remove(index);
		            saveUserList(userList);
		            return 1;   
		         }
		      }		
		      return 0;
		   }
	   
	   
	   }    */
}
