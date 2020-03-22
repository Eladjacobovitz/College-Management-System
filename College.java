import linkedList.*;

/**
 * Represents a college, and college management operations.
 * A college has courses, and students. Students take courses and get grades.
 * (See the Course, Student, and CourseTaken classes for more details).
 */
public class College {
	
	private static String nl =  System.getProperty("line.separator");

	private String name; // the name of this college
	private LinkedList<Course> courses;
	private LinkedList<Student> students;
	
	/**
	 * Constructs a new college, with empty student and course lists.
	 */
	public College(String name) {
		this.name = name;
		this.courses = new LinkedList<Course>();
		this.students = new LinkedList<Student>();
	}
	
	/** 
	 * Adds the given course to the course list of this college.
	 * @param cid   course id.
	 * @param title course title.
	 */
	public void addCourse(int cid, String title) {
		if(getCourse(cid)==null) {
		Course newcourse = new Course(cid,title);
		courses.add(newcourse);
		}
	}
	
	/**
	 * Prints a list of all the courses.
	 */
	public void coursesList() {
		System.out.println(courses);
	}

	/** 
	 * If the given course is in this college, removes it and returns true.
	 * Otherwise returns false.
	 * @param  cid the course to remove.
	 * @return True if the course was removed, false if there is no such course. 
	 */
	public boolean removeCourse(int cid) {
		Course coursetoremove =getCourse(cid);
		if(coursetoremove==null) return false;
		else {
			courses.remove(coursetoremove);
			ListIterator<Student> itr = students.iterator();
			while(itr.hasNext()) {
				Student current = itr.next();
				if(current.tookCourse(coursetoremove))
					current.removecoursefromstudentlist(coursetoremove);
			}
			return true;
		}
	}
	
	// Returns the course that has the given id, or null if there is no such course.
	private Course getCourse(int cid) {
		ListIterator <Course> itr = courses.iterator();
		while(itr.hasNext()) {
			Course course = itr.next();
			if (course.getCid()==cid) return course;
		}
		return null;
		//
	}
	
	/** 
	 * Adds the given student to the students list of this college.
	 * @param sid   student id
	 * @param name  student name
	 */
	public void addStudent(int sid, String name) {
		if(getStudent(sid)==null) {
		Student newstudent = new Student(sid,name);
		students.add(newstudent);
		}
	}
	
	/**
	 * Prints a list of all the students.
	 */
	public void studentsList() {
		System.out.println(students);
	}
	
	/** 
	 * If the given student is in this college, removes it and returns true.
	 * Otherwise returns false.
	 * @param  sid  the student's id.
	 * @return True if the student was removed, false if there is no such student. 
	 */
	public boolean removeStudent(int sid) {
		Student studenttoremove =getStudent(sid);
		if(studenttoremove==null) return false;
		else {
			students.remove(studenttoremove);
			return true;
		}
	}
	
	// Returns the student that has the given id, or null if there is no such student.
	private Student getStudent(int sid) {
		ListIterator <Student> itr = students.iterator();
		while(itr.hasNext()) {
			Student student = itr.next();
			if (student.getSid()==sid) return student;
		}
		return null;
		//
	}
	
	/** 
	 * Adds the given course to the course list of the given student.
	 * @param sid   student id
	 * @param cid   course id
	 * @param grade student's grade in the course 
	 */
	public void addCourseTaken(int sid, int cid, int grade) {
		if(getStudent(sid)==null) {
			System.out.println("No such student.");
			return;
		}
		if(getCourse(cid)==null) {
			System.out.println("No such course at the college.");
			return;
		}
		Student student = getStudent(sid);
		Course course = getCourse(cid);
		student.addCourse(course, grade);
	}
	
	/** 
	 * Prints the student report of the given student.
	 * See the Student class for more details.
	 * @param sid  student id
	 */
	public void studentReport(int sid) {
		if(getStudent(sid)==null) {
			System.out.println("No such student.");
			return;
		}else {
		Student student = getStudent(sid);
		// The code call the student's studentReport method.
		student.studentReport();
		}
	}
	
	/**
	 * Prints a list of all the students who took the course with the given cid.
	 * @param cid  the course
	 */
	public void courseReport(int cid) {
		if(getCourse(cid)==null) {
			System.out.println("No such course.");
			return;
		}
		int counter=0;
		ListIterator <Student> itr = students.iterator();
		Course course= getCourse(cid);
		System.out.println("The students that took "+course.getTitle()+" course is: ");
		while(itr.hasNext()) {
			Student student = itr.next();
			if(student.tookCourse(course)) {
				System.out.println(student.getName());
				counter ++;
			}
		}
		// if the counter stay on '0', its means the no one took this course.
		if(counter==0) System.out.println("None of the students took this course.");					
	}
	
	/** 
	 * Prints the number of students in the given course
	 * @param cid  course id
	 */
	public void printSize(int cid) {
		if(getCourse(cid)==null) {
			System.out.println("This course doesnt exist at the college");
			return;
		}
		
		int counter=0;
		ListIterator <Student> itr = students.iterator();
		Course course= getCourse(cid);
		System.out.print("The number of the students that took "+course.getTitle()+" course is: ");
		while(itr.hasNext()) {
			Student student = itr.next();
			if(student.tookCourse(course)) {
				counter ++;
			}
		}
		// if the counter stay on '0', its means the no one took this course.
		System.out.println(counter);					
	}
	
	// Returns a list of all the students who took the given course
	private LinkedList<Student> studentsWhoTook(Course c) {
		// First we will create a list of all the students who took the course
		LinkedList<Student> studentsWhoTookcourse=new LinkedList<Student>();
		ListIterator <Student> itr = students.iterator();
		while (itr.hasNext()) {
			Student student= itr.next();
			// If the answer is positive for the course, 
			// we "chalk" the course to the list we created at the beginning of the field
			if(student.tookCourse(c))studentsWhoTookcourse.addFirst(student);
		}
		return studentsWhoTookcourse;
	}
	
	/** 
	 * Prints the student with the highest grade in the given course.
	 * @param cid  course id
	 */
	public void topPerfomerReport(int cid) {
		if(getCourse(cid)==null) {
			System.out.println("This course doesnt exist at the college");
			return;
		}
		Course c=getCourse(cid);
		ListIterator <Student> itr = students.iterator();
		String name = itr.next().getName();
		int grade = itr.next().gradeInCourse(c);
		
		//first of all we get the name of the student with the highest grade in the given course.
		// after we will finish with that, we will check if there is another students with the same grade.
		while(itr.hasNext()) {
			Student student=itr.next();
			if(student.tookCourse(c)) {
				if(student.gradeInCourse(c)>=grade) {
					name=student.getName();
					grade=student.gradeInCourse(c);
				}
			}
		}
		System.out.print("The students with the highest grade in the course "+c.getTitle()+" is: "+name);
		ListIterator <Student> itr2 = students.iterator();
		
		// check if there is another student that get the same grade as the highest one.
		// if there is, print his name and continue to check again with the next student in the list.
		// The appropriate list is the list of students who took the specific course
		while(itr2.hasNext()) {
			Student student=itr2.next();
			if(student.tookCourse(c) && student.gradeInCourse(c)==grade) {
				System.out.print(", "+student.getName());
			}
		}
		System.out.println("");
		System.out.println("the grade is: "+grade);
	}
	
	
	/** 
	 * Returns the college name
	 * @return the college name 
	 */
	public String getName() {
		return name;
	}
	
	
	/**
	 * A textual representation of this college, along with its courses and students.
	 */
	public String toString() {
		String str = name + nl;
		str += "courses:" + nl;
		str += courses.toString() + nl;
		str += "students:" + nl;
		str += students.toString() + nl;
		return str;
	}
}
