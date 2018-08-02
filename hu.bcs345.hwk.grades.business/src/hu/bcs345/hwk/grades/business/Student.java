package hu.bcs345.hwk.grades.business;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Contains Student Class
 * 
 * @author Kevin
 *
 */
public class Student 
{
	private String m_first;
	private String m_last;
	private int m_id;
	private String m_major;
	
	/**
	 * Default Constructor
	 */
	public Student()
	{
		m_first = "John";
		m_last = "Doe";
		m_id = 100;
		m_major = "None";
	}
	
	/**
	 * Get first name.
	 * 
	 * @return First name.
	 */
	public String getFirst()
	{
		return m_first;
	}
	
	/**
	 * Get last name.
	 * 
	 * @return First name.
	 */
	public String getLast()
	{
		return m_last;
	}
	
	/**
	 * Get id.
	 * 
	 * @return ID.
	 */
	public int getId()
	{
		return m_id;
	}
	
	/**
	 * Get major.
	 * 
	 * @return Major.
	 */
	public String getMajor()
	{
		return m_major;
	}

	/**
	 * Set first name.
	 * 
	 * @param first Name to be changed.
	 */
	public void setFirst(String first)
	{
		m_first = first;
	}
	
	/**
	 * Set last name.
	 * 
	 * @param last Name to be changed.
	 */
	public void setLast(String last)
	{
		m_last = last;
	}
	
	/**
	 * Set ID.
	 * 
	 * @param id ID to be changed.
	 */
	public void setId(int id)
	{
		m_id = id;
	}
	
	/**
	 * Set Major.
	 * 
	 * @param major Major to be changed.
	 */
	public void setMajor(String major)
	{
		m_major = major;
	}
	
	public void Report(PrintStream ps)
	{
		ps.println("Course Member Report");
		ps.println("--------------------");
		ps.printf("First: %s\nLast: %s\nID: %d\nMajor: %s\n\n", m_first, m_last, m_id, m_major);
	}
	
	/**
	 * Write to file.
	 * 
	 * @param ps Output format.
	 */
	public void Write(PrintStream ps)
	{
		ps.println(m_first);
		ps.println(m_last);
		ps.println(m_id);
		ps.println(m_major);
		
	}
	
	/**
	 * Read in file.
	 * 
	 * @param s Read from source.
	 */
	public void Read(Scanner s)
	{
		m_first = s.nextLine();
		m_last = s.nextLine();
		m_id = s.nextInt();
		s.nextLine();
		m_major = s.nextLine();
	}	
	
	/**
	 * String Override
	 */
	@Override
	public String toString()
	{
		return "{ " + "\"First\":" + "\"" + m_first + "\", "+ "\"Last\":" + "\"" + m_last + "\", " + "\"ID\":" + m_id + ", " + "\"Major\":" + "\"" + m_major + "\" }, ";
	}
}
