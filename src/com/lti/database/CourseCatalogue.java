/**
 * 
 */
package com.lti.database;

import java.util.HashMap;
import com.lti.bean.Course;
import com.lti.bean.Professor;
import com.lti.bean.Student;

/**
 * @author 10710167
 *
 */
public class CourseCatalogue {
	private HashMap<Integer, Course> courseList;
	private HashMap<Integer, Professor> professorList;
	
	
	public CourseCatalogue() {
		this.courseList = new HashMap<Integer, Course>();
		this.professorList = new HashMap<Integer, Professor>();
	}
	
	
	public CourseCatalogue(HashMap<Integer, Course> courseList, HashMap<Integer, Professor> professorList) {
		this.courseList = courseList;
		this.professorList = professorList;
	}

	public CourseCatalogue(UserList userList) {
		this.courseList = new HashMap<Integer, Course>();
		this.professorList = new HashMap<Integer, Professor>();
		
		// Course Initialization
		Course[] courseArray = new Course[4];
		for(int i=0; i<courseArray.length; i++) {
			Course course = new Course();
			course.setID((i+1));
			course.setCourseName("Course "+(i+1));
			courseList.put((i+1), course);
			courseArray[i] = course;
		}
		
		// Course Matching to Professor As Done By Admin
		HashMap<String, Professor> professorMap = userList.getProfessorList();
		
		
		// We have 4 courses and 3 Professors Only
		for(int i=0; i<courseArray.length; i++) {
			Professor professor;
			if(i<3) {
				professor = professorMap.get("professor"+(i+1));
			}else {
				professor = professorMap.get("professor"+i);
			}
			addCourse(courseArray[i].getID(), courseArray[i], professor);
		}
		
		
		// Students(We have 5 students) enrolling in course.
		HashMap<String, Student> studentMap = userList.getStudentList();
		
		//Course1 Enrollment		
		Course course = courseArray[0];
		Professor professor = professorList.get(courseArray[0].getID());
		for(int i=1; i<=4; i++) {
			Student student = studentMap.get("student"+i);
			student.getCourses().put(course.getID(), course);
			professor.getStudentList(course.getID()).add(student);
		}
		
		//Course2 Enrollment		
		course = courseArray[1];
		professor = professorList.get(courseArray[1].getID());
		for(int i=2; i<=5; i++) {
			Student student = studentMap.get("student"+i);
			student.getCourses().put(course.getID(), course);
			professor.getStudentList(course.getID()).add(student);			
		}

		//Course3 Enrollment		
		course = courseArray[2];
		professor = professorList.get(courseArray[2].getID());
		for(int i=1; i<=5; i+=2) {
			Student student = studentMap.get("student"+i);
			student.getCourses().put(course.getID(), course);
			professor.getStudentList(course.getID()).add(student);			
		}
		
		//Course4 Enrollment		
		course = courseArray[3];
		professor = professorList.get(courseArray[3].getID());
		for(int i=3; i<=5; i++) {
			Student student = studentMap.get("student"+i);
			student.getCourses().put(course.getID(), course);
			professor.getStudentList(course.getID()).add(student);			
		}
		
	}
	
	public HashMap<Integer, Course> getCourseList() {
		return courseList;
	}

	
	public void setCourseList(HashMap<Integer, Course> courseCatalogue) {
		this.courseList = courseCatalogue;
	}
	
	public HashMap<Integer, Professor> getProfessorList(){
		return professorList;
	}
	
	public void setProfessorList(HashMap<Integer, Professor> professorList) {
		this.professorList = professorList;
	}
	
	public void addCourse(Integer courseID, Course course, Professor professor) {
		courseList.put(courseID, course);
		professorList.put(courseID, professor);
		course.setProfessorUserName(professor.getUsername());
		professor.getCourses().put(courseID, course);
	}
	
	public void removeCourse(Integer courseID) {
		Course course = courseList.get(courseID);
		course.setProfessorUserName("");
		
		Professor professor = professorList.get(courseID);
		professor.getCourses().remove(courseID);
		
		courseList.remove(courseID);
		professorList.remove(courseID);
		
	}
	
	public Course getCourse(Integer courseID) {
		return courseList.get(courseID);
	}
	
	public Professor getProfessor(Integer courseID) {
		return professorList.get(courseID);
	}
	
	
	
}
