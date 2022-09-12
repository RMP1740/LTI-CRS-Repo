/**
 * 
 */
package com.lti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Formatter;
import com.lti.constant.SQLConstant;
import com.lti.exception.ExceptionPass;
import com.lti.exception.NoCourseToProfessor;
import com.lti.exception.NoStudentToCourse;
import com.lti.ultis.DbUtils;

/**
 * @author 10710167
 *
 */
public class ProfessorDaoImplementation {

	Connection conn = null;

	public void professordetails(int userid) {

		PreparedStatement stmt = null;

		try {
			conn = DbUtils.getConnection();

			String sql = SQLConstant.SELECT_PROFESSOR_P+ userid;
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()){

				int pid  = rs.getInt("ProfessorID");
				String name1 = rs.getString("Name");
				String department1 = rs.getString("Department");

				System.out.println("ID   		: " + pid);
				System.out.println("Name		: " + name1);
				System.out.println("Department	: " + department1);
				System.out.println();

			}
			stmt.close();
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try {
				if(stmt!=null) stmt.close();
			}
			catch(SQLException se2){

			}
		}
		return;
	}

	//   Professor Courses Method
	public void professorCourses(int userid) throws NoCourseToProfessor, ExceptionPass {

		PreparedStatement stmt = null;

		try{

			conn = DbUtils.getConnection();

			String sql1 = SQLConstant.SELECT_CATALOGUE_P + userid;
			stmt = conn.prepareStatement(sql1);
			ResultSet rs1 = stmt.executeQuery(sql1);

			if(rs1.isBeforeFirst() ) {

				while(rs1.next()) {

					int cid1 =rs1.getInt("courseID");
					String sql = SQLConstant.SELECT_COURSE_P +cid1;
					stmt = conn.prepareStatement(sql);
					ResultSet rs = stmt.executeQuery(sql);

					while(rs.next()){
						int cid = rs.getInt("courseID");
						String cname = rs.getString("courseName");

						Formatter formatter = new Formatter();

						formatter.format("%88s\n", " --------------------------------------------------------------------------------------- ");		
						formatter.format("|%10s   |%12s     |\n", "Course ID", "Course Name");
						formatter.format("%88s\n", " --------------------------------------------------------------------------------------- ");
						formatter.format("|%10s   |%12s     |\n" , cid, cname);

						System.out.println(formatter);
					}
				} 
				//stmt.close();
			} else {
				//System.out.println("HERE No Courses avaialble for Professor ID " + userid);
				throw new ExceptionPass(); 
				}
		}
			catch(SQLException se){
				//se.printStackTrace();
				//System.out.println("HERE1");
				throw new ExceptionPass(); 				
			}
			catch(Exception e){
				//e.printStackTrace();
				//System.out.println("HERE2");
				throw new NoCourseToProfessor(userid);
				//throw new ExceptionPass(); 
			}

			finally {
				try {
					if(stmt!=null) stmt.close();
					//System.out.println("HERE3");
					//throw new NoCourseToProfessor(userid);
				}
				catch(SQLException se2){
					//System.out.println("HERE 4");
					

				}
			}
		}

		// Enrolled Students
		public void studentList(int userid) throws NoCourseToProfessor, NoStudentToCourse, ExceptionPass {

			PreparedStatement stmt = null;

			try{
	

				conn = DbUtils.getConnection();

				String sql = SQLConstant.SELECT_CATALOGUE_P + userid;
				stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery(sql);
				
				if(rs.isBeforeFirst() ) {

					int i=1;
					while(rs.next()){
						int cid = rs.getInt("courseID");
						System.out.println("======================================================================");
						System.out.println( i++ +"|| CoureseId : "+cid );
		
						sql = SQLConstant.SELECT_SEMESTER_P + cid;
						stmt = conn.prepareStatement(sql);
						ResultSet rs2 = stmt.executeQuery(sql);
						
						if(rs2.isBeforeFirst() ) {
		
							while(rs2.next()) {
								int sid = rs2.getInt("userID");
								System.out.println("     StudentId : "+sid );
							
						}
						}
							else {
								
								System.out.println("\n  No Student/s Available for courseID: " + cid);
							
						}
						
					}
					//stmt.close();
				}
				
				else {
					//System.out.println("COMING HERE");
					
					throw new ExceptionPass(); 
					}
				
			}
			catch(SQLException se){
				//se.printStackTrace();
				throw new ExceptionPass(); 	
			}
			catch(Exception e){
				//e.printStackTrace();
				//throw new ExceptionPass(); 
				//System.out.println("OUTSIDE");
				throw new NoCourseToProfessor(userid);
			}
			finally {
				try {
					if(stmt!=null) stmt.close();
					//throw new NoCourseToProfessor(userid);
					//throw new NoStudentToCourse(userid);
				}
				catch(SQLException se2){

				}
			}
		}

		public void studentList(int userid, int courseid) {

			PreparedStatement stmt = null;

			try{

				conn = DbUtils.getConnection();
				int i=1;
				System.out.println("======================================================================");
				System.out.println( i++ +"|| CoureseId : "+courseid );

				String sql = SQLConstant.SELECT_SEMESTER_P_A + courseid;
				stmt = conn.prepareStatement(sql);
				ResultSet rs2 = stmt.executeQuery(sql);

				int j=1;
				while(rs2.next()) {
					int sid = rs2.getInt("userID");
					System.out.println("----------------------------------------------------------------------");
					System.out.println( j++ +"|| StudentId : "+sid );
				}

				stmt.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally{
				try{
					if(stmt!=null) stmt.close();
				}
				catch(SQLException se2){

				}
			}
		}

		// grade marking
		public void addgrade(int courseid,int sid,String grade) {

			PreparedStatement stmt = null;
			try {

				System.out.println("Connection to database...");
				conn = DbUtils.getConnection();
				String sql;        
				sql= SQLConstant.SELECT_GRADE_P + sid + " AND courseID=" + courseid;
				stmt = conn.prepareStatement(sql);

				ResultSet rs = stmt.executeQuery(sql);
				//value available
				if (rs.isBeforeFirst()) {   
					System.out.println("----------------------------------------------------------------------");
					System.out.println("        Grade already marked!!");      
					return;
				}
				else {
					stmt.close();
					sql = SQLConstant.INSERT_GRADE_P;
					stmt = conn.prepareStatement(sql);
					stmt.setInt(1, sid);
					stmt.setInt(2, courseid);
					stmt.setString(3, grade);
					stmt.executeUpdate();
					System.out.println("----------------------------------------------------------------------");
					System.out.println("        Grade addition Successful");
				}
				stmt.close();

			}
			catch(SQLException se){
				se.printStackTrace();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally{
				try{
					if(stmt!=null) stmt.close();
				}
				catch(SQLException se2){
					// Do Nothing
				}
			}
		}
	}