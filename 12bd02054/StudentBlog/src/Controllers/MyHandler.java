package Controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URL;



import Controllers.Authorization;
import Controllers.DbActions;
import Controllers.ReadFun;
import Controllers.ReadInputs;
import Models.User;
import Models.UsersDB;
import View.TemplateView;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Vector;

//import org.omg.CORBA.portable.InputStream;


public class MyHandler {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		  HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
	     
	     System.out.println(Authorization.user.getLogin());
	     server.createContext("/", new Handler1());
	        
	     server.setExecutor(null); // creates a default executor
	     server.start(); 

	}
	
	static class Handler1 implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
        	
        	
        	
        	URI uri = t.getRequestURI();
        	String path = uri.toString();
            String response = new String();
           
            String templ = ReadFun.readFromFile("template.html");
            
            
            if(path.equals("/regPage")){
                 response = FunHandler.regPage(templ,t);      	
            
            	System.out.println(Authorization.user.getLogin());
            }
            
            else if(path.equals("/authorization")){
            	response = FunHandler.authorization(templ, t);
            }
            else if(path.equals("/blog.html")){
            	response = FunHandler.forBlog(templ);
            	
            }
            
            else if(path.equals("/blog")){
            
            	response = FunHandler.forBlog(templ, t);
            }
            
            else if(!path.equals("/")) {

            	response = FunHandler.noSlash(templ, path);
            }
            
            
            else if(path.equals("/")){
            	response = FunHandler.withSlash(templ);
            }
          
			
			Headers header = t.getResponseHeaders();	//adding header
			header.add("Content-Type", "text/html; charset=UTF-8");
			
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        
    }
	

	}
}



