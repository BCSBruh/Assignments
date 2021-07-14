package assignment;

import java.util.ArrayList;

public class Runner extends Athlete {
	
	private String country;
	private ArrayList<String> multiEvents;
	
	public Runner(String lName, String fName, int birthYear, int birthMonth, int birthDay, String country) {
		super(lName, fName, birthYear, birthMonth, birthDay);
		
		this.country = country;
		this.multiEvents = new ArrayList<String>();
	}
	
	public String getCountry() {
		return country;
	}
	
	public boolean addEvent(String singleEvent) {
		if (multiEvents.contains(singleEvent)) {
			return false;
		}else {
		return multiEvents.add(singleEvent);
		}
	}
	
	public boolean addEvent(ArrayList<String> multiEvents) {
		this.multiEvents = multiEvents;
		return true;
	}
	
	public ArrayList<String> getEvents() {
		return multiEvents;
	}
	
	public String toString() {
		String type = "long-distance runner";
		int bruh = 0;
		int bruh2 = 0;
		if (multiEvents.contains("M100") || multiEvents.contains("M200") || multiEvents.contains("M400")) {
			type = "sprinter";
			bruh = 1;
		}else if (multiEvents.contains("M3000") || multiEvents.contains("M5000") || multiEvents.contains("M10000")) {
			type = "long-distance runner";
			bruh2 = 1;
		}else if (bruh == 1 && bruh2 == 1) {
			type = "super athlete";
		}
		
		return super.toString() + " is a citizen of " + getCountry() + " and is a " + type + " who participates in these events: " + getEvents();
	}

}
