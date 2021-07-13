package assignment;

public interface HourlyEmployee extends Employee{
	
	public final int MAX_WEEKLY_HOURS = 40;
	
	public final double OVERTIME_RATE = 1.50;
	
	public void setHourlyRate(double perHour);
	
	public void setTotalHoursForWeek(double hoursWorked);
	
	public double getHourlyRate();
	
	public double getTotalHoursForWeek();
	
	

}
