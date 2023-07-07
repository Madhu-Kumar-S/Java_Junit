package car.rental.system;

import java.util.Scanner;

public class CarRentalSystem {

	public static boolean checkInputCorrectness(String cartype, String day, int time) {
		if (cartype.isBlank() || cartype.equals("null")) {
			try {
				throw new MyException("Invalid input... car type cannot be null or empty...");
			} catch (MyException me) {
				System.out.println(me);
			}
			return false;
		} else if (day.isBlank() || day.equals("null")) {
			try {
				throw new MyException("Invalid input... day cannot be null or empty...");
			} catch (MyException me) {
				System.out.println(me.toString());
			}
			return false;
		} else if (time <= 0) {
			try {
				throw new MyException("Time cannot be zero or negative...");
			} catch (MyException me) {
				System.out.println(me.toString());
			}
			return false;
		} else
			return true;

	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Available Car Types: 1.I10 2.Swift 3.Innova");

		System.out.print("Enter Car Type: ");
		String cartype = scanner.nextLine();
		System.out.print("Enter Day: ");
		String day = scanner.nextLine();
		System.out.print("Enter Time in hours: ");
		int time = scanner.nextInt();
		scanner.close();

		CarRental refCarRental;

		if (CarRentalSystem.checkInputCorrectness(cartype, day, time)) {
			if (cartype.equalsIgnoreCase("I10")) {
				refCarRental = new I10();
				String s = refCarRental.getCarData(cartype, day, time);
				System.out.println(s);
			} else if (cartype.equalsIgnoreCase("Swift")) {
				refCarRental = new Swift();
				String s = refCarRental.getCarData(cartype, day, time);
				System.out.println(s);
			} else if (cartype.equalsIgnoreCase("Innova")) {
				refCarRental = new Innova();
				String s = refCarRental.getCarData(cartype, day, time);
				System.out.println(s);
			} else {
				System.out.println("Car type not available...Please enter the available car type...");
			}
		}

	}

}

//
//if (cartype.equalsIgnoreCase("I10")) {
//	refCarRental = new I10();
//	String s = refCarRental.getCarData(cartype, day, time);
//	System.out.println(s);
//} else if (cartype.equalsIgnoreCase("Swift")) {
//	refCarRental = new Swift();
//	String s = refCarRental.getCarData(cartype, day, time);
//	System.out.println(s);
//} else if (cartype.equalsIgnoreCase("Innova")) {
//	refCarRental = new Innova();
//	String s = refCarRental.getCarData(cartype, day, time);
//	System.out.println(s);
//} else {
//	if (cartype.isBlank()) {
//		try {
//			throw new MyException("Invalid input...car type cannot be null or empty...");
//		} catch (MyException me) {
//			System.out.println(me);
//		}
//	} else {
//		System.out.println("Car type not available...");
//	}
//
//}
