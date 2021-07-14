package assignment;

import java.util.ArrayList;
import java.util.Arrays;

public class RunnerDriver {
	public static void main(String args[]) {

		//Check Runner Class
		Runner r5 = new Runner("Bugs","Bunny", 2000, 9, 8,"USA");
		System.out.println("Did we add M10000 successfully?: "+r5.addEvent("M10000"));
		System.out.println("How many events does Bugs participate in?: "+r5.getEvents().size());
		System.out.println("Try to add M10000 again: "+r5.addEvent("m10000"));
		System.out.println("How many events does Bugs participate in?: "+r5.getEvents().size());
		ArrayList<String> temp = new ArrayList<String>(Arrays.asList("M100", "M3000"));
		System.out.println("Did we successfully add mutiple events?: "+r5.addEvent(temp));//true
		System.out.println("How many events does Bugs participate in?: "+r5.getEvents().size());
		System.out.println("Did we unsucessfully try to add mutiple events?: "+r5.addEvent(temp));//false
		System.out.println("How many events does Bugs participate in?: "+r5.getEvents().size());//3
		System.out.println("Output of our toString correct?: \n"+r5); 
		System.out.println("Did we add M10 successfully?: "+r5.addEvent("M10"));
		System.out.println("How many events does Bugs participate in?: "+r5.getEvents().size());
		System.out.println("Did we add M200 successfully?: "+r5.addEvent(" M200 "));
		System.out.println("How many events does Bugs participate in?: "+r5.getEvents().size());
		System.out.println("=======================================\n");
		
		
	}
}