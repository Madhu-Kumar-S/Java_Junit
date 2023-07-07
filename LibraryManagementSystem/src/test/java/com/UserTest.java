package test.java.com;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import main.java.com.User;

@DisplayName("User Class")
class UserTest {
	User user;
	Map<String, String> usernamepassword; // user name - password

	@BeforeEach
	void beforeEach() {
		usernamepassword = new HashMap<String, String>();
		usernamepassword.put("User1", "user1");
		usernamepassword.put("User2", "user2");
		user = new User(usernamepassword, null, null);
	}

	@DisplayName("For user login")
	@ParameterizedTest
	@CsvSource({ "User1, user1, true", "User2, user2, true", "User3, user3, false" })
	void testAdminLogin(String username, String password, boolean expectedresult) {
		boolean actualresult = user.userLogin(username, password);
		assertEquals(expectedresult, actualresult);
	}

}
