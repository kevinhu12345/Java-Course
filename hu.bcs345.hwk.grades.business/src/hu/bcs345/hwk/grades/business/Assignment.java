package hu.bcs345.hwk.grades.business;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Contains Assignment Class
 * 
 * @author Kevin
 *
 */
public class Assignment 
{
	private String m_name;
	private double m_grade;
	private String m_category;
	
	/**
	 * Default Constructor
	 */
	public Assignment()
	{
		m_name = "Homework 1";
		m_grade = 100;
		m_category = "Homework";
	}
	
	/**
	 * Get Assignment name.
	 * 
	 * @return Assignment name.
	 */
	public String getName()
	{
		return m_name;
	}
	
	/**
	 * Get grade.
	 * 
	 * @return Grade.
	 */
	public double getGrade()
	{
		return m_grade;
	}
	
	/**
	 * Get category.
	 * 
	 * @return Category.
	 */
	public String getCategory()
	{
		return m_category;
	}
	
	/**
	 * Set Assignment name.
	 * 
	 * @param name Assignment name to be changed.
	 */
	public void setName(String name)
	{
		m_name = name;
	}
	
	/**
	 * Set grade.
	 * 
	 * @param grade Grade to be changed.
	 */
	public void setGrade(double grade)
	{
		m_grade = grade;
	}
	
	/**
	 * Set category.
	 * 
	 * @param category Category to be changed.
	 */
	public void setCategory(String category)
	{
		m_category = category;
	}
	
	/**
	 * Write to file.
	 * 
	 * @param ps Output format.
	 */
	public void Write(PrintStream ps)
	{
		ps.println(m_name);
		ps.println(m_grade);
		ps.println(m_category);
	}
	
	/**
	 * Read from file.
	 * 
	 * @param s Read from source.
	 */
	public void Read(Scanner s)
	{
		m_name = s.nextLine();
		m_grade = s.nextDouble();
		s.nextLine();
		m_category = s.nextLine();
	}

	/**
	 * String Override
	 */
	@Override
	public String toString()
	{
		return "{ " + "\"Assignment\":" + "\"" + m_name + "\", "+ "\"Category\":" + "\"" + m_category + "\", " + "\"Grade\":" + m_grade + " }";
	}
}
