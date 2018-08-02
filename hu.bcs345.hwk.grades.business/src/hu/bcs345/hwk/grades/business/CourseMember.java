package hu.bcs345.hwk.grades.business;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Contains CourseMember Class.
 * 
 * @author Kevin
 *
 */
public class CourseMember 
{
	private Student students;
	private AssignmentCollection assignments;
	
	/**
	 * Default Constructor
	 */
	public CourseMember()
	{
		students = new Student();
		assignments = new AssignmentCollection();
	}
	
	/**
	 * Set Student.
	 * @param s Student to set.
	 */
	public void setStudent(Student s)
	{
		students = s;
	}
	
	/**
	 * Set Assignment Collection.
	 * @param a Assignment Collection to set.
	 */
	public void setAssignments(AssignmentCollection a)
	{
		assignments = a;
	}
	
	/**
	 * Get Student.
	 * 
	 * @return Returns Student.
	 */
	public Student getStudent()
	{
		return students;
	}
	
	/**
	 * Get Assignment Array.
	 * 
	 * @return Returns Assignment Array.
	 */
	public AssignmentCollection getAssignments()
	{
		return assignments;
	}
	
	/**
	 * Write to file.
	 * 
	 * @param ps Output as raw data.
	 */
	public void Write(PrintStream ps)
	{
		students.Write(ps);
		assignments.Write(ps);
	}
	
	/**
	 * Read from file.
	 * 
	 * @param s Input File.
	 */
	public void Read(Scanner s)
	{
		students.Read(s);
		assignments.Read(s);
	}
	
	/**
	 * Write to file as report.
	 * 
	 * @param ps Output File.
	 */
	public void Report(PrintStream ps)
	{
		students.Report(ps);
		assignments.Report(ps);
	}
	
	/**
	 * toString Override
	 */
	@Override
	public String toString()
	{
		return "{ \"Student\": " + students.toString() + "\"Assignments\": " + assignments.toString() + " }";
	}
}
