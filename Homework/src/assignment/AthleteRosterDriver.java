package assignment;

import java.util.ArrayList;
import java.util.Arrays;

public class AthleteRosterDriver {
	public static void main(String args[]) {

		//Check Athlete Class
		Athlete a1 = new Athlete("Daffy","Duck", 2000, 9, 7);
		
		//Check Runner Class
		Runner r5 = new Runner("Bugs","Bunny", 2000, 9, 8,"USA");
		r5.addEvent("M10000");
		ArrayList<String> temp = new ArrayList<String>(Arrays.asList("M100", "M3000"));
		r5.addEvent(temp);
				
		//Check Swimmer Class
		Swimmer s1 = new Swimmer("Franklin", "Missy", 1995, 5, 10, "Colorado Stars");
		s1.addEvent("100m backstroke");
		temp = new ArrayList<String>(Arrays.asList( "200m backstroke","200m freestyle"));
		
		//Check AthleteRoster		
		Swimmer s2 = new Swimmer("Ruele", "Naomi", 1997, 1, 13,"Florida International University");
		s2.addEvent(new ArrayList<String>(Arrays.asList("100m backstroke", "50m backstroke","100m freestyle")));

		Runner r1 = new Runner("Bolt", "Usain", 1986, 8, 21,"Jamaica");
		r1.addEvent("M100");
		r1.addEvent("M200");

		Runner r2 = new Runner("Griffith", "Florence", 1959, 12, 21,"United States of America");
		r2.addEvent("M100");
		r2.addEvent("M200");
		r2.addEvent("M400"); 
		r2.addEvent("M10000");
		r2.addEvent("M3000");
		r2.addEvent("M5000");
				
		AthleteRoster ar = new AthleteRoster("Fall",2019);
		ar.addAthlete(a1);
		ar.addAthlete(s1);
		ar.addAthlete(r1);
		ar.addAthlete(r2);
		ar.addAthlete(s2);
		ar.addAthlete(r5);
		System.out.println(ar.allRunnersOrderedByNumberOfEvents());
		System.out.println("=======================================\n");
		
		System.out.println(ar.allAthletesOrderedByAge());
		System.out.println("=======================================\n");
		
		System.out.println(ar.allAthletesOrderedByLastName());
		System.out.println("=======================================\n");
		
	}

}
