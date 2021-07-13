package assignment;

public class SouthernStudentMth extends Student implements MonthlyEmployee {
	//class fields
	private double perMonth;
	private String id;
	
	
	//constructor
	public SouthernStudentMth(String lName, String fName) {
		super(lName, fName);
	}
	
	
	//returns the id
	@Override
	public String getId() {
		return this.id;
	}
	
	
	//returns true if the id is of the correct pattern and update the field
	//The pattern is: Starts with "S9", followed with either 1 or 2, followed by
	//either 3 or 4 and three (3) other numbers
	@Override
	public boolean addId(String id) {
		boolean temp = false;
		if (id.equals("")) {
			temp = false;
		} else if (id.substring(0,2).equals("S9") && (id.substring(2,3).equals("1") || id.substring(2,3).equals("2"))
				&& (id.substring(3,4).equals("3") || id.substring(3,4).equals("4"))) {
			for (int i = 4; i < id.length(); i++) {
				if (id.substring(i, i+1).equals("0") ||id.substring(i, i+1).equals("1") || id.substring(i, i+1).equals("2") ||
						id.substring(i, i+1).equals("3") || id.substring(i, i+1).equals("4") || id.substring(i, i+1).equals("5") || 
						id.substring(i, i+1).equals("6") || id.substring(i, i+1).equals("7") || id.substring(i, i+1).equals("8") ||
						id.substring(i, i+1).equals("9")) {
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
	
	
	//computes and return the pay as the perMonth plus a bonus equal to their GPA
	//(e.g 4.0 GPA = 4%, 1.0 GPA = 1%)
	@Override
	public double getPay() {
		return perMonth + (perMonth * (super.getGpa() / 100));
	}
	
	
	//returns a string similar to that shown in the assignment doc
	public String toString() {
		return "SOUTHERN NOT STATE!\nThis is " + super.getFname() + " " + super.getLname() + " with your " + 
	String.format("%.1f", super.getGpa()) + " GPA, your monthly pay is $" + String.format("%.2f", getPay());
	}
	
	
	//sets the value of the monthly pay. Should not allow negative value
	@Override
	public void setMonthlyPay(double perMonth) {
		if (perMonth < 0) {
		} else {
			this.perMonth = perMonth;
		}
	}
	
	
	//Returns the value of monthly pay
	@Override
	public double getMonthlyPay() {
		return this.perMonth;
	}

}
