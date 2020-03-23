package College_Management_System.Service;

public class CourseServiceTests {

public static void main(String []args) {
		//  Builds some demo courses. 	
		CourseService course1 = new CourseService(1, "Machine_Learning");
		CourseService course2 = new CourseService(2, "Lineare_Algebra");
		CourseService course3 = new CourseService(3, "Data_Structure");
		
		// print the number and the name of the each course
		System.out.println(course1.getCid() + " " + course1.getTitle() );
		System.out.println(course2.getCid() + " " + course2.getTitle() );
		System.out.println(course3.getCid() + " " + course3.getTitle() );
		
		// use the "toString function for each course
		System.out.println(course1.toString());
		System.out.println(course2.toString());
		System.out.println(course3.toString());	
	}

}
