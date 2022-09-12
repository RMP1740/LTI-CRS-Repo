/**
 * 
 */
package com.lti.application;

import java.util.Scanner;
import com.lti.dao.ProfessorDaoImplementation;
import com.lti.service.ProfessorService;

/**
 * @author 10710167
 *
 */
public class CRSMenuProfessor {


	ProfessorDaoImplementation professor = new ProfessorDaoImplementation();


	public void startup(int userid) {

		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.println("+ + + + + + + + + + + + + + + + + + + + + + + + +");
			System.out.println("+           Welcome to Professor Menu           +");
			System.out.println("+ + + + + + + + + + + + + + + + + + + + + + + + +\n");

			professor.professordetails(userid);

			System.out.println("  1: Display My Course List");
			System.out.println("  2: Display Enrolled Students");
			System.out.println("  3: Allocate Grades for Courses");
			System.out.println("  4: Logout");

			System.out.print("\nChoose Option : ");
			int option = input.nextInt();

			ProfessorService service = new ProfessorService();

			switch(option) {
			case 1: 
				System.out.println("----------------------------------------------------------------------");
				System.out.println("My Course List: \n");
				//System.out.println("----------------------------------------------------------------------");

				service.displayMyCourses(userid);
				break;

			case 2: 
				System.out.println("----------------------------------------------------------------------");
				System.out.println("Coursewise Enrolled Student List: \n");
				//System.out.println("----------------------------------------------------------------------");

				service.viewEnrolledStudents(userid);
				break;

			case 3: 
				System.out.println("----------------------------------------------------------------------");
				System.out.println("Coursewise Grade Allocation for Students: \n");
				//System.out.println("----------------------------------------------------------------------");

				service.registerGrades(userid);
				break;

			case 4: System.out.println("Logout Successful !!");
			break;

			default: System.out.println("Choose optioin 1 to 4 only.");
			}

			System.out.println();
			if(option==4) break;						
		}	

	}		

}			
