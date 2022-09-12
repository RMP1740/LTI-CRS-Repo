/**
 * 
 */
package com.lti.application;

import java.util.List;
import java.util.Scanner;

import com.lti.bean.Admin;
import com.lti.bean.User;
import com.lti.database.CourseCatalogue;
import com.lti.database.UserList;
import com.lti.service.AdminService;
import com.lti.service.ProfessorService;

/**
 * @author 10710167
 *
 */
public class CRSMenuAdmin {
	
	public void startup(List userDetails) {
		Integer adminID = (int) userDetails.get(0);
		String adminUserName = (String) userDetails.get(1);
		String adminPassword = (String) userDetails.get(2);
		
		Scanner input = new Scanner(System.in);
		
		while(true) {
			System.out.println("+ + + + + + + + + + + + + + + + + + + + + + + + +");
			System.out.println("+             Welcome to Admin Menu             +");
			System.out.println("+ + + + + + + + + + + + + + + + + + + + + + + + +\n");
			
			System.out.println("ID   		: " + adminID);
			System.out.println("Username	: " + adminUserName);
			System.out.println();
			
			System.out.println("   1: View Course List");
			System.out.println("   2: Add Course to List");
			System.out.println("   3: Delete Course from List");
			System.out.println("   4: Approve Course Registrations\n");
			
			System.out.println("   5: Course Catalogue");
			System.out.println("   6: View Professor List");
			System.out.println("   7: Add Professor to List\n");
			
			System.out.println("   8: View Student List");
			System.out.println("   9: Add Student to List");
			System.out.println("  10: Generate Report Card\n");
			
			System.out.println("  11: Logout");
			
			
			System.out.print("\nChoose Option : ");
			int option = input.nextInt();
			AdminService service = new AdminService();
			
			switch(option) {
				case 1: System.out.println("Opening Course List\n");
						service.courseList();
						break;
				
				case 2: System.out.println("Opening Add Course Menu\n");
						service.addCourse();
						break;
				
				case 3: System.out.println("Opening Delete Course Menu\n");
						service.deleteCourse();
						break;
						
				case 4: System.out.println("Opening Courses Registration Menu");
						service.approveCourseRegistration();
						break;
						
				case 5: System.out.println("Opening Assign Course Menu");
						service.courseCatalogue();
						break;
				
				case 6: System.out.println("Opening Professor List\n");
						service.professorList();
						break;
						
				case 7: System.out.println("Opening Add Professor Menu");
						service.addProfessor();
						break;
				
				case 8: System.out.println("Opening Student List");
						service.studentList();
						break;
				
				case 9: System.out.println("Opening Add Student Menu");
						service.registerStudent();
						break;
				
				case 10: System.out.println("Opening Generate Report Cards Menu");
						service.generateReportCards();
						break;	
						
				case 11: System.out.println("Logout Successful !!");
						 break;
						
				default: System.out.println("Choose optioin 1 to 11 only.");
			}
			
			System.out.println();
			if(option==11) break;						
		}
		
	}
	
}
