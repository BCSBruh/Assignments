package assignment;

public class EasternStudentHrly extends Student implements HourlyEmployee {
	//class fields
	private double hoursWorked;
	private double perHour;
	private String id;
	
	
	//constructor
	public EasternStudentHrly(String lName, String fName) {
		super(lName, fName);
	}
	
	
	//set the hourly pay rate for the student
	@Override
	public void setHourlyRate(double perHour) {
		this.perHour = perHour;
	}
	
	
	//returns the student id
	@Override
	public String getId() {
		return this.id;
	}
	
	
	//returns true if the id is of the correct pattern and update the field
	//The pattern is: Starts with A, B, C, D, E or F, followed by a digit,
	//followed by A, B, C, D, E or F, followed by a digit
	@Override
	public boolean addId(String id) {
		boolean temp = false;
		if (id.equals("")) {
			temp = false;
		} else if ((id.substring(0,1).equals("A") || id.substring(0,1).equals("B") || id.substring(0,1).equals("C") || 
				id.substring(0,1).equals("D") || id.substring(0,1).equals("E") || id.substring(0,1).equals("F")) && 
				(id.substring(2).equals("A") || id.substring(2).equals("B") || id.substring(2).equals("C") || 
				id.substring(2).equals("D") || id.substring(2).equals("E") || id.substring(2).equals("F"))) {
			for (int i = 1; i < 2; i++) {
				if ((id.substring(i, i+1).equals("0") ||id.substring(i, i+1).equals("1") || id.substring(i, i+1).equals("2") ||
						id.substring(i, i+1).equals("3") || id.substring(i, i+1).equals("4") || id.substring(i, i+1).equals("5") || 
						id.substring(i, i+1).equals("6") || id.substring(i, i+1).equals("7") || id.substring(i, i+1).equals("8") ||
						id.substring(i, i+1).equals("9")) && (id.substring(i+2).equals("0") ||id.substring(i+2).equals("1") || id.substring(i+2).equals("2") ||
						id.substring(i+2).equals("3") || id.substring(i+2).equals("4") || id.substring(i+2).equals("5") || 
						id.substring(i+2).equals("6") || id.substring(i+2).equals("7") || id.substring(i+2).equals("8") ||
						id.substring(i+2).equals("9"))) {
					temp = true;
				} else {
					temp = false;
				}
			}
		} else {
			temp = false;
		}
		if (temp == true) {
			this.id = id;
		}
		return temp;
	}
	
	
	//computes and returns the pay of the student
	//if hours below or equal max weekly hours, compute as hours * hourly rate
	//if hours exceed max weekly hours, compute the max weekly hours * hourly
	 // rate and add to
	//number of hours over max weekly hours * the overtime rate * hourly rate
	@Override
	public double getPay() {
		double total = 0;
		if (hoursWorked <= HourlyEmployee.MAX_WEEKLY_HOURS) {
			total = hoursWorked * perHour;
		} else if (hoursWorked > HourlyEmployee.MAX_WEEKLY_HOURS) {
			total = (HourlyEmployee.MAX_WEEKLY_HOURS * perHour)  + ((hoursWorked - HourlyEmployee.MAX_WEEKLY_HOURS)
					* HourlyEmployee.OVERTIME_RATE * perHour);
		}
		return total;
	}
	
	
	//sets the Student's total hours for the week
	@Override
	public void setTotalHoursForWeek(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}
	
	
	//returns a string similar to that shown in the assignment doc
	public String toString() {
		return "This is " + super.getFname() + " " + super.getLname() + " pay for the period is $" +
				String.format("%.2f", getPay());
	}
	
	
	//returns the hourly rate of pay
	@Override
	public double getHourlyRate() {
		return perHour;
	}
	
	
	//returns the total hours worked for the week
	@Override
	public double getTotalHoursForWeek() {
		return hoursWorked;
	}
}
