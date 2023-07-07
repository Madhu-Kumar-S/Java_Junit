package car.rental.system.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import car.rental.system.Innova;

@DisplayName("For Innova car type")
class InnovaTest {
	Innova innova;
	String cartype;

	@BeforeEach
	void beforeEach() {
		innova = new Innova();
		cartype = "Innova";
	}

	@DisplayName("When car is available")
	@Test
	void testGetCarData_shouldReturnWhenCarIsAvailable() {
		// given
		String day = "Sunday";
		int[] time = { 5, 10 };

		// when
		String actual1 = innova.getCarData(cartype, day, time[0]); // Sun 5
		String actual2 = innova.getCarData(cartype, day, time[1]); // Sun 10

		// then
		assertAll(
				() -> assertEquals("The Car Innova is available on Sunday for 5 hours. The Price is Rs.8000.", actual1),
				() -> assertEquals("The Car Innova is available on Sunday for 10 hours. The Price is Rs.10000.",
						actual2));
	}

	@DisplayName("When car is not available")
	@Test
	void testGetCarData_shouldReturnWhenCarIsNotAvailable() {
		// given
		String[] day = { "Sunday", "Tuesday", "Thursday", "Friday", "Saturday" };
		int[] time = { 1, 2, 4, 5, 7, 8, 9, 0 };
		// when
		String actual1 = innova.getCarData(cartype, day[0], time[0]); // Sun 1
		String actual2 = innova.getCarData(cartype, day[1], time[1]); // Tue 2
		// then
		assertAll(() -> assertEquals("The Car Innova is not available on Sunday for 1 hours.", actual1),
				() -> assertEquals("The Car Innova is not available on Tuesday for 2 hours.", actual2));

	}

}
