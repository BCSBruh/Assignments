package assignment;

//Imports
import java.util.ArrayList;

public class Swimmer extends Athlete {
	//Class variables
	private String team;
	private ArrayList<String> multiEvents;
	
	public Swimmer(String lName, String fName, int birthYear, int birthMonth, int birthDay, String team) {
		super(lName, fName, birthYear, birthMonth, birthDay);
		
		this.team = team;
		this.multiEvents = new ArrayList<String>();
	}
	
	public String getTeam() {
		return team;
	}
	
	public boolean addEvent(String singleEvent) {
		if (multiEvents.equals(singleEvent)) {
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
		return super.toString() + " and is a swimmer for team: " + this.team + " in the following events: " + getEvents();
	}

}
