/**
 * 
 */
package com.lti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.lti.constant.SQLConstant;
import com.lti.ultis.DbUtils;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

/**
 * @author 10710167
 *
 */
public class AdminDaoImplementation {

	Connection conn = null;

	public void displayCourseCatalogue() {

		PreparedStatement stmt = null;	

		try{

			conn = DbUtils.getConnection();

			String sql = SQLConstant.DISPLAY_CATALOUGE;
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();

			int colCount = rsmd.getColumnCount();
			for(int i=1; i<=colCount; i++) {
				System.out.print(rsmd.getColumnLabel(i)+"\t");
			}

			System.out.println();
			while(rs.next()){
				for(int i=1; i<=colCount; i++) {
					System.out.print(rs.getString(i)+"\t\t");
				}
				System.out.println();
			}

			stmt.close();
		}
		catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}
		catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}
		finally{
			//finally block used to close resources
			try{
				if(stmt!=null) stmt.close();
			}
			catch(SQLException se2){
				// nothing we can do
			}   
		}	
	}

	public void displayProfessorList() {

		PreparedStatement stmt = null;	

		try{

			conn = DbUtils.getConnection();

			String sql = SQLConstant.DISPLAY_PROFESSOR;
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();

			int colCount = rsmd.getColumnCount();
			for(int i=1; i<=colCount; i++) {
				System.out.print(rsmd.getColumnLabel(i)+"\t\t");
			}

			System.out.println();
			while(rs.next()){
				for(int i=1; i<=colCount; i++) {
					System.out.print(rs.getString(i)+"\t\t");
				}
				System.out.println();
			}
			stmt.close();

		}
		catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}
		catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}
		finally{

			//finally block used to close resources
			try{
				if(stmt!=null) stmt.close();
			}
			catch(SQLException se2){
				// nothing we can do
			}   
		}	
	}


	public void displayStudentList() {

		PreparedStatement stmt = null;	

		try{

			conn = DbUtils.getConnection();

			String sql = SQLConstant.DISPLAY_STUDENT;
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();

			int colCount = rsmd.getColumnCount();
			for(int i=1; i<=colCount; i++) {
				System.out.print(rsmd.getColumnLabel(i)+"\t\t");
			}

			System.out.println();
			while(rs.next()){
				for(int i=1; i<=colCount; i++) {
					System.out.print(rs.getString(i)+"\t\t");
				}
				System.out.println();
			}

			stmt.close();


		}
		catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}
		catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}
		finally{

			//finally block used to close resources
			try{
				if(stmt!=null) stmt.close();
			}
			catch(SQLException se2){
				// nothing we can do
			}   
		}	
	}


	public void displayCourseList() {

		PreparedStatement stmt = null;	

		try{

			conn = DbUtils.getConnection();

			String sql = SQLConstant.DISPLAY_COURSES;
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();

			int colCount = rsmd.getColumnCount();
			for(int i=1; i<=colCount; i++) {
				System.out.print(rsmd.getColumnLabel(i)+"\t");
			}

			System.out.println();
			while(rs.next()){
				for(int i=1; i<=colCount; i++) {
					System.out.print(rs.getString(i)+"\t\t");
				}
				System.out.println();
			}

			stmt.close();

		}
		catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}
		catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}
		finally{

			//finally block used to close resources
			try{
				if(stmt!=null) stmt.close();
			}
			catch(SQLException se2){
				// nothing we can do
			}   

		}	
	}

	public void addCourse(int courseID, String courseName, String courseDesc, int professorID, int fees) {

		PreparedStatement stmt = null;
		PreparedStatement stmt1 = null;		

		try{

			conn = DbUtils.getConnection();

			String sql = SQLConstant.INSERT_COURSE;
			String sql1 = SQLConstant.INSERT_CATALOUGE;
			stmt = conn.prepareStatement(sql);
			stmt1 = conn.prepareStatement(sql1);

			stmt.setInt(1, courseID);
			stmt.setString(2, courseName);
			stmt.setString(3, courseDesc);

			stmt1.setInt(1, courseID);
			stmt1.setInt(2, professorID);
			stmt1.setInt(3, fees);
			stmt1.setBoolean(4, true);

			int status = stmt.executeUpdate();
			int status1 = stmt1.executeUpdate();
			if(status > 0 && status1 > 0) {
				System.out.println("\nCourse added successfully !!!\n\n");
			}

			stmt.close();


		}
		catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}
		catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}
		finally{

			//finally block used to close resources
			try{
				if(stmt!=null) stmt.close();
			}
			catch(SQLException se2){
				// nothing we can do
			}   
		}	
	}

	public void addProfessor(int professorID, String username, String password, String name, String department, int age, String address, int mobileNumber, String gender, String role, String roleDesc) {

		PreparedStatement stmt = null;
		PreparedStatement stmt1 = null;		
		PreparedStatement stmt2 = null;

		try{

			conn = DbUtils.getConnection();

			String sql = SQLConstant.INSERT_USER_A;
			String sql1 = SQLConstant.INSERT_ROLE_A;
			String sql2 = SQLConstant.INSERT_PROFESSOR_A;

			stmt = conn.prepareStatement(sql);
			stmt1 = conn.prepareStatement(sql1);
			stmt2 = conn.prepareStatement(sql2);

			stmt.setInt(1, professorID);
			stmt.setString(2, password);
			stmt.setString(3, username);

			stmt1.setInt(1, professorID);
			stmt1.setString(2, role);
			stmt1.setString(3, roleDesc);

			stmt2.setInt(1, professorID);
			stmt2.setString(2, name);
			stmt2.setString(3, department); 
			stmt2.setInt(4, age);
			stmt2.setString(5, address);
			stmt2.setInt(6, mobileNumber);
			stmt2.setString(7, gender);

			int status = stmt.executeUpdate();
			int status1 = stmt1.executeUpdate();
			int status2 = stmt2.executeUpdate();

			if(status > 0 && status1 > 0 && status2 > 0) {
				System.out.println("\n Professor added successfully !!!\n\n");
			}

			stmt.close();
			stmt1.close();
			stmt2.close();


		}
		catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}
		catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}
		finally{

			//finally block used to close resources
			try{
				if(stmt!=null) stmt.close();
				if(stmt1!=null) stmt1.close();
				if(stmt2!=null) stmt2.close();
			}
			catch(SQLException se2){
				// nothing we can do
			}   
		}	
	}


	public void deleteCourse(int courseID) {

		PreparedStatement stmt = null;	

		try{

			conn = DbUtils.getConnection();

			String sql = SQLConstant.SELECT_COURSES + courseID + "'" ;
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);

			if(rs.next()) {
				sql = SQLConstant.DELETE_CATALOUGE + courseID + "'";
				stmt.executeUpdate(sql);


				sql = SQLConstant.DELETE_COURSES + courseID + "'";
				stmt.executeUpdate(sql);

				System.out.println("Course deleted successfully!!\n");
			}
			else {
				System.out.println("Record not found!!");
			}		   

			stmt.close();


		}
		catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}
		catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}
		finally{

			//finally block used to close resources
			try{
				if(stmt!=null) stmt.close();
			}
			catch(SQLException se2){
				// nothing we can do
			}   

		}	
	}


	public void courseApproval() {

		PreparedStatement stmt = null;	

		try{

			conn = DbUtils.getConnection();

			String sql = SQLConstant.SELECT_SEMESTER;
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);

			int approve = 0;
			Scanner input6 = new Scanner(System.in);

			System.out.println();
			while(rs.next()){
				int uid = rs.getInt("userID");
				int cid = rs.getInt("courseID");

				System.out.println(" Student: " + uid + " with Course: " + cid + "");
				System.out.println("\n  1: Approve     2: Don't Approve    3:  Go Back to Menu");
				System.out.print("\n  Choose any one: ");
				approve = input6.nextInt();

				if(approve == 1) {

					String sql1 = String.format(SQLConstant.UPDATE_SEMESTER, uid, cid);
					stmt = conn.prepareStatement(sql1);
					stmt.executeUpdate(sql1);

					System.out.println("\n  Course " + cid + " for student " + uid + "  approved Sucessfully \n");

				} else if (approve == 3) {
					break;
				} else if (approve == 2) {
					System.out.println("\n  Course " + cid + " for student " + uid + "  Not Approved \n");

				}
			}


			stmt.close();


		}
		catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}
		catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}
		finally{

			//finally block used to close resources
			try{
				if(stmt!=null) stmt.close();
			}
			catch(SQLException se2){
				// nothing we can do
			}   
		}	
	}

	public void generateReportCard(String ans) {

		if(ans.toLowerCase() == "no") return;

		PreparedStatement stmt = null;

		try{

			conn = DbUtils.getConnection();


			// Let us select all the records and display them.
			String sql = SQLConstant.UPDATE_REPORTCARD;
			stmt = conn.prepareStatement(sql);
			stmt.execute(sql);

			stmt.close();


		}
		catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}
		catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}
		finally{

			//finally block used to close resources
			try{
				if(stmt!=null) stmt.close();
			}
			catch(SQLException se2){
				// nothing we can do
			}   

		}	
	}



	@SuppressWarnings("resource")
	public void studentRegister() {
		// TODO Auto-generated method stub

		PreparedStatement stmt  = null;
		PreparedStatement stmt1 = null;	
		PreparedStatement stmt2 = null;
		PreparedStatement stmt3 = null;	
		PreparedStatement stmt4 = null;	

		try{

			conn = DbUtils.getConnection();

			String sql = SQLConstant.SELECT_REGISTRATION;
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);

			if (!rs.isBeforeFirst() ) {
				System.out.println("\n  No registeration Pending");
				return;
			}

			int approve = 0;
			Scanner input6 = new Scanner(System.in);

			System.out.println();
			while(rs.next()){

				int uid = rs.getInt("RegistrationID");
				String cid = rs.getString("name");
				String newUserName   = rs.getString("username");
				String newPassword   = rs.getString("password");
				String newAddress    = rs.getString("address");
				String newGender     = rs.getString("gender");
				String newDepartment = rs.getString("department");
				int newAge           = rs.getInt("age");
				int newMobile        = rs.getInt("mobileNumber");

				System.out.println(" Student: " + cid + " with Student ID: " + uid + "");
				System.out.println("\n  1: Approve Registration     2: Don't Approve Registration   3:  Go Back to Menu");
				System.out.print("\n  Choose any one: ");
				approve = input6.nextInt();

				if(approve == 1) {

					String sql1 = String.format(SQLConstant.INSERT_USER_B, uid, newUserName, newPassword);

					String sql2 = String.format(SQLConstant.INSERT_STUDENT_A, uid, cid, newDepartment, newMobile, newAddress, newGender, newAge);

					String sql3 = String.format(SQLConstant.DELETE_REGISTRATION, uid);

					String sql4 = String.format(SQLConstant.INSERT_ROLE_B, uid); 

					stmt1 = conn.prepareStatement(sql1);
					stmt1.executeUpdate(sql1);

					stmt2 = conn.prepareStatement(sql2);
					stmt2.executeUpdate(sql2);

					stmt3 = conn.prepareStatement(sql3);
					stmt3.executeUpdate(sql3);

					stmt4 = conn.prepareStatement(sql4);
					stmt4.executeUpdate(sql4);

					System.out.println("\n  Student " + cid + " for student " + uid + "  Registered Sucessfully \n");

				} else if (approve == 3) {
					break;
				} else if (approve == 2) {
					System.out.println("\n  Course " + cid + " for student " + uid + "  Not Approved \n");

				}
			}

			stmt.close();


		}
		catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}
		catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}
		finally{

			//finally block used to close resources
			try{
				if(stmt!=null) stmt.close();
			}
			catch(SQLException se2){

			}	
		}
	}

}
