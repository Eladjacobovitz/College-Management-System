import linkedList.*;


/** 
 * Represents a student.
 */
public class Student {
	
	private int sid;                             
	private String name;                         
	private LinkedList<CourseTaken> courseList;
	
	/** 
	 * Constructs a new student with the given sid and name, and an empty course list.
	 * @param sid  the student's sid
	 * @param name the student's name
	 */
	public Student(int sid, String name) {
		this.sid = sid;
		this.name = name;
		courseList = new LinkedList<CourseTaken>();
	}
	
	/** 
	 * Returns the sid of this student.
	 * @return the sid of this student.
	 */
	public int getSid() {
		return sid;
	}
	
	/** 
	 * Returns the name of this student.
	 * @return the name of this student.
	 */
	public String getName() {
		return name;
	}
	
	/** 
	 * Adds the given course and grade to the course list of this student.
	 * @param c     the course to add
	 * @param grade the grade in the added course 
	 */
	public void addCourse(Course c, int grade) {
		ListIterator <CourseTaken> itr = courseList.iterator();
		while (itr.hasNext()) {
			CourseTaken newcourse = itr.next();
			if(c.equals(newcourse.getCourse())) {
				courseList.remove(newcourse);
			}
		}
		CourseTaken newcourse2 = new CourseTaken(c, grade);
		courseList.add(newcourse2);
	}
	
	/** 
	 * Removes the given course from the course list of this student.
	 * @param c     the course to remove
	 */
	public  void removecoursefromstudentlist(Course c) {
		ListIterator <CourseTaken> itr = courseList.iterator();
		while(itr.hasNext()) {
			CourseTaken current = itr.next();
			if(c.equals(current.getCourse())) courseList.remove(current);
		}
	}
	
	/** 
	 * Returns the grade that this student got in the given course, 
	 *  or -1 if the course was not taken by this student.
	 * @param c - the returned grade will be the grade in this course.
	 * @return the grade that this student got in the given course
	 */
	public int gradeInCourse(Course c) {
		ListIterator <CourseTaken> itr = courseList.iterator();
		while(itr.hasNext()) {
			CourseTaken current = itr.next();
			if(current.getCourse().equals(c)) return current.getGrade();			
		}
		return -1;
	}
	
	/** 
	 * Returns true if this student took the given course, false otherwise.
	 * @param c  the course we want to know whether or not the student took.
	 * @return true if this student took the given course, false otherwise.
	 */
	public boolean tookCourse(Course c) {
		ListIterator <CourseTaken> itr = courseList.iterator();
		while(itr.hasNext()) {
			CourseTaken current= itr.next();
			if(current.getCourse().equals(c)) return true;
		}
		return false;
	}
	
	/**
	 * Prints this student, all the courses that s/he took, and the grade point average.
	 */
	public void studentReport() {
		// first of all, check if the student took a course.
		if(courseList.size()==0) {
			System.out.println("No courses taken yet.");
			return;
			// if he did, print each course and grade in different row.
		}else {
			// We'll create an iterator that goes through the course list and "pulls" his grade.
		ListIterator <CourseTaken> itr = courseList.iterator();
		int sum=0;
		System.out.println(name+ "'s curses and grades: ");
		while(itr.hasNext()) {
			CourseTaken current = itr.next();
			System.out.println(current.getCourse().getTitle()+": "+current.getGrade());
			sum+=current.getGrade();
		}
		System.out.println("The grade point average is: "+sum/courseList.size());
		}
		
	}
	
	/**
	 * Textual representation of this student.
	 */
	public String toString() {
		return "Student " + sid + ": " + name;
	}
}