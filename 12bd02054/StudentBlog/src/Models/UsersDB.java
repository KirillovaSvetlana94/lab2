package Models;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeSet;
import java.util.Vector;



public class UsersDB {
	
		public static TreeSet<User> users = new TreeSet<>();
	
	
	    public static  boolean isUserExist(User u){
				    	if(users.contains(u)) return true;
	    	return false;
	    } 	
	    
	    public static int findPassword( String login){
			
			User user = new User();
			
			for(User p:UsersDB.users){
				if(p.getLogin().equals(login))
					user = (User)p;
			}
			
			return user.getPassword();
	    }
}
