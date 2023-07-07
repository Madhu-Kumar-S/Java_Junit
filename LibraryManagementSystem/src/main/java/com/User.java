package main.java.com;

import java.util.Map;

public class User {
	Map<String, String> usernamepassword; // user name - password
	Map<String, String> usernamename; // user name - name
	Map<String, Integer> noofuserbooks; // name - initial no of books
	boolean flag;

	public User() {

	}

	public User(Map<String, String> usernamepassword2, Map<String, String> usernamename2,
			Map<String, Integer> noofuserbooks2) {
		this.usernamepassword = usernamepassword2;
		this.usernamename = usernamename2;
		this.noofuserbooks = noofuserbooks2;
	}

	public boolean userLogin(String uname, String pwd) {
		for (Map.Entry<String, String> e : usernamepassword.entrySet()) {
			if ((e.getKey().equals(uname)) && (e.getValue().equals(pwd))) {
				System.out.println("LOGIN SUCCESSFUL...");
				System.out.println();
				flag = true;
				break;
			} else {
				flag = false;
			}
		}
		if (flag == false) {
			System.out.println("INVALID LOGIN CREDENTIALS...");
		}
		return flag;

	}

}
