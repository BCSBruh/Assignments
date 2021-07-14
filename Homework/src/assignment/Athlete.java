package assignment;

//Imports
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Athlete {
	//Class variables
	private String fName, lName;
	private LocalDate dob;
	
	public Athlete (String lName, String fName, int birthYear, int birthMonth, int birthDay) {
		this.lName = lName;
		this.fName = fName;
		this.dob = LocalDate.of(birthYear, birthMonth, birthDay);
	}
	
	public String getFname() {
		return fName;
	}
	
	public String getLname() {
		return lName;
	}
	
	public String computeAge() {
		String out = "";
		Period p = Period.between(dob, LocalDate.now());
		int years = p.getYears();
		int months = p.getMonths();
		int days = p.getDays();
		
		//Get output for years
		if (years > 0) {
			out += years + " year";
		}if (years > 1) {
			out += "s";
		}else {
			out += "";
		}
		
		//Get output for months
		if (years > 0 && days > 0 && months > 0) {
			out += ", ";
		}
		if (months > 0) {
			out += months + " month";
		}if (months > 1) {
			out += "s";
		}else {
			out += "";
		}
		
		//Get output for days
		if (years > 0 || months > 0) {
			out += " and ";
		}
		if (days > 0) {
			out += days + " day";
		}if (days > 1) {
			out += "s";
		}else {
			out += "";
		}
		
		return out;
	}
	
	public long daysSinceBirth() {
		return ChronoUnit.DAYS.between(dob, LocalDate.now());
	}
	
	public String toString() {
		return this.getFname() + " " + this.getLname() + " is " + computeAge() + " old";
	}
	
	public boolean equals(Object other) {
		return ((Athlete) other).getFname().equalsIgnoreCase(fName) && ((Athlete) other).getLname().equalsIgnoreCase(lName)
				&& ((Athlete) other).daysSinceBirth() == daysSinceBirth();
	}

}
