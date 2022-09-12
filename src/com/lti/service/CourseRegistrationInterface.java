/**
 * 
 */
package com.lti.service;

import com.lti.bean.Course;

/**
 * @author 10710167
 *
 */
public interface CourseRegistrationInterface {
	public void registerCourses(Course[] courses);
	
	public void addCourse(Course course);	
	
	public void removeCourse(Course course);
}
