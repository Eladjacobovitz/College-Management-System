# College-Management-System
This project provides a solid hands-on experience in object-oriented programming, linked lists, and system design. It also illustrates what can be described as “programming at the large”, i.e. working with multiple classes and packages.

The program was built to assist a system architect in building a College Management System , designed to help academic institutions run their operations. A typical college maintains information about various entities like courses , students , instructors , rooms , and so on. In addition, the college maintains various records, e.g. the fact that a student took a course and got a grade in it.
To keep things simple, in this project i will focus on three entities only: courses , students , and courseTaken records. This information will be represented by the three classes described below:

Course ( CourseService.java ):
A typical college offers hundreds of courses, and each can be represented as an instance of this class. Typically, a course is characterized by a course id, course title, course instructor (an instance of an Instructor class), capacity, room (an instance of a Room class), etc. In this project though, the Course class features two fields only: course id, and title.

Student ( StudentService.java ):
Represents students who are enrolled in the college. Each student has a student id, name, address, year, major, course list, and so on. In this project though, the Student class features three fields only: student id, name, and course list. The latter is a list of (course id, grade) pairs, each being an instance of the CourseTaken class.

CourseTaken ( CourseTakenService.java ):
Represents pairs of the form ( course id , grade ). It would make sense to also keep track of year and semester data, but, to keep things simple, we’ll focus on course id and grade only.
