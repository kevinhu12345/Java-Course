package hu.bcs345.hwk.grades.presentation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

import hu.bcs345.hwk.grades.business.Assignment;
import hu.bcs345.hwk.grades.business.CourseMember;

/**
 * Contains CouseMemberConsoleUI Class
 * 
 * @author Kevin
 *
 */
public class CourseMemberConsoleUI 
{
	private int choice;
	private CourseMember c = new CourseMember();
	
	/**
	 * Show UI
	 */
	public void ShowUI()
	{
		Scanner s = new Scanner(System.in);
		String Collection = null, Output = null, name = "";
		int index = 0;
		Scanner AC = null;
		PrintStream AC2 = null, AC3 = null;
		AC3 = new PrintStream(System.out);
		
		while (choice != 6)
		{
			System.out.println("Course Member UI");
			System.out.println("----------------");
			System.out.println("1 � Read Course Member file");
			System.out.println("2 � Write Course Member to file");
			System.out.println("3 � Show course member report on screen");
			System.out.println("4 � Show course member JSON on screen");
			System.out.println("5 � Show AssignmentCollection using for-each");
			System.out.println("6 - Exit");
			System.out.printf("Enter Choice: ");
			choice = s.nextInt();
			s.nextLine();
			
			if (choice == 1)
			{
				System.out.printf("Enter File Name: ");
				Collection = s.nextLine();
				try 
				{
					AC = new Scanner(new FileReader(Collection));
					c.Read(AC);
				} 
				catch (FileNotFoundException e)
				{
					System.out.println("No File Found!");
				}
			}
			if (choice == 2)
			{
				System.out.printf("Enter Output File Name: ");
				Output = s.nextLine();
				try 
				{
					AC2 = new PrintStream(Output);
				} 
				catch (FileNotFoundException e)
				{
					System.err.println("No File Found!");
				}
				c.Write(AC2);
			}
			if (choice == 3)
			{
				c.Report(AC3);
			}
			if (choice == 4)
			{
				System.out.println(c.toString());
			}
			if (choice == 5)
			{
				for (Assignment s1 : c.getAssignments())
				{
					System.out.println(s1);
				}
			}
			System.out.printf("\n\n\n");
		}
	}
}
