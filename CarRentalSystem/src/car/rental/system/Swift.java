package car.rental.system;

public class Swift implements CarRental {

	@Override
	public String getCarData(String ct, String d, int t) {

		if (t == 3 && (d.equalsIgnoreCase("Tuesday") || d.equalsIgnoreCase("Wednesday")))
			return "The Car " + ct + " is available on " + d + " for " + t + " hours. The Price is Rs.2000.";
		else if (t == 6 && (d.equalsIgnoreCase("Tuesday") || d.equalsIgnoreCase("Wednesday")))
			return "The Car " + ct + " is available on " + d + " for " + t + " hours. The Price is Rs.4000.";
		else
			return "The Car " + ct + " is not available on " + d + " for " + t + " hours.";
		
	}

}
