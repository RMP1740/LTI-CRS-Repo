/**
 * 
 */
package com.lti.dao;

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

import com.lti.constant.SQLConstant;
import com.lti.ultis.DbUtils;

/**
 * @author 10710167
 *
 */
public class UserDaoImplementation implements UserDao {


	Connection conn = null;

	public List logincheck(String username, String userTypeName) {

		List userloginDetails = new ArrayList(3);

		PreparedStatement stmt = null;

		try{

			System.out.println("Connecting to database...");
			conn = DbUtils.getConnection();

			String sql = String.format(SQLConstant.USER_LOGIN, username);
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			
			if (!rs.isBeforeFirst()) 
			{    
				System.out.println("   No users have been added to the Application system for login!");
			}
			
			else {

				while (rs.next()) {
		
					//Retrieve by column name
					int eid  = rs.getInt("UserID");
					String name1 = rs.getString("username");
					String password1 = rs.getString("password");
					
					String sql1 = String.format(SQLConstant.USER_LOGIN_USERTYPE_CHECK, eid);
					stmt = conn.prepareStatement(sql1);
					ResultSet rs1 = stmt.executeQuery(sql1);
					
					rs1.next();
					String userTypeNameCheck = rs1.getString("Role");
					
					if(userTypeNameCheck.equals(userTypeName)) {
						userloginDetails.add(eid);
						userloginDetails.add(name1);
						userloginDetails.add(password1);
					}
					else {
						userloginDetails.add(null);
						userloginDetails.add(null);
						userloginDetails.add(null);
					}

				}
			}

			stmt.close();

		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}

		}//end try

		return userloginDetails;
	}


	public void resetPassword() {

		PreparedStatement stmt = null;

		Scanner input3 = new Scanner(System.in);

		System.out.print("  Enter your User ID: ");
		int newID = input3.nextInt();
		input3.nextLine();

		System.out.print("  Enter Username: ");
		String newName = input3.nextLine();

		System.out.print("  Enter New Password: ");
		String newPassword = input3.nextLine();

		System.out.print("");

		try{

			System.out.println("Connecting to database...");
			conn = DbUtils.getConnection();

			String sql = String.format(SQLConstant.RESET_PASSWORD , newPassword, newID, newName);
			stmt = conn.prepareStatement(sql);
			stmt.executeUpdate(sql);

			stmt.close();

		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}

		}//end try
	}
}
