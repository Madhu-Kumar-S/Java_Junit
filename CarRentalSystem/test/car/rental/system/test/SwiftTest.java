package car.rental.system.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import car.rental.system.Swift;

@DisplayName("For Swift car type")
class SwiftTest {
	Swift swift;
	String cartype;

	@BeforeEach
	void beforeEach() {
		swift = new Swift();
		cartype = "Swift";
	}

	@DisplayName("When car is available")
	@Test
	void testGetCarData_shouldReturnWhenCarIsAvailable() {
		// given
		String[] day = { "Tuesday", "Wednesday" };
		int[] time = { 3, 6 };

		// when
		String actual1 = swift.getCarData(cartype, day[0], time[0]); // Tue 3
		String actual2 = swift.getCarData(cartype, day[0], time[1]); // Tue 6
		String actual3 = swift.getCarData(cartype, day[1], time[0]); // Wed 3
		String actual4 = swift.getCarData(cartype, day[1], time[1]); // Wed 6

		// then
		assertAll(
				() -> assertEquals("The Car Swift is available on Tuesday for 3 hours. The Price is Rs.2000.", actual1),
				() -> assertEquals("The Car Swift is available on Tuesday for 6 hours. The Price is Rs.4000.", actual2),
				() -> assertEquals("The Car Swift is available on Wednesday for 3 hours. The Price is Rs.2000.",
						actual3),
				() -> assertEquals("The Car Swift is available on Wednesday for 6 hours. The Price is Rs.4000.",
						actual4));
	}

	@DisplayName("When car is not available")
	@Test
	void testGetCarData_shouldReturnWhenCarIsNotAvailable() {
		// given
		String[] day = { "Sunday", "Tuesday", "Thursday", "Friday", "Saturday" };
		int[] time = { 1, 2, 4, 5, 7, 8, 9, 0 };
		// when
		String actual1 = swift.getCarData(cartype, day[0], time[0]); // Sun 1
		String actual2 = swift.getCarData(cartype, day[1], time[1]); // Tue 2
		// then
		assertAll(() -> assertEquals("The Car Swift is not available on Sunday for 1 hours.", actual1),
				() -> assertEquals("The Car Swift is not available on Tuesday for 2 hours.", actual2));

	}

}
