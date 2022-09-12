/**
 * 
 */
package com.lti.application;

import java.util.List;
import java.util.Scanner;

import com.lti.bean.Admin;
import com.lti.bean.Professor;
import com.lti.bean.Student;
import com.lti.dao.StudentDaoImplementation;
import com.lti.dao.UserDaoImplementation;
import com.lti.database.CourseCatalogue;
import com.lti.database.UserList;
import com.lti.service.UserService;

/**
 * @author 10710167
 *
 */
public class CRSApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserList userList = new UserList();
		CourseCatalogue courseCatalogue = new CourseCatalogue(userList);
		Scanner input = new Scanner(System.in);
		
		while(true) {
			System.out.println("+ + + + + + + + + + + + + + + + + + + + + + + + +");
			System.out.println("+      Welcome to CRS Application Group 02      +");
			System.out.println("+ + + + + + + + + + + + + + + + + + + + + + + + +\n");
			
			System.out.println("  1. Login");
			System.out.println("  2. Student Registration");
			System.out.println("  3. Forget Password");
			System.out.println("  4. Exit");
		
			System.out.print("\nChoose Option : ");
			int option = input.nextInt();
			
			UserService service = new UserService();
			UserDaoImplementation userdao = new UserDaoImplementation();
			StudentDaoImplementation studentdao = new StudentDaoImplementation();
			
			switch(option) {
				case 1: System.out.println("==================( Login Page )=================\n");
						@SuppressWarnings("rawtypes") 
						List userDetails = service.login();
						System.out.println("=================================================\n");
						
						Integer userType;
						
						try {
							
							String username = (String) userDetails.get(1);
							//System.out.println(username);
							userType = (Integer) userDetails.get(3);
						}
						catch(Exception e) {
							userType = 4;
							break;
						}
						
						
						if(userType==4) break;
						switch(userType) {
							case 1: CRSMenuAdmin adminMenu = new CRSMenuAdmin();
									adminMenu.startup(userDetails);
									break;
							
							case 2: CRSMenuProfessor professorMenu = new CRSMenuProfessor();
									professorMenu.startup( (int) userDetails.get(0));
									break;
					
							case 3: CRSMenuStudent studentMenu = new CRSMenuStudent();
									studentMenu.startup(userDetails);
									break;
					
							default: System.out.println("");
						}
						break;
				
				
				case 2: System.out.println("============( Student Registration Page )===========\n");
						System.out.println("=================================================\n");
						System.out.println("");
						studentdao.newRegistration();
						System.out.println("\n\n       Student Registration Complete");
						System.out.println("       Wait for Approval Email");
						break;
						
				case 3: System.out.println("\n===============( Reset Password )===============\n");
						System.out.println("=================================================\n");
						userdao.resetPassword();
						System.out.println("\n\n       Password Reset Successfully");
						break;
						
				case 4: System.out.println("=========( Exited from CRS Application )=========\n");
						break;
						
				default: System.out.println("Choose option 1, 2, 3 or 4.");
			}
			
			if(option==4) break;			
		}
		input.close();
	}

}
