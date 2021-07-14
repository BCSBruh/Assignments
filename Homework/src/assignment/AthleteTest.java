package assignment;

import static org.junit.Assert.*;

import org.junit.Test;

public class AthleteTest {

	@Test
	public void testGetFname() {
		Athlete a = new Athlete("Bunny", "Bugs", 2000, 6, 20);
		String actual = a.getFname();
		String expected = "Bugs";
		assertEquals(expected, actual);
	}

	@Test
	public void testGetLname() {
		Athlete a = new Athlete("Bunny", "Bugs", 2000, 6, 20);
		String actual = a.getLname();
		String expected = "Bunny";
		assertEquals(expected, actual);
	}

	@Test
	public void testComputeAge() {
		Athlete a = new Athlete("Bunny", "Bugs", 2000, 6, 20);
		String actual = a.computeAge();
		String expected = "21 years and 8 days";
		assertEquals(expected, actual);
	}

	@Test
	public void testDaysSinceBirth() {
		Athlete a = new Athlete("Bunny", "Bugs", 2000, 6, 20);
		long actual = a.daysSinceBirth();
		long expected = 7678;
		assertEquals(expected, actual);
	}

	@Test
	public void testToString() {
		Athlete a = new Athlete("Bunny", "Bugs", 2000, 6, 20);
		String actual = a.toString();
		String expected = "Bugs Bunny is 21 years and 8 days old";
		assertEquals(expected, actual);
	}

	@Test
	public void testEqualsObject() {
		Athlete a = new Athlete("Bunny", "Bugs", 2000, 6, 20);
		Athlete a2 = new Athlete("Bunny", "Bugs", 2000, 6, 20);
		boolean actual = a.equals(a2);
		boolean expected = true;
		assertEquals(expected, actual);
	}

}
