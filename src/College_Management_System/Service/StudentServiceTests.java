package College_Management_System.Service;

public class StudentServiceTests {

	public static void main(String[] args) {
		
		// Builds some demo students
		StudentService student1 = new StudentService(1234567, "Elad Jacobovitz");
		StudentService student2 = new StudentService(2222333, "Avi Nathan");
		StudentService student3 = new StudentService(3123906, "Sean Parker");
		
		// Add some courses to each student's course list
		CourseService course1 = new CourseService(1, "Machine Learning");
		CourseService course2 = new CourseService(2, "Lineare Algebra");
		CourseService course3 = new CourseService(3, "Data Structure");
		CourseService course4 = new CourseService(4, "Business Entrepreneurship");
		CourseService course5 = new CourseService(5, "Operating Systems");
		CourseService course6 = new CourseService(6, "Infi");
		
		// Define courses that can be taken
		student1.addCourse(course1, 90);
		student1.addCourse(course4, 85);
		student1.addCourse(course5, 91);
		
		student2.addCourse(course1, 88);
		student2.addCourse(course2, 85);
		student2.addCourse(course3, 91);
		student2.addCourse(course6, 82);
		
		student3.addCourse(course1, 81);
		student3.addCourse(course2, 85);
		student3.addCourse(course4, 96);
		student3.addCourse(course5, 79);
		student3.addCourse(course6, 83);
		
		// We will use the "get" function
		System.out.println(student1.getName() + ", " + student2.getName() + ", " + student3.getName());
		System.out.println(student1.getSid() + ", " + student2.getSid() + ", " + student3.getSid());
		System.out.println();

		// We will print the students grades in course number 1
		System.out.println("the students grades in " + course1.getTitle() + " course is:");
		System.out.println(student1.gradeInCourse(course1));
		System.out.println(student2.gradeInCourse(course1));
		System.out.println(student3.gradeInCourse(course1));
		System.out.println();

		// We will use the "tookCourse" function to find out if some student took a course or not
		if(student1.tookCourse(course5)) System.out.println(student1.getName() + " grade in " + course5.getTitle()
		+ " is: " + student1.gradeInCourse(course5));
		else System.out.println("didnt took this course.");
		System.out.println();
		
		// Print the student report (a list of courses that he took, his grades and etc.). 
		student2.studentReport();
		System.out.println();
		
		// We will try some negative tests and see what the output of those tests will be
		student2.gradeInCourse(course2);
		// We will remove course2 from student2 list and we will try to print his grade in it.
		student2.removecoursefromstudentlist(course2);
		student2.gradeInCourse(course2);
		System.out.println();
		
		// After we removed course number 2 from the student list we will print his 
		// report and see if the course still there
		student2.studentReport();		
	}
}
