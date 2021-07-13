package assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class EmployeeRoster {
	private ArrayList<Employee> roster = new ArrayList<Employee>();
	private int badRecords = 0;
	private int InvalidEmployeeType = 0;
	
	
	//Read from text file <<fileName>>, load to an Arraylist of Employees.
	// Each record is EmployeeType#Firstname#LastName#ID#GPA#Monthly pay or
	//Hourly Rate#Total hours per week
	//eg. SM#Bugs#Bunny#S913000#4.0#2000#
	//If the number of fields for a record is greater than 7,
	//throw an Exception. Include in the exception the message "Bad record"
	//Get each record and store as the appropriate employee object type
	//Employees are either SM - SouthernStudentsMth, SH - SouthernStudentHrly or
	//EH - EasternStudentHrly
	//Any other value for Employee, throw an Exception. Include in the exception
	//the message "Invalid Employee Type"
	//keep track of the number of "Invalid Employee Type" and "bad record"
	public void loadEmployeesFromFile(String fileName){
		//open file
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
		
			String line = br.readLine();
			String [] bruh;
			while (line != null) {
				bruh = line.split("#");
				if (bruh.length >= 7) {
					throw new Exception("bad record");
				}
				if (bruh[0].equals("SM")) {
					SouthernStudentMth sm = new SouthernStudentMth(bruh[2], bruh[1]);
					sm.setGpa(Double.parseDouble(bruh[4]));
					sm.setMonthlyPay(Integer.parseInt(bruh[5]));
					roster.add(sm);
				} else if (bruh[0].equals("SH")) {
					SouthernStudentHrly sh = new SouthernStudentHrly(bruh[2], bruh[1]);
					sh.setGpa(Double.parseDouble(bruh[4]));
					sh.setHourlyRate(Double.parseDouble(bruh[5]));
					sh.setTotalHoursForWeek(Integer.parseInt(bruh[6]));
					roster.add(sh);
				} else if (bruh[0].equals("EH")) {
					EasternStudentHrly eh = new EasternStudentHrly(bruh[2], bruh[1]);
					eh.setGpa(Double.parseDouble(bruh[4]));
					eh.setHourlyRate(Double.parseDouble(bruh[5]));
					eh.setTotalHoursForWeek(Integer.parseInt(bruh[6]));
					roster.add(eh);
				} else {
					throw new IllegalArgumentException("Invalid Employee Type");
				}
				line = br.readLine();
				br.close();
			}
		} catch (IllegalArgumentException type) {
			if (type.getMessage().equalsIgnoreCase("Invalid Employee Type")) {
				this.InvalidEmployeeType += 1;
			}
			
			type.getMessage();
		}catch (Exception records) {
			if (records.getMessage().equalsIgnoreCase("bad record")) {
				this.badRecords += 1;
			}
			
			records.getMessage();
			
		}
	}
	
	
	//calculate the total cost for payroll for this period for all employees
	//we only want the overall sum, not the individual employee pay listed
	public double computePayrollForAllEmployees() {
		double total = 0;
		for (int i = 0; i < roster.size(); i++) {
			total += roster.get(i).getPay();
		}
		return total;
	}
	
	
	//Find all the SouthernStudentsMth employees and write their toString to a
	//binary file
	public int saveSouthernStudentsMonthlyOnly(String fileName){		
		int temp = 0;
		
		try {
			FileOutputStream fos = new FileOutputStream(new File(fileName));
			
			for (int i = 0; i < roster.size(); i++) {
				if (roster.get(i) instanceof SouthernStudentMth) {
					temp += 1;
					fos.write(roster.get(i).toString().getBytes());
					fos.write("\n".getBytes());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	
	//returns the total number of bad records found when loading employee file
	public int getBadRecords() {
		return badRecords;
	}
	
	
	//returns the total number of invalid employees found when loading employee
	//file
	public int getInvalidEmployeeType() {
		return InvalidEmployeeType;
	}
	
	public ArrayList<Employee> getRoster() {
		return roster;
	}

}
