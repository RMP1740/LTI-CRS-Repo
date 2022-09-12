/**
 * 
 */
package com.lti.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lti.dao.StudentDaoImplementation;
import com.lti.dao.UserDaoImplementation;

/**
 * @author 10710167
 *
 */
public class StudentSerivce extends UserService implements StudentInterface{
	
	StudentDaoImplementation studentservice = new StudentDaoImplementation();
	
	
	public void displayAvailableCourses() {
		
		studentservice.courseAvailabilityCheck();
	}
	
		
	public void displayReportCard(int studentID) {
		
		studentservice.courseGradeCheck(studentID);
		
	}
    
	public void viewRegisteredCourses(int studentID) {
		
		studentservice.displayRegisteredCourse(studentID);
    }
	
	@Override
	public void addDropCourse(int studentID) {	
		
		Scanner input = new Scanner(System.in);

		while(true) {
			
			System.out.println("\n Currently Registered Courses: ");
			viewRegisteredCourses(studentID);
			System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println("                                    ADD or Remove");	
		
		System.out.print("   1: Add         ");
		System.out.print("2: Remove         ");
		System.out.println("3: Go Back");
		System.out.println("");
		System.out.print("    Choose any one: ");
		
		int i = input.nextInt();
		System.out.println("");
		
		switch(i) {
		
		
		case 1: System.out.println("        Courses available: ");
		System.out.println("");
		displayAvailableCourses();
		
		Scanner input1 = new Scanner(System.in);
		System.out.println("      Which course you want to add");
		System.out.print("      Enter Course ID: ");
		int addcourse = input1.nextInt();
		System.out.print("\n      Enter Semester: ");
		int sem = input1.nextInt();
		System.out.println("");
		studentservice.addCourse(studentID, addcourse, sem);	
		System.out.println("  Course addition Successful");
		
		break;
		
		case 2: System.out.println("      Which course you want to Remove");
		System.out.print("      Enter Course ID:  ");
		Scanner input2 = new Scanner(System.in);
		int removecourse = input2.nextInt();
		System.out.println("");
		studentservice.removeCourse(studentID, removecourse);	
		System.out.println("  Course Removed Successful");
		
		
		break;
		
		case 3: break;
		
        
    }
		if (i==3) {
			break;
		}		
		
}
				
		
	}
	
	
    public void feePayment(int studentID) {
        System.out.println(" \n\n         Fee Payment Page\n");
        
        int totalFee = studentservice.calculateFee(studentID);
        
        if(totalFee!=0) {
        	
        	studentservice.paymentDetails(studentID, totalFee);
        }
    }


	
}

   
