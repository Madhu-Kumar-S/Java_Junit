package main.java.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class LibraryManagementSystem {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, String> usernamepassword = new HashMap<String, String>();// user name - password
		Map<String, String> usernamename = new HashMap<String, String>();// user name - name
		Map<String, Integer> noofuserbooks = new HashMap<String, Integer>();// name - initial no of books

		String username, password, name;
		int choice = 0;
		Admin admin = new Admin();
		User user;
		Book book;
		while (choice < 5) {
			System.out.println("---------------Welcome to Library Management System---------------\n");
			System.out.println("1 -> Admin Login" + "\n2 -> User Registration" + "\n3 -> User Login\n4 -> Exit");
			System.out.println();
			System.out.println("Enter your choice: ");
			choice = Integer.parseInt(br.readLine());

			switch (choice) {
			case 1:
				System.out.println("\nEnter login credentials:");
				System.out.println("Enter username: ");
				username = br.readLine();
				System.out.println("Enter password: ");
				password = br.readLine();

				if (admin.adminLogin(username, password)) {
					System.out.println("\n---------------Welcome to Admin Page---------------");
					book = new Book(usernamepassword, usernamename, noofuserbooks);
					do {
						System.out.println();
						System.out.println("Please choose the options in the list of actions to perform:");
						System.out.println(
								"1 -> Get single user book details\n2 -> Get multiple user book details\n3 -> LogOut");
						System.out.println("Enter your choice:");
						choice = Integer.parseInt(br.readLine());
						switch (choice) {
						case 1:
							System.out.println("\nEnter the name of the user:");
							String nameoftheuser = br.readLine();

							if (nameoftheuser.isBlank() || username == null) {
								try {
									throw new MyException(
											"Username cannot be null or empty...please enter valid name of the user...");
								} catch (MyException me) {
									System.out.println(me);
								}
							} else if (noofuserbooks.get(nameoftheuser) == null) {
								System.out.print("\nNo user Found...\n");
							} else {
								System.out.println("\n===============Book Details================");
								String bookdetails = book.getBookDetails(nameoftheuser); // name user_name
								System.out.println(bookdetails);
								System.out.println("\n===========================================");
							}

							break;
						case 2:
							if (usernamepassword.isEmpty())
								System.out.println("\nNo users found...");
							else
								book.getBookDetailsByBulkUsers();
							break;
						case 3:
							System.out.println("\nLOGOUT SUCCESSFUL...");
							break;
						default:
							System.out.println("\nIncorrect option");
							break;
						}

					} while (choice != 3);
				}
				break;
			case 2:
				System.out.println("\nEnter registration credentials:");
				System.out.println("Enter Name: ");
				name = br.readLine();
				System.out.println("Enter username: ");
				username = br.readLine();
				System.out.println("Enter password: ");
				password = br.readLine();

				if (name.isBlank() || name.equals("null")) {
					try {
						throw new MyException("Name cannot be null or empty...please enter valid name...");
					} catch (MyException me) {
						System.out.println(me);
					}
				} else if (username.isBlank() || username.equals("null")) {
					try {
						throw new MyException("Username cannot be null or empty...please enter valid username...");
					} catch (MyException me) {
						System.out.println(me);
					}
				} else if (password.isBlank() || password.equals("null")) {
					try {
						throw new MyException("Password cannot be null or empty...please enter valid password");
					} catch (MyException me) {
						System.out.println(me);
					}
				} else {
					if (usernamepassword.containsKey(username))
						System.out.println("\nUsername already exists...please try with another one...");
					else {
						usernamepassword.put(username, password);
						usernamename.put(username, name);
						System.out.println("\nREGISTRATION SUCCESSFULL...");
						noofuserbooks.put(name, 0);
					}
				}
				break;
			case 3:
				user = new User(usernamepassword, usernamename, noofuserbooks);

				System.out.println("\nEnter login credentials:");
				System.out.println("Enter username: ");
				username = br.readLine();
				System.out.println("Enter password: ");
				password = br.readLine();
				if (user.userLogin(username, password)) {
					System.out.println("---------------Welcome to User Page---------------");
					book = new Book(usernamepassword, usernamename, noofuserbooks);

					do {
						System.out.println("\nPlease choose the options in the list of actions to perform:");
						System.out.println("\n1 -> Get books\n2 -> View books in account\n3 -> LogOut");
						System.out.println("Enter your choice:");
						choice = Integer.parseInt(br.readLine());
						switch (choice) {
						case 1:
							System.out.println("\nDo you want to get books? Y/N: ");
							char yesorno = br.readLine().charAt(0);
							if (yesorno == 'Y')
								book.selectAvailableBooks(username, usernamename.get(username)); // user name - name

							break;
						case 2:
							book.getBookDetails(usernamename.get(username));
							System.out.println("\n===============Book Details================");
							String bookdetails = book.getBookDetails(usernamename.get(username)); // name user_name
							System.out.println(bookdetails);
							System.out.println("\n===========================================");
							break;
						case 3:
							System.out.println("\nLOGOUT SUCCESSFUL...");
							break;
						default:
							System.out.println("\nIncorrect option");
							break;
						}
					} while (choice != 3);
				}
				break;
			case 4:
				System.exit(0);
				break;
			default:
				System.out.println("\nIncorrect option...");
				break;
			}
			System.out.println();
		}
		br.close();

	}

}
