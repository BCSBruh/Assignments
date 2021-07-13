package assignment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SouthernStudentHrlyTest {

	@Test
	void testToString() {
		SouthernStudentHrly sh = new SouthernStudentHrly("Moment", "Bruh");
		sh.setHourlyRate(9);
		sh.setTotalHoursForWeek(10);
		String actual = sh.toString();
		String expected = "SOUTHERN NOT STATE!\nThis is Bruh Moment pay for the period is $90.00";
		assertEquals(expected, actual);
	}

	@Test
	void testGetId() {
		SouthernStudentHrly sh = new SouthernStudentHrly("Moment", "Bruh");
		sh.addId("S913111");
		String actual = sh.getId();
		String exptected = "S913111";
		assertEquals(exptected, actual);
	}

	@Test
	void testAddId() {
		SouthernStudentHrly sh = new SouthernStudentHrly("Moment", "Bruh");
		boolean actual = sh.addId("S913111");
		boolean exptected = true;
		assertEquals(exptected, actual);
	}

	@Test
	void testGetPay() {
		SouthernStudentHrly sh = new SouthernStudentHrly("Moment", "Bruh");
		sh.setHourlyRate(9);
		sh.setTotalHoursForWeek(10);
		double actual = sh.getPay();
		double expected = 90;
		assertEquals(expected, actual);
	}

	@Test
	void testGetHourlyRate() {
		SouthernStudentHrly sh = new SouthernStudentHrly("Moment", "Bruh");
		sh.setHourlyRate(9);
		double actual = sh.getHourlyRate();
		double expected = 9;
		assertEquals(expected, actual);
	}

	@Test
	void testGetTotalHoursForWeek() {
		SouthernStudentHrly sh = new SouthernStudentHrly("Moment", "Bruh");
		sh.setTotalHoursForWeek(10);
		double actual = sh.getTotalHoursForWeek();
		double expected = 10;
		assertEquals(expected, actual);
	}

}
