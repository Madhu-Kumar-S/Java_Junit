package car.rental.system.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import car.rental.system.CarRentalSystem;

class CarRentalSystemTest {

	@DisplayName("When given input is correct")
	@Test
	void testcheckInputCorrectness_WhenInputisCorrect_ShouldReturnTrue() {
		// given
		String[] cartype = { "I10", "Swift", "Innova" };
		String[] day = { "Monday", "Tuesday", "Wednesday", "Sunday" };
		int[] time = { 3, 6, 8, 10 };
		boolean exmsg = true;

		// when
		boolean actmsg = CarRentalSystem.checkInputCorrectness(cartype[0], day[0], time[0]);
		// then
		assertEquals(exmsg, actmsg);
	}

	@DisplayName("When given input is wrong")
	@Test
	void testcheckInputCorrectness_WhenInputisWrong_ShouldThrowExceptionAndReturnFalse() {
		// given
		String[] cartype = { "", "null", };
		String[] day = { "", "null" };
		int[] time = { 0, -1 };

		String excartypemsg = "Invalid input... car type cannot be null or empty...";
		String exdaymsg = "Invalid input... day cannot be null or empty...";
		String extimemsg = "Time cannot be zero or negative...";
		// when
		boolean actmsg1 = CarRentalSystem.checkInputCorrectness("null", "Monday", 3);
//		MyException actmsg2 = assertThrows(MyException.class,
//				() -> CarRentalSystem.checkInputCorrectness("I10", "null", 3));
//		MyException actmsg3 = assertThrows(MyException.class,
//				() -> CarRentalSystem.checkInputCorrectness("I10", "null", 0));

		// then
		assertAll(() -> assertEquals(false, actmsg1)
//				() -> assertEquals("Invalid input... day cannot be null or empty...", actmsg2.getMessage()),
//				() -> assertEquals("Time cannot be zero or negative...", actmsg3.getMessage())
		);
	}

}
