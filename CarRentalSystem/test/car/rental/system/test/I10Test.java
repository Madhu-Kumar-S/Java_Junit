package car.rental.system.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import car.rental.system.I10;

@DisplayName("For I10 car type")
class I10Test {

	I10 i10;
	String cartype;

	@BeforeEach
	void beforeEach() {
		i10 = new I10();
		cartype = "I10";
	}

	@DisplayName("When car is available")
	@Test
	void testGetCarData_shouldReturnWhenCarIsAvailable() {
		// given
		String[] day = { "Monday", "Wednesday" };
		int[] time = { 3, 6 };

		// when
		String actual1 = i10.getCarData(cartype, day[0], time[0]); // Mon 3
		String actual2 = i10.getCarData(cartype, day[0], time[1]); // Mon 6
		String actual3 = i10.getCarData(cartype, day[1], time[0]); // Wed 3
		String actual4 = i10.getCarData(cartype, day[1], time[1]); // Wed 6

		// then
		assertAll(() -> assertEquals("The Car I10 is available on Monday for 3 hours. The Price is Rs.3000.", actual1),
				() -> assertEquals("The Car I10 is available on Monday for 6 hours. The Price is Rs.6000.", actual2),
				() -> assertEquals("The Car I10 is available on Wednesday for 3 hours. The Price is Rs.3000.", actual3),
				() -> assertEquals("The Car I10 is available on Wednesday for 6 hours. The Price is Rs.6000.",
						actual4));
	}

	@DisplayName("When car is not available")
	@Test
	void testGetCarData_shouldReturnWhenCarIsNotAvailable() {
		// given
		String[] day = { "Sunday", "Tuesday", "Thursday", "Friday", "Saturday" };
		int[] time = { 1, 2, 4, 5, 7, 8, 9, 0 };
		// when
		String actual1 = i10.getCarData(cartype, day[0], time[0]); // Sun 1
		String actual2 = i10.getCarData(cartype, day[1], time[1]); // Tue 2
		// then
		assertAll(() -> assertEquals("The Car I10 is not available on Sunday for 1 hours.", actual1),
				() -> assertEquals("The Car I10 is not available on Tuesday for 2 hours.", actual2));

	}

}
