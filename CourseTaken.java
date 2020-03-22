/**
 * Represents pairs of Course object and grade.
 */
public class CourseTaken {

	private Course course;
	private int grade;
	
	/**
	 * constructs a new CourseTaken instance.
	 * @param c     the taken course
	 * @param grade the grade in the course
	 */
	public CourseTaken(Course c, int grade){
		this.course = c;
		this.grade = grade;
	}
	
	/**
	 * returns the Course object of this CourseTaken instance.
	 * @return the Course object of this CourseTaken instance.
	 */
	public Course getCourse() {
		return course;
	}
	
	/**
	 * returns the grade this CourseTaken instance.
	 * @return the grade of this CourseTaken instance.
	 */
	public int getGrade() {
		return grade;
	}

	/**
	 * A textual representation of this CourseTaken instance.
	 */
	public String toString(){
		return course.toString() + ", grade: " + grade;
	}
}
