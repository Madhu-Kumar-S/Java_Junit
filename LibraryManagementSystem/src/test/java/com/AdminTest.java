package test.java.com;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import main.java.com.Admin;

@DisplayName("Admin Class")
class AdminTest {

	Admin admin;
	String adminusername;
	String adminpassword;

	@BeforeEach
	void beforeEach() {
		admin = new Admin();
		adminusername = "Admin";
		adminpassword = "admin@123";
	}

	@DisplayName("For admin login")
	@ParameterizedTest
	@CsvSource({ "Admin, admin@123, true", "Admin, 123, false", "' ', ' ', false" })
	void testAdminLogin(String aun, String pwd, boolean excpectedresult) {
		boolean actualresult = admin.adminLogin(aun, pwd);
		assertEquals(excpectedresult, actualresult);
	}

}
