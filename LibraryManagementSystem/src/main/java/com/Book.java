package main.java.com;

import java.util.Calendar;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Book {
	Map<String, String> usernamepassword; // user name - password
	Map<String, String> usernamename; // user name - name
	Map<String, Integer> noofuserbooks; // name - initial no of books
	TreeMap<String, Integer> result; // name - initial no of books

	public Book(Map<String, String> usernamepassword, Map<String, String> usernamename,
			Map<String, Integer> noofuserbooks) {
		this.usernamepassword = usernamepassword;
		this.usernamename = usernamename;
		this.noofuserbooks = noofuserbooks;
	}

	Scanner scanner = new Scanner(System.in);
	int count;
	char proceed;
	boolean flag;
	static Calendar calendar;

	static String getDateOfReturn() {
		calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 15);
		return calendar.getTime().toString();

	}

	public void selectAvailableBooks(String uname, String name) {
		count = noofuserbooks.get(name);
		do {
			System.out.println("choose the book from the list of available books:");
			System.out.println("1. Fasting, Feasting");
			System.out.println("2. The Great Gatsby");
			System.out.println("3. Law of Attraction");
			System.out.println("4. The Ikigai");
			System.out.println("5. The Blue Umbrella");
			System.out.println("\nBOOK ADDED...");
			count++;
			System.out.println("\nDo you want continue: Y/N:");
			proceed = scanner.next().charAt(0);
			System.out.println();
		} while (proceed == 'Y');
		noofuserbooks.put(name, 0);
		noofuserbooks.put(name, noofuserbooks.get(name) + count);
	}

	public String getBookDetails(String name) {
		if (noofuserbooks.get(name) == 0)
			return "\nNo of Issued Books = " + noofuserbooks.get(name) + "\nDate of Return = NA";
		else
			return "\nNo of Issued Books = " + noofuserbooks.get(name) + "\nDate of Return = " + getDateOfReturn();
	}
	// use static

	public void getBookDetailsByBulkUsers() {
		int c = 1;
		System.out.println("\n===============User Book Details================");
		result = new TreeMap<String, Integer>(noofuserbooks);
		for (Entry<String, Integer> e : result.entrySet()) {
			System.out.println("\nUser #" + c);
			System.out.println("User name: " + e.getKey());
			System.out.println("No of Issued Books = " + e.getValue());
			if (e.getValue() == 0) {
				System.out.println("Date of Return = NA");
			} else {
				System.out.println("Date of Return = " + getDateOfReturn());
			}
			System.out.println();
			c++;
		}

		System.out.println("\n===========================================");

	}
}
