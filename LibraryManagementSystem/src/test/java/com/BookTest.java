package test.java.com;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.java.com.Book;

@DisplayName("Book class")
class BookTest {

	Book book;
	Map<String, String> usernamepassword; // user name - password
	Map<String, String> usernamename; // user name - name
	Map<String, Integer> noofuserbooks; // name - initial no of book
	static Calendar calendar;

	private static String getDateOfReturn() {
		calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 15);
		return calendar.getTime().toString();
	}

	@BeforeEach
	void beforeEach() {
		usernamepassword = new HashMap<String, String>();
		usernamepassword.put("User1", "user1");
		usernamepassword.put("User2", "user2");
		usernamepassword.put("User3", "user3");
		usernamename = new HashMap<String, String>();
		usernamename.put("User1", "A");
		usernamename.put("User2", "B");
		usernamename.put("User3", "c");
		noofuserbooks = new HashMap<String, Integer>();
		noofuserbooks.put("A", 1);
		noofuserbooks.put("B", 2);
		noofuserbooks.put("C", 0);
		book = new Book(usernamepassword, usernamename, noofuserbooks);
	}

	@DisplayName("Display book details for single user")
	@Test
	void testGetBookDetails() {
		// given
		String expected1 = "\nNo of Issued Books = 1\nDate of Return = " + BookTest.getDateOfReturn();
		String expected2 = "\nNo of Issued Books = 2\nDate of Return = " + BookTest.getDateOfReturn();
		String expected3 = "\nNo of Issued Books = 0\nDate of Return = NA";
		// when
		String actual1 = book.getBookDetails("A");
		String actual2 = book.getBookDetails("B");
		String actual3 = book.getBookDetails("C");
		// then
		assertAll(() -> assertEquals(expected1, actual1), () -> assertEquals(expected2, actual2),
				() -> assertEquals(expected3, actual3));
	}

	@Disabled
	@DisplayName("Display book details for Multiple users")
	@Test
	void testGetBookDetailsByBulkUsers() {
		book.getBookDetailsByBulkUsers();
	}

}
