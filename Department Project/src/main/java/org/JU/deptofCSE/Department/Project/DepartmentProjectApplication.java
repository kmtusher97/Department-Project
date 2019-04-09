package org.JU.deptofCSE.Department.Project;

import org.JU.deptofCSE.Department.Project.model.syllabus.Course;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DepartmentProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentProjectApplication.class, args);

		Course course = new Course();
		course.setCourseCode("CSE 101");
		System.out.println(course.getCourseCodeNumber());
	}

}
