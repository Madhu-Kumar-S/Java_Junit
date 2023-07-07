package car.rental.system;

public class I10 implements CarRental {

	@Override
	public String getCarData(String ct, String d, int t) {

		if (t == 3 && (d.equalsIgnoreCase("Monday") || d.equalsIgnoreCase("Wednesday")))
			return "The Car " + ct + " is available on " + d + " for " + t + " hours. The Price is Rs.3000.";
		else if (t == 6 && (d.equalsIgnoreCase("Monday") || d.equalsIgnoreCase("Wednesday")))
			return "The Car " + ct + " is available on " + d + " for " + t + " hours. The Price is Rs.6000.";
		else
			return "The Car " + ct + " is not available on " + d + " for " + t + " hours.";

	}

}

//@Override
//public String getCarData(String ct, String d, int t) {
//	if (d.isBlank()) {
//		try {
//			throw new MyException("Invalid input... day cannot be null or empty...");
//		} catch (MyException e) {
//			return e.toString();
//		}
//	} else if (t <= 0) {
//		try {
//			throw new MyException("Time cannot be zero or negative...");
//		} catch (MyException e) {
//			return e.toString();
//		}
//	} else {
//		if (t == 3 && (d.equalsIgnoreCase("Monday") || d.equalsIgnoreCase("Wednesday")))
//			return "The Car " + ct + " is available on " + d + " for " + t + " hours. The Price is Rs.3000.";
//		else if (t == 6 && (d.equalsIgnoreCase("Monday") || d.equalsIgnoreCase("Wednesday")))
//			return "The Car " + ct + " is available on " + d + " for " + t + " hours. The Price is Rs.6000.";
//		else
//			System.out.printf("The Car %s is not available on %s for %d hours.", ct, d, t);
//		return "The Car " + ct + " is not available on " + d + " for " + t + " hours.";
//	}
//
//}
