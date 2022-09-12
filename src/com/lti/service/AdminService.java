/**
 * 
 */
package com.lti.service;
import java.util.Scanner;

import com.lti.bean.*;
import com.lti.dao.AdminDaoImplementation;


public class AdminService extends UserService implements AdminInterface {
	Scanner input = new Scanner(System.in);
	AdminDaoImplementation adminDao = new AdminDaoImplementation();
	
	@Override
	public void courseList() {
		// TODO Auto-generated method stub
		adminDao.displayCourseList();
	}

	@Override
	public void addCourse() {
		
		System.out.println("Current Course Catalogue: \n");
		adminDao.displayCourseCatalogue();
		System.out.println();
		
		System.out.println("Current Course List: \n");
		courseList();
		System.out.println();
		
		System.out.println("Current Professor List: \n");
		professorList();
		System.out.println();	
		
		System.out.println("Give Following Information: \n");
		
		System.out.print("Course ID: ");
		int courseID = input.nextInt();
			
		System.out.print("Course Name: ");
		String courseName = input.next();
		input.nextLine();
			
		System.out.print("Course Description: ");
		String courseDesc = input.nextLine();
			
		System.out.print("ProfessorID: ");
		int professorID = input.nextInt();
			
		System.out.print("Course Fees: ");
		int fees = input.nextInt();
			
		adminDao.addCourse(courseID, courseName, courseDesc, professorID, fees);
	
	}

	@Override
	public void deleteCourse() {
		// TODO Auto-generated method stub
		System.out.println("Current Course List: \n");
		courseList();
		
		System.out.println("Enter course IDs for the courses to be deleted: \n");
		
		System.out.print("Course ID: ");
		int courseID = input.nextInt();
						
		adminDao.deleteCourse(courseID);
		
	}


//	@Override
	public void courseCatalogue() {
		// TODO Auto-generated method stub
		System.out.println("Current Course Catalogue: \n");
		adminDao.displayCourseCatalogue();
		System.out.println();
		
		System.out.println("Current Course List: \n");
		courseList();
		System.out.println();
		
		System.out.println("Current Professor List: \n");
		professorList();
		System.out.println();
	
	}

	@Override
	public void professorList() {
		// TODO Auto-generated method stub
		adminDao.displayProfessorList();
	}

	@Override
	public void addProfessor() {
		// TODO Auto-generated method stub
		System.out.println("Current Professor List: \n");
		professorList();
		System.out.println();	
		
		System.out.println("Give Following Information: \n");
		
		System.out.print("Professor ID: ");
		int professorID = input.nextInt();
		
		System.out.print("Username: ");
		String username = input.next();
		
		System.out.print("Password: ");
		String password = input.next();
		input.nextLine();
		
		System.out.print("Name: ");
		String name = input.nextLine();
		
		System.out.print("Department: ");
		String department = input.nextLine();
		
		System.out.print("Age: ");
		int age = input.nextInt();
		input.nextLine();
		
		System.out.print("Address: ");
		String address = input.nextLine();
		
		System.out.print("Mobile Number: ");
		int mobileNumber = input.nextInt();
		
		System.out.print("Gender: ");
		String gender = input.next();
		
		String role = "Professor";
		String roleDesc = "This is Professor.";
		
		adminDao.addProfessor(professorID, username, password, name, department, age, address, mobileNumber, gender, role, roleDesc);
	}

	@Override
	public void studentList() {
		// TODO Auto-generated method stub
		adminDao.displayStudentList();
	}

	@Override
	public void generateReportCards() {
		// TODO Auto-generated method stub
		System.out.print("You want to generate report cards (Yes/No): ");
		String ans = input.next();
		

		adminDao.generateReportCard(ans);
		
	}
	
	
	@Override
	public void registerStudent() {
		// TODO Auto-generated method stub
		adminDao.studentRegister();
		
		
	}
	@Override
	public void approveCourseRegistration() {
		// TODO Auto-generated method stub
		
		adminDao.courseApproval();
		
	}
	
}
