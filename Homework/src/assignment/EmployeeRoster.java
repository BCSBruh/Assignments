package assignment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRoster {

	private static ArrayList<Employee> roster =  new ArrayList<Employee>();
	private int badRecords = 0;
	private int InvalidEmployeeType;
	
	//Read from text file <<fileName>>, load to an Arraylist of Employees.
	//Employees are ethier SM - SouthernStudentsMth, SH - SouthernStudent or
	//
	public void loadEmployeesFromFile(String fileName) {
		try {
			List<String> allEmployees = Files.readAllLines(Path.of(fileName));
			for(int i = 0; i < allEmployees.size(); i++) {
				try {
					String[] oneEmployee = allEmployees.get(i).split("#");
					if(oneEmployee.length < 7) throw new Exception("Bad record");
					else {
						if(oneEmployee[0].equalsIgnoreCase("SM")) {
							SouthernStudentMth ssm = new SouthernStudentMth(oneEmployee[1], oneEmployee[2]);
							ssm.addId(oneEmployee[3]);
							ssm.setGpa(Double.parseDouble(oneEmployee[4]));
							ssm.setMonthlyPay(Double.parseDouble(oneEmployee[5]));
							roster.add(ssm);
						}
						else if(oneEmployee[0].equalsIgnoreCase("SH")) {
							SouthernStudentHrly ssh = new SouthernStudentHrly(oneEmployee[1], oneEmployee[2]);
							ssh.addId(oneEmployee[3]);
							ssh.setGpa(Double.parseDouble(oneEmployee[4]));
							ssh.setHourlyRate(Double.parseDouble(oneEmployee[5]));
							ssh.setTotalHoursForWeek(Integer.parseInt(oneEmployee[6].trim()));
							roster.add(ssh);
						}
						else if(oneEmployee[0].equalsIgnoreCase("EH")) {
							EasternStudentHrly esh = new EasternStudentHrly(oneEmployee[1], oneEmployee[2]);
							esh.addId(oneEmployee[3]);
							esh.setGpa(Double.parseDouble(oneEmployee[4]));
							esh.setHourlyRate(Double.parseDouble(oneEmployee[5]));
							esh.setTotalHoursForWeek(Integer.parseInt(oneEmployee[6].trim()));
							roster.add(esh);
						}else throw new Exception("Invalid Employee Type");
					}
				}catch (Exception e) {
					if(e.getMessage().equalsIgnoreCase("Bad record")) this.badRecords++;
					if(e.getMessage().equalsIgnoreCase("Invalid Employee Type")) this.InvalidEmployeeType++;
				}
			}
		} catch (IOException e) {
			System.out.println("We had a problem locating the file");
			System.exit(1);
		}
	}
	
	public double computePayrollForAllEmployees() {
		double total = 0.0;
		for(int i=0; i < roster.size(); i++) {
			total += roster.get(i).getPay(); 
		}
		return total;
	}
	
	public int saveSouthernStudentsMonthlyOnly(String fileName) {
		int result = 0;
		if(Files.exists(Path.of(fileName))) {
			System.out.println("Cannot overwrite an existing file!");
			return -1;
		}else {
			try {
				Files.createFile(Path.of(fileName));
				for(int i = 0; i <roster.size(); i++) {
					if(roster.get(i) instanceof SouthernStudentMth) {
							Files.write(Path.of(fileName),roster.get(i).toString().getBytes(),StandardOpenOption.APPEND);
							result++;
					}
				}
			} catch (IOException e) {
				System.out.println("We had a problem locating the file");
				System.exit(1);
			}
		}
		return result;
	}

	public int getBadRecords() {
		return badRecords;
	}

	public int getInvalidEmployeeType() {
		return InvalidEmployeeType;
	}

	public ArrayList<Employee> getRoster() {
		return roster;
	}
	
}
