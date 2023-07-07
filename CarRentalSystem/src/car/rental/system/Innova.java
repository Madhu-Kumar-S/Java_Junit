package car.rental.system;

public class Innova implements CarRental {

	@Override
	public String getCarData(String ct, String d, int t) {
		
		if (t == 5 && d.equalsIgnoreCase("Sunday"))
			return "The Car " + ct + " is available on " + d + " for " + t + " hours. The Price is Rs.8000.";
		else if (t == 10 && d.equalsIgnoreCase("Sunday"))
			return "The Car " + ct + " is available on " + d + " for " + t + " hours. The Price is Rs.10000.";
		else
			return "The Car " + ct + " is not available on " + d + " for " + t + " hours.";
	}

}