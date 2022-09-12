/**
 * 
 */
package com.lti.application;

import java.util.List;
import java.util.Scanner;

import com.lti.bean.Student;
import com.lti.bean.User;
import com.lti.dao.StudentDaoImplementation;
import com.lti.database.CourseCatalogue;
import com.lti.database.UserList;
import com.lti.service.StudentSerivce;

/**
 * @author 10710167
 *
 */
public class CRSMenuStudent {
	
	public void startup(List userDetails) {
		Scanner input = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("+ + + + + + + + + + + + + + + + + + + + + + + + +");
			System.out.println("+   Welcome to " + userDetails.get(1) + " Menu   +");
			System.out.println("+ + + + + + + + + + + + + + + + + + + + + + + + +\n");
			
			System.out.println();
			

			System.out.println("  1: View Registered Course");
			System.out.println("  2: Add or Drop Course");
			System.out.println("  3: Request Course Catalogue");
			System.out.println("  4: View Report Card");
			System.out.println("  5: Fee Payment");
			System.out.println("  6: Logout");
			
			System.out.print("\nChoose Option : ");
			int option = input.nextInt();
			StudentSerivce service = new StudentSerivce();
			
			switch(option) {
				case 1: System.out.println("\nCourse Registered for " + userDetails.get(1) + "  :");
						service.viewRegisteredCourses( (int) userDetails.get(0)); 
						break;
						
				case 2: System.out.println("\nOpening Add or Drop Course Menu");
						service.addDropCourse( (int) userDetails.get(0)); 
						break;
						
				case 3: System.out.println("Opening Course Catalouge Menu");
						service.displayAvailableCourses();
						break;
						
				case 4: System.out.println("Opening View Report Card Menu");
						service.displayReportCard((int) userDetails.get(0));
						break;
						
				case 5: System.out.println("Opening Fee Payment Menu");
						service.feePayment( (int) userDetails.get(0));
						break;
				
				case 6: System.out.println("Logout Successful !!");
						break;

				default: System.out.println("Choose optioin 1 to 6 only.");
			}
			
			System.out.println();
			if(option==6) break;						
		}
	}
}
