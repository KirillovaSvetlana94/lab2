package Controllers;


import java.io.IOException;

import com.sun.net.httpserver.HttpExchange;

import Controllers.Authorization;
import Controllers.DbActions;
import Controllers.ReadFun;
import Controllers.ReadInputs;
import Models.RecordsDB;
import Models.UsersDB;
import View.TemplateView;
import View.ViewForRecord;

public class FunHandler {
	public static String regPage(String templ, HttpExchange t) throws IOException{
		String response ;
		if(DbActions.addUser(ReadInputs.readUserInput(t))) {               
        	response = TemplateView.patternForRegPage(templ);
   
        	}
        	else 
        		response = TemplateView.patternForBadReg(templ);
        	
        	 response = TemplateView.patternForRegUser(response);
            return response;
	}
	
	public static String authorization(String templ, HttpExchange t) throws IOException{
		String response;
		if(Authorization.canUserLog(ReadInputs.readUserInput(t) )){
    		templ = TemplateView.patternForRegUser(templ);
    		response = templ.replace("%content%", "");
    	}
    	else response = templ.replace("%content%", "bad password");
    	 response = TemplateView.patternForRegUser(response);
         
    	 return response;
	}
	
	public static String forBlog(String templ, HttpExchange t) throws IOException{
		String response = null;
		String messages = "";
		DbActions.addRecord(ReadInputs.readUserInput(t));
		String newContent = ReadFun.readFromFile("blog.html");
		templ = templ.replace("%content%", newContent);
		
		messages = ViewForRecord.viewForRec(RecordsDB.records);
		templ = TemplateView.patternForRegUser(templ);
		response = templ.replace("%blog%", messages);
		
    	 return response;
	}
	
	public static String forBlog(String templ) throws IOException{
		String response = null;
		String messages = "";
		String newContent = ReadFun.readFromFile("blog.html");
		templ = templ.replace("%content%", newContent);
		
		messages = ViewForRecord.viewForRec(RecordsDB.records);
		templ = TemplateView.patternForRegUser(templ);
		response = templ.replace("%blog%", messages);
		
    	 return response;
	}
	
	
	
	public static String noSlash(String templ,String path) throws IOException{
		String response;
	
		path=path.substring(1);
		String sub=ReadFun.readFromFile(path);
		response=templ.replace("%content%", sub);
		 response = TemplateView.patternForRegUser(response);
         
		 return response;
     }
	
	public static String withSlash(String templ) throws IOException{
		String response;		
		String newContent = ReadFun.readFromFile("1Page.html");
    	response = templ.replace("%content%", newContent);
    	response = TemplateView.patternForRegUser(response);
     
    	 return response;
     }
	
}
