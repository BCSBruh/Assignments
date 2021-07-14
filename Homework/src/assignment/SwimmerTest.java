package assignment;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SwimmerTest {

	@Test
	public void testToString() {
		Athlete a = new Athlete("Bunny", "Bugs", 2000, 6, 20);
		Swimmer s = new Swimmer("Bunny", "Bugs", 2000, 6, 20, "Colorado Stars");
		s.addEvent("100m freestyle");
		String actual = s.toString();
		String expected = "Bugs Bunny is 21 years and 9 days old and is a swimmer for team: Colorado Stars in the following events: [100m freestyle]";
		assertEquals(expected, actual);
		
	}

	@Test
	public void testGetTeam() {
		Athlete a = new Athlete("Bunny", "Bugs", 2000, 6, 20);
		Swimmer s = new Swimmer("Bunny", "Bugs", 2000, 6, 20, "Colorado Stars");
		String actual = s.getTeam();
		String expected = "Colorado Stars";
		assertEquals(expected, actual);
	}

	@Test
	public void testAddEventString() {
		Swimmer s = new Swimmer("Bunny", "Bugs", 2000, 6, 20, "Colorado Stars");
		boolean actual = s.addEvent("100m freestyle");
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void testAddEventArrayListOfString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEvents() {
		Swimmer s = new Swimmer("Bunny", "Bugs", 2000, 6, 20, "Colorado Stars");
		s.addEvent("100m freestyle");
		ArrayList<String> actual = s.getEvents();
		String expected = "[100m freestyle]";
		assertEquals(expected, actual);
	}

}
