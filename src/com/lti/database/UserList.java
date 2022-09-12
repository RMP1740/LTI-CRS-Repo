/**
 * 
 */
package com.lti.database;

import java.util.HashMap;
import com.lti.bean.Admin;
import com.lti.bean.Professor;
import com.lti.bean.Student;
//import com.lti.bean.User;

/**
 * @author 10710167
 *
 */

//public class UserList {
//	private HashMap<String, User> userList;
//		
//	public UserList() {
//		this.userList = new HashMap<String, User>();
//	}
//	
//	
//	/**
//	 * @param userList
//	 */
//	public UserList(HashMap<String, User> userList) {
//		this.userList = userList;
//	}
//
//
//	/**
//	 * @return the userList
//	 */
//	public HashMap<String, User> getUserList() {
//		return userList;
//	}
//
//	
//	/**
//	 * @param userList the userList to set
//	 */
//	public void setUserList(HashMap<String, User> userList) {
//		this.userList = userList;
//	}
//
//	
//	public void addUser(String username, User user) {
//		 userList.put(username, user);
//	}
//	
//	
//	public void removeUser(String username) {
//		userList.remove(username);
//	}
//	
//	
//	public User getUser(String username) {
//		return userList.get(username);
//	}
//}


public class UserList {
	private HashMap<String, Admin> adminList;
	private HashMap<String, Professor> professorList;
	private HashMap<String, Student> studentList;
	
	public UserList() {
		this.adminList =  new HashMap<String, Admin>();
		this.professorList = new HashMap<String, Professor>();
		this.studentList = new HashMap<String, Student>();
		
		manualInitialization();
	}
	
	public void manualInitialization() {
		Admin[] adminArray = new Admin[2];
		Professor[] professorArray = new Professor[3];
		Student[] studentArray = new Student[5];
		
		// Creating Admins
		for(int i=0; i<adminArray.length; i++) {
			Admin admin = new Admin();
			admin.setUsername("admin"+(i+1));
			admin.setPassword("admin"+(i+1)+"@123");
			admin.setName("Admin "+(i+1));
			admin.setDepartment("Department "+(i+1));
			adminList.put(admin.getUsername(), admin);
			adminArray[i] = admin;
		}
		
		// Creating Professors
		for(int i=0; i<professorArray.length; i++) {
			Professor professor = new Professor();
			professor.setUsername("professor"+(i+1));
			professor.setPassword("professor"+(i+1)+"@123");
			professor.setName("Professor "+(i+1));
			professor.setDepartment("Department "+(i+1));
			professorList.put(professor.getUsername(), professor);
			professorArray[i] = professor; 
		}
		
		// Creating Students
		for(int i=0; i<studentArray.length; i++) {
			Student student = new Student();
			student.setUsername("student"+(i+1));
			student.setPassword("student"+(i+1)+"@123");
			student.setName("student "+(i+1));
			student.setDepartment("Department "+(i+1));
			studentList.put(student.getUsername(), student);
			studentArray[i] = student;
		}
	
	}
	
	
	
	public HashMap<String, Admin> getAdminList() {
		return adminList;
	}

	public void setAdminList(HashMap<String, Admin> adminList) {
		this.adminList = adminList;
	}

	public HashMap<String, Professor> getProfessorList() {
		return professorList;
	}

	public void setProfessorList(HashMap<String, Professor> professorList) {
		this.professorList = professorList;
	}

	public HashMap<String, Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(HashMap<String, Student> studentList) {
		this.studentList = studentList;
	}



	public void addAdmin(String username, Admin user) {
		adminList.put(username, user);
	}

	public void addProfessor(String username, Professor user) {
		professorList.put(username, user);
	}

	public void addStudent(String username, Student user) {
		studentList.put(username, user);
	}
		
	public void removeAdmin(String username) {
		adminList.remove(username);
	}

	public void removeProfessor(String username) {
		professorList.remove(username);
	}

	public void removeStudent(String username) {
		studentList.remove(username);
	}
	
	public void removeUser(String username, int userType) {
		switch(userType) {
			case 1: adminList.remove(username);
					break;
			
			case 2: professorList.remove(username);
					break;
					
			case 3: studentList.remove(username);
					break;
			
			default: System.out.println();
		}
	}
	
	public Admin getAdmin(String username) {
		return adminList.get(username);
	}
	
	public Professor getProfessor(String username) {
		return professorList.get(username);
	}
	
	public Student getStudent(String username) {
		return studentList.get(username);
	}
	
}