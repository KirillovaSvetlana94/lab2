package View;

import java.util.Vector;

import Models.Record;
import Models.RecordsDB;

public class ViewForRecord {
	public static String viewForRec(Vector<Record> message){
		String response = "";
		for(int i=0; i<message.size(); i++ ){
			response += "<p class='mes'><strong style='color:#191943;'>" +message.get(i).getBody()+"</strong>"+",  from:"+
		                 message.get(i).getAuthor()+", "+message.get(i).getDate()+"</p><br><br>";
		    	
		}
		
		return response;
	}
}
