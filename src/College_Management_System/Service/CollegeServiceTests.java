package College_Management_System.Service;

public class CollegeServiceTests {
	
	// Builds a demo college, populated with some demo courses and students.
	private static CollegeService buildCollege() {
		CollegeService course = new CollegeService("Berkeley School of Music");
		
		course.addCourse(1,"Arranging for Songwriters");
		course.addCourse(2,"Musical Theory");
		course.addCourse(3,"Basic Ear Training");
		course.addCourse(4,"Artist Management");
		course.addCourse(5,"Improvisation");
		
		course.addStudent(0,"Prince");
		course.addStudent(1,"Lady Gaga");
		course.addStudent(2,"Bob Dylan");
		course.addStudent(3,"Shakira");
		course.addStudent(4,"Paul McCartney");
		course.addStudent(5,"Shawn Mendes");

		course.addCourseTaken(1,1, 80);  
		course.addCourseTaken(1,2, 90);  
		course.addCourseTaken(1,3,100); 
		course.studentReport(1);
		course.addCourseTaken(1,1, 78);
		course.studentReport(1);
		course.addCourseTaken(2,1,100);  
		course.addCourseTaken(2,2, 80);
		course.addCourseTaken(3,1, 70);                              
		course.addCourseTaken(3,3, 70); 
		
		return course;
	}
	

public static void main(String []args) {
		//  Builds a demo college, populated with some demo courses and students. 	
		CollegeService college = buildCollege();
		
		college.coursesList();     // Print all the courses that are available
		
		college.studentsList();    // Print all print all college students 
		
		college.removeStudent(0);  // Removes the first student in the list
		college.removeStudent(4);  // Removes a student somewhere inside the list
		college.removeStudent(5);  // Removes the last student in the list
		
		college.studentsList();    // Prints the students after the removals
		college.removeCourse(1);
		
		college.coursesList();	  // We remove course number 1 and now we will see if the course exist
		college.courseReport(1);  // Print all college students who took course number 1
		college.removeCourse(1);  

		college.studentReport(1);	
		System.out.println();	
		college.studentReport(2); 	
		System.out.println();
		college.courseReport(2);
		college.topPerfomerReport(2);
		System.out.println();	
		
		// we will try to print the reports on courses that are not listed and 
		// we will see if the system has been updated and give appropriate output
		college.courseReport(1);	
		college.printSize(1);  		
		college.topPerfomerReport(1);
	}	
}
