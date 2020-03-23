package College_Management_System.Service;

/** 
 * Represents a course.
 */
public class CourseService {
	private int cid;
	private String title;
	
	
	/** 
	 * Constructs a new course.
	 * @param cid   the course id
	 * @param title the course title
	 */
	public CourseService(int cid, String title) {
		this.cid = cid;
		this.title = title;
	}
	
	
	/**
	 * returns the course id
	 * @return the course id
	 */
	public int getCid() {
		return cid;
	}
	
	
	/**
	 * returns the course title
	 * @return the course title
	 */
	public String getTitle() {
		return title;
	}
		
	
	/**
	 * A textual representation of this course.
	 */
	public String toString() {
		return "Course " + cid + ": " + title;
	}
}
