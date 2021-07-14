package assignment;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class GSPayrollGUI extends Application{
	
	private EmployeeRoster bruhRoster = new EmployeeRoster();
	private ArrayList<Employee> bruhList = bruhRoster.getRoster();
	private Iterator<Employee> ie = bruhList.iterator();
	private File file;
	private int i = 0;
	
	//Text Fields
	private TextField first = new TextField();
	private TextField last = new TextField();
	private TextField id = new TextField();
	
	//Radio Buttons
	private RadioButton southern = new RadioButton("Southern University");
	private RadioButton eastern = new RadioButton("Eastern College");
	private RadioButton hourly = new RadioButton("Hourly Paid");
	private RadioButton monthly = new RadioButton("Monthly Paid");
	
	
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox bruh = new HBox(10);
		
		VBox left = new VBox();
		VBox right = new VBox();
		VBox center = new VBox(10);
		
		ImageView leftImage = new ImageView("https://www.crwflags.com/art/college/gasouth95037.jpg");
		leftImage.setFitWidth(300);
		leftImage.setFitHeight(175);
		
		left.getChildren().add(leftImage);
		right.getChildren().add(createButtons());
		center.getChildren().addAll(createLabelAndTextFields(), createSchoolTypeRadioButtons(), createPayTypeRadioButtons());
		
		bruh.getChildren().addAll(left, center, right);
		
		Scene scene = new Scene(bruh, 600, 200);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public HBox createPayTypeRadioButtons() {
		ToggleGroup pay = new ToggleGroup();
		hourly.setToggleGroup(pay);
		monthly.setToggleGroup(pay);
		
		HBox payType = new HBox();
		payType.getChildren().addAll(hourly, monthly);
		
		return payType;
	}

	public HBox createSchoolTypeRadioButtons() {
		
		ToggleGroup school = new ToggleGroup();
		southern.setToggleGroup(school);
		eastern.setToggleGroup(school);
		
		HBox schoolType = new HBox();
		schoolType.getChildren().addAll(southern, eastern);
		
		return schoolType;
	}

	public VBox createLabelAndTextFields() {
		Label firstName = new Label("First Name");
		Label lastName = new Label("Last Name");
		Label studentId = new Label("Student ID");
		
		HBox fn = new HBox();
		HBox ln = new HBox();
		HBox si = new HBox();
		
		fn.getChildren().addAll(firstName, first);
		ln.getChildren().addAll(lastName, last);
		si.getChildren().addAll(studentId, id);
		
		VBox txtLbl = new VBox(10);
		
		txtLbl.getChildren().addAll(fn, ln, si);
		
		return txtLbl;
	}

	public GridPane createButtons() {
		//Create Buttons
		Button load = new Button("LOAD");
		Button next = new Button("NEXT");
		Button clear = new Button("CLEAR");
		
		//Assign actions to each button
		//Action for load button
		load.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				FileChooser fc = new FileChooser(); //Creating a FileChooser Object
				file = fc.showOpenDialog(null);
				String filename = file.getAbsolutePath();
				bruhRoster.loadEmployeesFromFile(filename);
			}
		});
		
		//Action for next button
		next.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				bruhList = bruhRoster.getRoster();
				Employee bruh = bruhList.get(i);
				first.setText(((Student) bruh).getFname());
				last.setText(((Student) bruh).getLname());
				id.setText(((Student) bruh).getId());
				if (bruhList.get(i) instanceof SouthernStudentMth || bruhList.get(i) instanceof SouthernStudentHrly) {
					southern.setSelected(true);
				} else eastern.setSelected(true);
				if (bruhList.get(i) instanceof EasternStudentHrly || bruhList.get(i) instanceof SouthernStudentHrly) {
					hourly.setSelected(true);
				} else monthly.setSelected(true);
				
				i += 1;
			}
		});
		
		//Action for clear button
		clear.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				first.clear();
				last.clear();
				id.clear();
				southern.setSelected(false);
				eastern.setSelected(false);
				hourly.setSelected(false);
				monthly.setSelected(false);
				i = 0;
			}
		});
		
		GridPane buttonPane = new GridPane();
		buttonPane.add(load, 0, 0);
		buttonPane.add(next, 0, 1);
		buttonPane.add(clear, 0, 2);
		
		return buttonPane;
	}

}
