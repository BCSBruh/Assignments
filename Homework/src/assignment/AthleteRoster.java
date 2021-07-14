package assignment;

import java.util.ArrayList;

import java.lang.StringBuilder;

public class AthleteRoster {
	//Class variables
	private String semester;
	private int year;
	private ArrayList<Athlete> myTeam;
	private ArrayList<Runner> myRunner;
	
	public AthleteRoster(String semester, int year) {
		this.semester = semester;
		this.year = year;
		this.myTeam = new ArrayList<Athlete>();
		this.myRunner = new ArrayList<Runner>();
	}
	
	public String getSemester() {
		return semester;
	}
	
	public int getYear() {
		return year;
	}
	
	public boolean addAthlete(Athlete ath) {
		return myTeam.add(ath);
	}
	
	public String allAthletesOrderedByLastName() {
		ArrayList<Athlete> bruh = sortByLastName(myTeam);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bruh.size(); i++) {
			sb.append(bruh.get(i));
		}
		return sb.toString();
	}
	
	public String allAthletesOrderedByAge() {
		ArrayList<Athlete> bruh = sortByAge(myTeam);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bruh.size(); i++) {
			sb.append(bruh.get(i));
		}
		return sb.toString();
	}
	
	public ArrayList<Runner> allRunnersOrderedByNumberOfEvents(ArrayList<Runner> a) {
		return a;
	}
	
	public String allRunnersOrderedByNumberOfEvents() {
		ArrayList<Runner> bruh = sortRunners(myRunner);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bruh.size(); i++) {
			sb.append(bruh.get(i));
		}
		return sb.toString();
	}
	
	private ArrayList<Runner> sortRunners(ArrayList<Runner> roster) {
		for (int i = 0; i < roster.size(); i++) {
			if (roster.size() == i+1) {
				return roster;
			}else if (roster.get(i).getEvents().size() < roster.get(i+1).getEvents().size()) {
				Athlete a = roster.get(i);
				Athlete b = roster.get(i+1);
				
				roster.set(i, (Runner) b);
				roster.set((i+1), (Runner) a);
			}
		}
		
		return roster;
	}
	
	private ArrayList<Athlete> sortByAge(ArrayList<Athlete> roster2) {
		for (int i = 0; i < roster2.size(); i++) {
			for (int j = 0; j < roster2.size(); j++) {
				if (roster2.get(i).computeAge().compareTo(roster2.get(j).computeAge()) < 0) {
					Athlete temp = roster2.get(i);
					roster2.set(i, roster2.get(j));
					roster2.set(j, temp);
				}
			}
		}
		
		return roster2;
	}
	
	private ArrayList<Athlete> sortByLastName(ArrayList<Athlete> roster2) {
		for(int i = 0; i < roster2.size(); i++) {
			for (int j = 1; j < roster2.size(); j++) {
				if (roster2.get(i).getLname().compareTo(roster2.get(j).getLname()) < 0) {
					Athlete temp = roster2.get(i);
					roster2.set(i, roster2.get(j));
					roster2.set(j, temp);
				}
			}
		}
		
		return roster2;
	}
		

}
