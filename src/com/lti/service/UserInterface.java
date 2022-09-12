/**
 * 
 */
package com.lti.service;

import java.util.List;

import com.lti.database.CourseCatalogue;
import com.lti.database.UserList;

/**
 * @author 10710167
 *
 */
public interface UserInterface {
	
	@SuppressWarnings("rawtypes")
	public List login();
	
	public void logout();
	
	//public void userRegistration();
	
	//public void userUpdatePassword();
	
	//public void requestCourseCatalogue();
	
	
}	
