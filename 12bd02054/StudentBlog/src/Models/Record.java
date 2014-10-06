package Models;

import java.util.Date;
import java.util.Vector;

public class Record {
	private String body;
	private User author;
	private Date date;
	
	
	public Record() {
		
	}
	public Record(String body, User author) {
		this.author = author;
		this.body = body;
		date = new Date();
	}

	
	public String getBody() {
		return body;
	}
	public User getAuthor() {
		return author;
	}

	public void setBody(String body) {
		this.body = body;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public Date getDate() {
		return date;
	}

	
	public void setDate(Date date) {
		this.date = date;
	}

	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return  body +" \n"+
				author.toString()+"\n"+
			    date+"\n";
			   
	}
	
	
	
	
}
