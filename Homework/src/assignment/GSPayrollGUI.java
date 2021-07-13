package assignment;

import java.util.Iterator;
import java.util.List;

import javafx.application.Application;
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
import javafx.stage.Stage;

public class GSPayrollGUI extends Application{
	
	private EmployeeRoster bruhRoster = new EmployeeRoster();
	private List<Employee> bruhList = bruhRoster.getRoster();
	private Iterator<Employee> ie = bruhList.iterator();
	
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

	private HBox createPayTypeRadioButtons() {
		RadioButton hourly = new RadioButton("Hourly Paid");
		RadioButton monthly = new RadioButton("Monthly Paid");
		
		ToggleGroup pay = new ToggleGroup();
		hourly.setToggleGroup(pay);
		monthly.setToggleGroup(pay);
		
		HBox payType = new HBox();
		payType.getChildren().addAll(hourly, monthly);
		
		return payType;
	}

	private HBox createSchoolTypeRadioButtons() {
		RadioButton southern = new RadioButton("Southern University");
		RadioButton eastern = new RadioButton("Eastern College");
		
		ToggleGroup school = new ToggleGroup();
		southern.setToggleGroup(school);
		eastern.setToggleGroup(school);
		
		HBox schoolType = new HBox();
		schoolType.getChildren().addAll(southern, eastern);
		
		return schoolType;
	}

	private VBox createLabelAndTextFields() {
		TextField first = new TextField();
		TextField last = new TextField();
		TextField id = new TextField();
		
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

	private GridPane createButtons() {
		Button load = new Button("LOAD");
		Button next = new Button("NEXT");
		Button clear = new Button("CLEAR");
		
		GridPane buttonPane = new GridPane();
		buttonPane.add(load, 0, 0);
		buttonPane.add(next, 0, 1);
		buttonPane.add(clear, 0, 2);
		
		return buttonPane;
	}
	

}
