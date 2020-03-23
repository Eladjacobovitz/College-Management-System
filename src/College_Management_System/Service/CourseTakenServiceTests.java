package College_Management_System.Service;

public class CourseTakenServiceTests {

	public static void main(String[] args) {
		
		//  Builds some demo courses.
		CourseService course1 = new CourseService(1, "Machine_Learning");
		CourseService course2 = new CourseService(2, "Lineare_Algebra");
		CourseTakenService coursetaken1 = new CourseTakenService(course1, 1);
		CourseTakenService coursetaken2 = new CourseTakenService(course2, 2);
		
		//We will define a new "taken course" and activate the existing functions on it
		CourseService tempcourse = coursetaken1.getCourse();
		System.out.println(tempcourse.toString());
		System.out.println(coursetaken2.getGrade());
	}
}
