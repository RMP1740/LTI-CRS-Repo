package com.lti.service;

import com.lti.bean.Course;

public class CourseRegistrationService implements CourseRegistrationInterface {
	
	public void registerCourses(Course[] courses) {
		System.out.println("User registers course.");
	}
	
	public void addCourse(Course course) {
		System.out.println("User adds a course in registration list.");
	}
	
	public void removeCourse(Course course) {
		System.out.println("User removes a course from registration list.");
	}

}
