package Controllers;

import java.util.Date;
import java.util.Vector;

import Models.Record;
import Models.RecordsDB;
import Models.User;
import Models.UsersDB;

public class DbActions {
	public static boolean addUser(Vector<String> data){
		User u1 = new User();
    	
    	u1.setUserName(data.get(1).replace("+", " "));
    	u1.setLogin(data.get(3)); 
    	u1.setPassword(data.get(5).hashCode());
 	
    	
		return UsersDB.users.add(u1);
	}
	
	public static void addRecord(Vector<String> data){
		Record r1 = new Record();
    	
    	r1.setBody(data.get(1).replace("+", " "));
    	r1.setDate(new Date()); 
    	r1.setAuthor(Authorization.user);
 	
    	
    	if(!r1.getAuthor().getLogin().equals("???"))
    	RecordsDB.records.add(r1);
	}
	
}
