package assignment;

public abstract class Student {
	
	private String lname;
	private String fname;
	private double gpa;
	
	public Student(String lName, String fName) {
		this.lname = lName;
		this.fname = fName;
	}
	
	public void setFname(String fName) {
		this.fname = fName;
	}
	
	public void setLname(String lName) {
		this.lname = lName;
	}
	
	public String getFname() {
		return fname;
	}
	
	public String getLname() {
		return lname;
	}
	
	public String toString() {
		return "This is " + this.getFname() + " " + this.getLname();
	}
	
	public boolean equals(Object other) {
		return ((Student) other).getFname().equalsIgnoreCase(fname) && ((Student) other).getLname().equalsIgnoreCase(lname);
	}
	
	public abstract String getId();
	
	public abstract boolean addId(String id);
	
	public void setGpa(double gpa) {
		if(gpa > 4.0)this.gpa = 4.0;
		else if(gpa < 1) this.gpa = 1;
		else this.gpa = gpa;
	}
	
	public double getGpa() {
		return gpa;
	}
	
	

}
