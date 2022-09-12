/**
 * 
 */
package com.lti.exception;

/**
 * @author 10710166
 *
 */
public class NoStudentToCourse extends Exception {
	
	private int courseID;
	
	public NoStudentToCourse(int cid)
	{
		this.courseID = cid;
	} 
	public int getCid()
	{
		return courseID;
	}

}
