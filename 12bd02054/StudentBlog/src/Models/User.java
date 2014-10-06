package Models;

import java.io.Serializable;



public class User implements Comparable<User>{

	String userName;
	String userLastName;
	String login;
	int password;
	public User(){};
	
	public User(String name, String login, String password){
		userName = name;
		
		this.login = login;
		this.password = password.hashCode();
	};
	
	
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	public String getLogin() {
		return login;
	}

	
	public void setLogin(String login) {
		this.login = login;
	}

	
	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}
	
	public String toString(){
		return login+"\n";
	}
	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		User other = (User) obj;
		//if(id==null && other.id==null) return true;
		return other.login.equals(this.login);
	}

	public int compareTo(User p) {
		return login.compareTo(p.getLogin());
		/*if(userName.compareTo(p.userName) == 0) return 1;
		return userName.compareTo(p.userName):*/
	}
	
	
}
