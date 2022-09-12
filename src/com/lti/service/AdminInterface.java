/**
 * 
 */
package com.lti.service;

import com.lti.bean.Professor;
import com.lti.bean.Student;

/**
 * @author 10710167
 *
 */
public interface AdminInterface {
	
	public void courseList();
	public void addCourse();
	public void deleteCourse();
	
	public void courseCatalogue();
	public void professorList();
	public void addProfessor();
	
	public void studentList();
	public void generateReportCards();

	public void approveCourseRegistration();
	public void registerStudent();
}	

