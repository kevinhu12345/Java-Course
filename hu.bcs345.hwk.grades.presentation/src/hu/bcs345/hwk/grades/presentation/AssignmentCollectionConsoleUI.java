package hu.bcs345.hwk.grades.presentation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

import hu.bcs345.hwk.grades.business.AssignmentCollection;

/**
 * Contains AssignmentCollectionConsoleUI Class
 * 
 * @author Kevin
 *
 */
public class AssignmentCollectionConsoleUI
{
	private int choice;
	private AssignmentCollection as = new AssignmentCollection();
	
	/**
	 * Show UI.
	 */
	public void ShowUI()
	{
		Scanner s = new Scanner(System.in);
		String Collection = null, Output = null, output2 = null, name = "";
		int index = 0;
		Scanner AC = null;
		PrintStream AC2 = null, AC3 = null;
		AC3 = new PrintStream(System.out);
		choice = 0;

		while (choice != 7)
		{
			System.out.println("Assignment Collection UI");
			System.out.println("------------------------");
			System.out.println("1 � Read assignment collection from file");
			System.out.println("2 � Write assignment collection to file");
			System.out.println("3 � Show assignment by index");
			System.out.println("4 � Show assignment by name");
			System.out.println("5 � Show assignment collection as JSON string");
			System.out.println("6 - Show assignment collection report on screen");
			System.out.println("7 - Exit");
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
					as.Read(AC);
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
				as.Write(AC2);
			}
			if (choice == 3)
			{
				System.out.printf("Enter Index: ");
				index = s.nextInt();
				s.nextLine();
				try
				{
					System.out.println(as.GetByIndex(index));
				}
				catch (ArrayIndexOutOfBoundsException e)
				{
					System.err.println("ArrayIndexOutOfBoundsException found!");
				}
			}
			if (choice == 4)
			{
				System.out.printf("Enter Name: ");
				name = s.nextLine();
				if (as.GetByName(name)== null)
				{
					System.err.println("No Name Matches!");
				}
				else
				{
					System.out.println(as.GetByName(name));
				}
			}
			if (choice == 5)
			{
				System.out.println(as.toString());
			}
			if (choice == 6)
			{
				as.Report(AC3);
			}
			System.out.printf("\n\n\n");
		}
		//s.close();
	}
}
