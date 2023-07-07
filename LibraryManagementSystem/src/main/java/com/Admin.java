package main.java.com;

public class Admin {
	public boolean adminLogin(String username, String password) {

		String adminusername = "Admin";
		String adminpassword = "admin@123";

		if (username.equals(adminusername) && (password.equals(adminpassword))) {
			System.out.println("LOGIN SUCCESSFUL...");
			return true;
		} else {
			System.out.println("INVALID LOGIN CREDENTIALS...");
			return false;
		}

	}

}
