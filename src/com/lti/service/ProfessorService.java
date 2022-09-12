package com.lti.service;

import java.util.Scanner;
import com.lti.dao.ProfessorDaoImplementation;
import com.lti.exception.ExceptionPass;
import com.lti.exception.NoCourseToProfessor;
import com.lti.exception.NoStudentToCourse;

public class ProfessorService extends UserService implements ProfessorInterface {

	ProfessorDaoImplementation professor = new ProfessorDaoImplementation();

	@Override
	public void displayMyCourses(int userid) {

		try {
			professor.professorCourses(userid);
			//System.out.println("try works");

		}
		catch(NoCourseToProfessor e) {
			//System.out.println("catch works");
			System.out.println("\n  No course Available for Professor ID: " + e.getPid());
		}
		catch(ExceptionPass e) {
			
		}

	}

	@Override
	public void viewEnrolledStudents(int userid) {
		// TODO Auto-generated method stub
		try {
			professor.studentList(userid);
		}
		catch(NoStudentToCourse e) {
			System.out.println("catch works");
			System.out.println("\n  No Student/s Available for courseID: " + e.getCid());
		}
		catch(NoCourseToProfessor e) {
			System.out.println("catch works");
			System.out.println("\n  No course Available for Professor ID: " + e.getPid());
		}
		catch(ExceptionPass e) {
			
		}
	}

	@Override
	public void registerGrades(int userid) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);

		while(true) {

			System.out.println("\n Courses to Grade: ");
			displayMyCourses(userid);
			System.out.println("-------------------------------------------------------------------------------------------");

			System.out.print("   1: Add  Grade       ");
			System.out.println("2: Go Back");
			System.out.println("");
			System.out.print("    Choose any one: ");

			int i = input.nextInt();
			System.out.println("");

			switch(i) {


			case 1: System.out.println("        Courses available: ");
			System.out.println("");
			//		viewEnrolledStudents(userid,courseid);

			Scanner input1 = new Scanner(System.in);
			System.out.println("      Which course you want to add grade");
			System.out.print("      Enter Course ID: ");
			int courseid = input1.nextInt();
			professor.studentList(userid,courseid); //function overloaded
			System.out.print("      Enter Student ID: ");
			int sid = input1.nextInt();
			input1.nextLine();
			System.out.print("\n      Enter Grade: ");
			String grade = input1.nextLine();
			System.out.println("");

			professor.addgrade(courseid, sid, grade);	 


			break;

			case 2: System.out.println("  Going Back");
			break;


			}
			if (i==2) {
				break;
			}		



		}


	}
}
