package hu.bcs345.hwk.grades.presentation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

import hu.bcs345.hwk.grades.business.Assignment;
import hu.bcs345.hwk.grades.business.AssignmentCollection;
import hu.bcs345.hwk.grades.business.CourseMember;
import hu.bcs345.hwk.grades.business.Student;
import javafx.application.Application;

/**
 * Contains Main program code
 * 
 * @author Kevin Hu
 *
 */
public class Main {

	/**
	 * Main Code
	 * 
	 * @param args .
	 */
	public static void main(String[] args) 
	{
//		//Classes
//		Student s = new Student();
//		Assignment a = new Assignment();
//		
//		//Scanner/Filereader/Output
//		PrintStream ps = null, pa = null;
//		Scanner inS = null, inA = null;
//		try
//		{
//			inS = new Scanner(new FileReader("Student.txt"));
//			inA = new Scanner(new FileReader("Assignment.txt"));
//			ps = new PrintStream("SAssignment2.txt");
//			pa = new PrintStream("AAssignment2.txt");
//		} 
//		catch (FileNotFoundException e)
//		{
//			System.err.println("File not found!");
//		}
//		
//		//Automated testing
//		String fname = "Mark", lname = "Teixeira", major = "Computer Systems";
//		int id = 100;
//		String aName = "Syllabus Quiz", category = "Quiz";
//		double grade = 80.0;
//		//Automated Set Test
//		String fname2 = "Steve", lname2 = "Martin", major2 = "Business";
//		int id2 = 152;
//		String aName2 = "Final", category2 = "Exam";
//		double grade2 = 95.0;
//		
//		//Test Student Class
//		s.Read(inS);
//		s.Write(ps);
//		if (fname.equals(s.getFirst())) 
//		{
//			System.out.println("Student Get First Name: Pass");
//		} 
//		else 
//		{
//			System.err.println("Student Get First Name: FAIL!");
//		}
//
//		if (lname.equals(s.getLast())) 
//		{
//			System.out.println("Student Get Last Name: Pass");
//		} 
//		else 
//		{
//			System.err.println("Student Get Last Name: FAIL!");
//		}
//		
//		if (id == s.getId()) 
//		{
//			System.out.println("Student Get ID: Pass");
//		} 
//		else 
//		{
//			System.err.println("Student Get ID: FAIL!");
//		}
//		
//		if (major.equals(s.getMajor())) 
//		{
//			System.out.println("Student Get Major: Pass");
//		} 
//		else 
//		{
//			System.err.println("Student Get Major: FAIL!");
//		}
//		
//		//Student Set Test
//		s.setFirst("Steve");
//		s.setLast("Martin");
//		s.setId(152);
//		s.setMajor("Business");
//		if (fname2.equals(s.getFirst())) 
//		{
//			System.out.println("Student Set First Name: Pass");
//		} 
//		else 
//		{
//			System.err.println("Student Set First Name: FAIL!");
//		}
//
//		if (lname2.equals(s.getLast())) 
//		{
//			System.out.println("Student Set Last Name: Pass");
//		} 
//		else 
//		{
//			System.err.println("Student Set Last Name: FAIL!");
//		}
//		
//		if (id2 == s.getId()) 
//		{
//			System.out.println("Student Set ID: Pass");
//		} 
//		else 
//		{
//			System.err.println("Student Set ID: FAIL!");
//		}
//		
//		if (major2.equals(s.getMajor())) 
//		{
//			System.out.println("Student Set Major: Pass");
//		} 
//		else 
//		{
//			System.err.println("Student Set Major: FAIL!");
//		}
//		
//		Scanner inS2 = null;
//		try
//		{
//			inS2 = new Scanner(new FileReader("SAssignment2.txt"));
//		}
//		catch (FileNotFoundException e)
//		{
//			System.err.println("Student Read/Write Method Fail!");
//		}
//		
//		System.out.printf("%s\n\n", s.toString());
//		
//		//Test Assignment Class
//		a.Read(inA);
//		a.Write(pa);
//		if (aName.equals(a.getName())) 
//		{
//			System.out.println("Student Get Assignment Name: Pass");
//		} 
//		else 
//		{
//			System.err.println("Student Get Assignment Name: FAIL!");
//		}
//
//		if (grade == a.getGrade()) 
//		{
//			System.out.println("Student Get Grade: Pass");
//		} 
//		else 
//		{
//			System.err.println("Student Get Grade: FAIL!");
//		}
//			
//		if (category.equals(a.getCategory())) 
//		{
//			System.out.println("Student Get Category: Pass");
//		} 
//		else 
//		{
//			System.err.println("Student Get Category: FAIL!");
//		}
//
//		//Assignment Set Test
//		a.setName("Final");
//		a.setCategory("Exam");
//		a.setGrade(95);
//		if (aName2.equals(a.getName())) 
//		{
//			System.out.println("Student Set Assignment Name: Pass");
//		} 
//		else 
//		{
//			System.err.println("Student Set Assignment Name: FAIL!");
//		}
//
//		if (grade2 == a.getGrade()) 
//		{
//			System.out.println("Student Set Grade: Pass");
//		} 
//		else 
//		{
//			System.err.println("Student Set Grade: FAIL!");
//		}
//			
//		if (category2.equals(a.getCategory())) 
//		{
//			System.out.println("Student Set Category: Pass");
//		} 
//		else 
//		{
//			System.err.println("Student Set Category: FAIL!");
//		}
//		
//		Scanner inA2 = null;
//		try
//		{
//			inA2 = new Scanner(new FileReader("AAssignment2.txt"));
//		}
//		catch (FileNotFoundException e)
//		{
//			System.err.println("Student Read/Write Method Fail!");
//		}
//		
//		System.out.printf("%s\n\n", a.toString());
//		
		//Assignment 3
		AssignmentCollectionConsoleUI AsCol = new AssignmentCollectionConsoleUI();
		CourseMemberConsoleUI course = new CourseMemberConsoleUI();
		int choice = 0;
		Scanner c3 = new Scanner(System.in);
		
		//Console UI
		while (choice != 4)
		{
			System.out.println("Choose UI");
			System.out.println("---------");
			System.out.println("1 - AssignmentCollectionConsoleUI");
			System.out.println("2 - CourseMemberConsoleUI");
			System.out.println("3 - CourseMemberApplication");
			System.out.println("4 - Exit");
			System.out.printf("Enter Choice: ");
			choice = c3.nextInt();
			c3.nextLine();
			
			switch (choice) 
			{
			case 1:
				AsCol.ShowUI();
				break;
			case 2:
				course.ShowUI();
				break;
			case 3:
				Application.launch(CourseMemberApplication.class);
				break;
			default:
				break;
			}
			
		}
		c3.close();
	}
}
