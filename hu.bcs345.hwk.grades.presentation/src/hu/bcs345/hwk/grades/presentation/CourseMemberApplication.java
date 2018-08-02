package hu.bcs345.hwk.grades.presentation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

import hu.bcs345.hwk.grades.business.Assignment;
import hu.bcs345.hwk.grades.business.CourseMember;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class CourseMemberApplication extends Application
{
	private CourseMember course= new CourseMember();
	private FileChooser fc;
	private VBox vbox = new VBox();
	private VBox vboxStudentTab = new VBox(10);
	private VBox vboxGradeTab = new VBox(10);
	private HBox r1 = new HBox(20);
	private HBox r2 = new HBox(22);
	private HBox r3 = new HBox(66);
	private HBox r4 = new HBox(47);
	private ListView<Assignment> listView = new ListView<Assignment>();
	private MenuBar menuBar = new MenuBar();
	private Menu file = new Menu("File");
	private MenuItem open = new MenuItem("Open...");
	private MenuItem saveAs = new MenuItem("Save As...");
	private MenuItem exit = new MenuItem("Exit");
	private TabPane tabPane = new TabPane();
	private Tab student = new Tab("Student");
	private Tab grade = new Tab("Grade");
	private TextField first = new TextField();
	private TextField last = new TextField();
	private TextField id = new TextField();
	private TextField major = new TextField();
	private TextField exam = new TextField();
	private TextField homework = new TextField();
	private TextField quiz = new TextField();
	private TextField lab = new TextField();
	private TextField overall = new TextField();
	
	
	@Override
	public void start(Stage stage) throws Exception 
	{
		menuBar.getMenus().add(file);
		file.getItems().addAll(open, saveAs, exit);
		
		open.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent a) {

				fc = new FileChooser();
				fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text File", "*.txt"));
				fc.setInitialDirectory(new File("C:\\Users\\kevin\\Documents\\Eclipse-Workspace\\hu.bcs345.hwk.grades.presentation"));
				fc.setTitle("Open CourseMember File");
				File file = fc.showOpenDialog(stage);
				Scanner s = null;
				try 
				{
					s = new Scanner(new FileReader(file));
					course.Read(s);
					
					first.setText(course.getStudent().getFirst());
					last.setText(course.getStudent().getLast());
					id.setText(Integer.toString(course.getStudent().getId()));
					major.setText(course.getStudent().getMajor());
					exam.setText(String.format("%.2f", course.getAssignments().getEMAVG()));
					homework.setText(String.format("%.2f", course.getAssignments().getHWAVG()));
					quiz.setText(String.format("%.2f", course.getAssignments().getQZAVG()));
					lab.setText(String.format("%.2f", course.getAssignments().getLBAVG()));
					overall.setText(String.format("%.2f", (course.getAssignments().getEMAVG() + course.getAssignments().getHWAVG() 
							+ course.getAssignments().getQZAVG() + course.getAssignments().getLBAVG()) / 4));
					
					ObservableList<Assignment> oL = FXCollections.observableArrayList(course.getAssignments().getAssignment());
					listView.setItems(oL);										
				} 
				catch (FileNotFoundException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		
		tabPane.getTabs().addAll(student, grade);
		
		r1.getChildren().addAll(new Label("First Name"), first);
		r2.getChildren().addAll(new Label("Last Name"), last);
		r3.getChildren().addAll(new Label("ID"), id);
		r4.getChildren().addAll(new Label("Major"), major);
		vboxStudentTab.getChildren().addAll(r1, r2, r3, r4);
		student.setContent(vboxStudentTab);
		
		grade.setContent(listView);		
		
		vbox.getChildren().addAll(menuBar, tabPane);
		
		Scene scene = new Scene(vbox, 750, 750);
		stage.setScene(scene);
		stage.setTitle("Course");
		stage.setAlwaysOnTop(true);
		stage.show();
	}

}
