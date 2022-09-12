/**
 * 
 */
package com.lti.exception;

/**
 * @author 10710130
 *
 */

public class NoCourseToProfessor extends Exception {

	private int professorID;

	public NoCourseToProfessor(int pid)
	{
		this.professorID = pid;
		//System.out.println("\n  No course Available for ");
	} 
	public int getPid()
	{
		return professorID;
	}

}


