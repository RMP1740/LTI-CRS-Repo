/**
 * 
 */
package com.lti.service;

import java.util.Map;

import com.lti.bean.Professor;

/**
 * @author 10710167
 *
 */
public interface ProfessorInterface {
		
	public void displayMyCourses(int userid);
	
	public void viewEnrolledStudents(int userid);
	
	public void registerGrades(int userid);

}
