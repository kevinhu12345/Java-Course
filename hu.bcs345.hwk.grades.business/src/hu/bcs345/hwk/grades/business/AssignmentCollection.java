package hu.bcs345.hwk.grades.business;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Contains AssignmentCollection Class
 * 
 * @author Kevin
 *
 */
public class AssignmentCollection implements Iterable<Assignment>
{
	private int size = 3;
	private Assignment[] Assignments = new Assignment[size];
	private int index = 0;
	private double Gh = 0, Ge = 0, Gl = 0, Gq = 0, L = 0;
	private int H = 0, E = 0, Q = 0;

	/**
	 * Assignment Iterator.
	 * 
	 * @author Kevin
	 *
	 */
	public class AssignIter implements Iterator<Assignment>
	{
		/**
		 * Iterator hasNext.
		 */
		@Override
		public boolean hasNext() 
		{
			if (index < Assignments.length)
				return true;

			return false;
		}

		/**
		 * Iterator next.
		 */
		@Override
		public Assignment next() 
		{
			Assignment item = Assignments[index];
			index++;
			return item;

		}	
	}
	
	/**
	 * Default Constructor.
	 */
	public AssignmentCollection()
	{
		for (int i = 0; i < size; i++)
		{
			Assignments[i] = new Assignment();
		}
	}
	
	/**
	 * Get Array Size.
	 * 
	 * @return Array Size.
	 */
	public int getSize()
	{
		return size;
	}
	
	public Assignment[] getAssignment()
	{
		return Assignments;
	}
	
	/**
	 * Get Exam Average.
	 * @return Exam Average.
	 */
	public double getEMAVG()
	{
		return Ge / E;
	}
	
	/**
	 * Get Homework Average.
	 * @return Homework Average.
	 */
	public double getHWAVG()
	{
		return Gh / H;
	}
	
	/**
	 * Get Quiz Average.
	 * @return Quiz Average
	 */
	public double getQZAVG()
	{
		return Gq / Q;
	}
	
	/**
	 * Get Lab Average.
	 * @return Quiz Average
	 */
	public double getLBAVG()
	{
		return Gl / L;
	}
	
	/**
	 * GetByName Method.
	 * 
	 * @param name Name Searched.
	 * @return Assignment matching name.
	 */
	public Assignment GetByName(String name)
	{
		for (int i = 0; i < Assignments.length; i++)
		{
			if (Assignments[i].getName().equals(name))
			{
				return Assignments[i];
			}
		}
		return null;
	}
	
	/**
	 * GetByIndex Method.
	 * 
	 * @param index Index Searched.
	 * @return Assignment matching index.
	 */
	public Assignment GetByIndex(int index)
	{
		if (index > 0 && index <= Assignments.length)
		{
			index -=1;
			return Assignments[index];
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * Print to File.
	 *
	 * @param ps PrintStream
	 */
	public void Report(PrintStream ps)
	{
		ps.printf("%-20s%15s%10s\n", "Assignment", "Category", "Grade");
		ps.println("---------------------------------------------");
		for (int i = 0; i < Assignments.length; i++)
		{
			ps.printf("%-20s%15s%10s\n", Assignments[i].getName(), Assignments[i].getCategory(), Assignments[i].getGrade());
		}
		ps.println();
		ps.println("Category Summary");
		ps.println("----------------");
		ps.printf("%s: %.2f%%\n%s: %.2f%%\n%s: %.2f%%\n%s: %.2f%%\n\n", "Homework", Gh / H, "Exam", Ge / E, "Lab", Gl / L, "Quiz", Gq / Q);
	}
	
	/**
	 * Print to Console.
	 * 
	 * @param ps PrintStream.
	 */
	public void Write(PrintStream ps)
	{
		ps.println(size);
		for (int i = 0; i < Assignments.length; i++)
		{
			Assignments[i].Write(ps);
		}	
	}
	
	/**
	 * Read From File and calculate averages.
	 * 
	 * @param s Scanner.
	 */
	public void Read(Scanner s)
	{
		if (s.hasNextInt())
		{
			size = s.nextInt();
			s.nextLine();
			Assignments = new Assignment[size];
			for (int i = 0; i < size; i++)
			{
				Assignments[i] = new Assignment();
			}
		}
		
		for (int i = 0; i < size; i++)
		{
			Assignments[i].Read(s);
		}
		
		for (int i = 0; i < Assignments.length; i++)
		{
			if(new String(Assignments[i].getCategory()).equals("Homework") == true)
			{
				Gh += Assignments[i].getGrade();
				H +=1;
			}
			else if (new String(Assignments[i].getCategory()).equals("Exam") == true)
			{
				Ge += Assignments[i].getGrade();
				E += 1;
			}
			else if (new String(Assignments[i].getCategory()).equals("Lab") == true)
			{
				Gl += Assignments[i].getGrade();
				L += .01;
			}
			else if (new String(Assignments[i].getCategory()).equals("Quiz") == true)
			{
				Gq += Assignments[i].getGrade();
				Q += 1;
			}
		}
	}
	
	/**
	 * toString Override
	 */
	@Override
	public String toString()
	{
		String s = "[ " + Assignments[0].toString();
		for (int i = 1; i < Assignments.length; i++)
		{
			s += ", " + Assignments[i].toString();
		}
		s += " ]";
		return s;
	}

	/**
	 * Iterator Override.
	 */
	@Override
	public Iterator<Assignment> iterator() 
	{
		return new AssignIter();
	}
}
