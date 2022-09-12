package com.lti.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.lti.bean.Admin;
import com.lti.bean.Course;
import com.lti.bean.Professor;
import com.lti.bean.Student;
import com.lti.bean.User;
import com.lti.dao.UserDaoImplementation;
import com.lti.database.CourseCatalogue;
import com.lti.database.UserList;

public class UserService extends CourseRegistrationService implements UserInterface {

	Scanner input = new Scanner(System.in);
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List login() {
		
		// to return username and userType
		
		List userdetails = new ArrayList(4); 
		
	
		String username = "";
		Integer userType;
		String userTypeName;
		
		while(true) {
			System.out.println("User Type: ");
			System.out.println("  1. Admin");
			System.out.println("  2. Professor");
			System.out.println("  3. Student");
		
			System.out.print("\nChoose User Type: ");
			userType = input.nextInt();
			if(userType>=1 && userType<=3) break;
			System.out.println("Incorrect User Type.");
		} 
		
		if(userType == 1) {
			userTypeName = "Admin";
		}
		else if(userType == 2) {
			userTypeName = "Professor";
		}
		else {
			userTypeName = "Student";
		}
		//System.out.println(userTypeName);
		
		while(true) {
			System.out.print("Enter Username: ");
			username = input.next();
			
			System.out.print("Enter Password: ");
			String password = input.next();
		
			//User user = null;
			
			/*
			switch(userType) {
				case 1: user = userList.getAdmin(username);
						break;
					
				case 2: user = userList.getProfessor(username);
						break;
					
				case 3: user = userList.getStudent(username);
						break;
			
				default: System.out.println();
			}
			*/
			
			
			UserDaoImplementation student_table = new UserDaoImplementation();
			userdetails = student_table.logincheck(username, userTypeName);
			String userName;
			String userPassword;
			
			
			try {
				userName = (String) userdetails.get(1);
				userPassword = (String) userdetails.get(2);
			}
			catch(Exception e) {
				userName = null;
				userPassword = null;
			}
			
			
			
			if(userName == null) {
				System.out.println("\nUserID not found !!");
				System.out.println("Kindly register before login.");
				userType = 4; // Default value to Exit out from login page	
				break;
			}
			else {
				//if(password.equals(user.getPassword())) {
				if(password.equals(userPassword)) {
					System.out.println("\nLogin Sucessful !!");
					//username = usernamecheck(userID);
					//System.out.println(username);
					break;
				}else {
					System.out.println("\nIncorrect password !!\n");
					System.out.println("You want to try again?");
					System.out.print("Enter (Yes/No) : ");
					String ans = input.next();
					if(ans.toLowerCase().equals("no")) {
						userType = 4; // Default value to Exit out from login page
						break;
					}
					System.out.println();
				}
			}
		}
		
		//System.out.println(username);
		//returnList.add(userName);
		//returnList.add(userType);
		userdetails.add(userType);
		
		return userdetails;
	}
	
	public void logout() {
		System.out.println("\nLogout successful !!");
	}
	
	/*
	public void userRegistration() {
		int userType;
		
		while(true) {
			System.out.println("User Type: ");
			System.out.println("  1. Admin");
			System.out.println("  2. Professor");
			System.out.println("  3. Student");

			System.out.print("\nChoose User Type: ");
			userType = input.nextInt();
			if(userType>=1 && userType<=3) break;
			System.out.println("Incorrect User Type.");
		} 
		
		while(true) {
			if(userType == 1) {
				System.out.print("Enter Admin Passkey For Registration: ");
				String passkey = input.next();
			
				if(passkey.equals("0000")) {
					System.out.println("Passkey Accepted !!\n");
					break;
				}else {
					System.out.println("Wrong Passkey !!");
					System.out.print("You want to try again? (Yes/No)");
					String ans = input.next();
					if(ans.toLowerCase().equals("no")) {
						System.out.println("=================================================\n");
						return;
					}
				}
			}else break;
		}
		
		String username;
		while(true) {
			System.out.print("Create Username: ");
			username = input.next();
			
			User user = null;
			switch(userType) {
				case 1: user = userList.getAdmin(username);
						break;
					
				case 2: user = userList.getProfessor(username);
						break;
					
				case 3: user = userList.getStudent(username);
						break;
			
				default: System.out.println();
			}
			
			if(user != null) {
				System.out.println("Username already exists !!.");
				System.out.println("Try using a different username.");
			}else break;
		}
		
		System.out.print("Create Password: ");
		String password = input.next();
		
		while(true) {
			System.out.print("Confirm Password: ");
			String confirmPassword = input.next();

			if(!password.equals(confirmPassword)) {
				System.out.println("\nPasswords does not match !!\n");
			}else {
				
				System.out.println("\nUser Account Created Successfully !!");
				
				System.out.println("Enter the following details for successful registraion: \n");
				
				System.out.print("  Name: ");
				String name = input.next();
				
				System.out.print("  Department: ");
				String department = input.next();
				
				switch(userType) {
					case 1: Admin adminUser = new Admin();
							adminUser.setName(name);
							adminUser.setUsername(username);
							adminUser.setPassword(password);
							adminUser.setDepartment(department);
							userList.addAdmin(username, adminUser);
							break;
					
					case 2: Professor professorUser = new Professor();
							professorUser.setName(name);
							professorUser.setUsername(username);
							professorUser.setPassword(password);
							professorUser.setDepartment(department);
							userList.addProfessor(username, professorUser);
							break;
					
					case 3: Student studentUser = new Student();
							studentUser.setName(name);
							studentUser.setUsername(username);
							studentUser.setPassword(password);
							studentUser.setDepartment(department);
							userList.addStudent(username, studentUser);
							break;
					
					default: System.out.println();
				}
				System.out.println("\nUser Registration Successful !!");
				return;
			}
		}
				
	}
	
	public void userUpdatePassword() {
		int userType;
		
		while(true) {
			System.out.println("User Type: ");
			System.out.println("  1. Admin");
			System.out.println("  2. Professor");
			System.out.println("  3. Student");

			System.out.print("\nChoose User Type: ");
			userType = input.nextInt();
			if(userType>=1 && userType<=3) break;
			System.out.println("Incorrect User Type.");
		} 
		
		while(true) {
			if(userType == 1) {
				System.out.print("Enter Admin Passkey For Updation: ");
				String passkey = input.next();
			
				if(passkey.equals("0000")) {
					System.out.println("Passkey Accepted !!\n");
					break;
				}else {
					System.out.println("Wrong Passkey !!");
					System.out.print("You want to try again? (Yes/No)");
					String ans = input.next();
					if(ans.toLowerCase().equals("no")) {
						System.out.println("=================================================\n");
						return;
					}
				}
			}else break;
		}
		
		System.out.print("Enter Username: ");
		String username = input.next();
		
		User user = null;
		switch(userType) {
			case 1: user = userList.getAdmin(username);
					break;
					
			case 2: user = userList.getProfessor(username);
					break;
					
			case 3: user = userList.getStudent(username);
					break;
			
			default: System.out.println();
		}
		
		
		while(true) {
			System.out.print("Enter Old Password: ");
			String oldPassword = input.next();
			
			if(user.getPassword().equals(oldPassword)) {
				System.out.println();
				break;
			}
			
			System.out.println("\nWrong Passowrd !!\n");
			System.out.println("You want to try again?");
			System.out.print("Enter (Yes/No) : ");
			String ans = input.next();
			System.out.println();
			if(ans.toLowerCase().equals("no")) return;
		}
		
		
		while(true) {
			System.out.print("Create New Passowrd: ");
			String newPassword = input.next();
			
			System.out.print("Confirm New Password: ");
			String confirmPassword = input.next();

			if(!newPassword.equals(confirmPassword)) {
				System.out.println("Passwords does not match !!\n");
			}else {
				user.setPassword(newPassword);
				System.out.println("\nPassword Updated Successfully !!");
				return;
			}
		}

	}
	
	public void requestCourseCatalogue() {
//		System.out.println("User requests course catalogue.");
		
//		Logic to allow or not the courseCatalgoue
		
		
//		Display Course Catalgoue
		Formatter formatter = new Formatter();
		
		formatter.format("%88s\n", " --------------------------------------------------------------------------------------- ");		
		formatter.format("|%10s   |%12s   |%14s   |%15s   |%17s   |\n", "Sr. No.", "Course ID", "Course Name", "Professor ID", "Professor Name");
		formatter.format("%88s\n", " --------------------------------------------------------------------------------------- ");
		
		HashMap<Integer, Course> courseList = courseCatalogue.getCourseList();
		HashMap<Integer, Professor> professorList = courseCatalogue.getProfessorList();
		
		int i=1;
		for(Map.Entry<Integer, Course> mapElement : courseList.entrySet()) {	
			Integer courseID = mapElement.getKey();
			Course course = mapElement.getValue();
			Professor professor = professorList.get(courseID);
			formatter.format("|%10s   |%12s   |%14s   |%15s   |%17s   |\n", i++, courseID, course.getCourseName(), professor.getUsername(), professor.getName());

		}

		formatter.format("%88s\n", " --------------------------------------------------------------------------------------- ");
		
		System.out.println(formatter);
	}
}

	
*/
}