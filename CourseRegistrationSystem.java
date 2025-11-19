import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    String courseCode;
    String title;
    String description;
    int capacity;
    String schedule;
    int availableSlots;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.availableSlots = capacity;
    }

    public String toString() {
        return "Course Code: " + courseCode + "\nTitle: " + title + "\nDescription: " + description +
                "\nCapacity: " + capacity + "\nSchedule: " + schedule + "\nAvailable Slots: " + availableSlots + "\n";
    }
}

class Student {
    String studentID;
    String name;
    List<Course> registeredCourses;

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public String toString() {
        StringBuilder courses = new StringBuilder("Registered Courses:\n");
        for (Course course : registeredCourses) {
            courses.append(course.courseCode).append(" - ").append(course.title).append("\n");
        }
        return "Student ID: " + studentID + "\nName: " + name + "\n" + courses.toString();
    }
}

class RegistrationSystem {
    List<Course> courseDatabase;
    List<Student> studentDatabase;
    Scanner scanner;

    public RegistrationSystem() {
        this.courseDatabase = new ArrayList<>();
        this.studentDatabase = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void displayCourseListing() {
        System.out.println("Course Listing:\n");
        for (Course course : courseDatabase) {
            System.out.println(course);
        }
    }

    public void registerStudentForCourse() {
        System.out.print("Enter student ID:");
        String studentID = scanner.next();

        System.out.print("Enter course code to register:");
        String courseCode = scanner.next();

        Student student = findStudentById(studentID);
        Course course = findCourseByCode(courseCode);

        if (student != null && course != null) {
            if (course.availableSlots > 0) {
                student.registeredCourses.add(course);
                course.availableSlots--;
                System.out.println(student.name + " has successfully registered for " + course.title + ".");
            } else {
                System.out.print("Sorry, " + course.title + " is already full. Unable to register.");
            }
        } else {
            System.out.print("Invalid student ID or course code.");
        }
    }

    public void removeStudentFromCourse() {
        System.out.print("Enter student ID:");
        String studentID = scanner.next();

        System.out.print("Enter course code to remove:");
        String courseCode = scanner.next();

        Student student = findStudentById(studentID);
        Course course = findCourseByCode(courseCode);

        if (student != null && course != null) {
            if (student.registeredCourses.contains(course)) {
                student.registeredCourses.remove(course);
                course.availableSlots++;
                System.out.println(student.name + " has successfully dropped " + course.title + ".");
            } else {
                System.out.print(student.name + " is not registered for " + course.title + ".");
            }
        } else {
            System.out.print("Invalid student ID or course code.");
        }
    }

    private Student findStudentById(String studentID) {
        for (Student student : studentDatabase) {
            if (student.studentID.equals(studentID)) {
                return student;
            }
        }
        return null;
    }

    private Course findCourseByCode(String courseCode) {
        for (Course course : courseDatabase) {
            if (course.courseCode.equals(courseCode)) {
                return course;
            }
        }
        return null;
    }

    public void closeScanner() {
        scanner.close();
    }
}

public class CourseRegistrationSystem {
    public static void main(String[] args) {
        RegistrationSystem registrationSystem = new RegistrationSystem();

        // Populate the course database
        registrationSystem.courseDatabase.add(new Course("IT01", "Java Programming",
                "Basic programming concepts", 30, "Mon/Fri 8:00 AM - 10:00 AM"));
        registrationSystem.courseDatabase.add(new Course("IT02", "Python Programming", "Basic of Python", 25,
                "Tue/Thu 10:00 AM - 12:00 PM"));
        registrationSystem.courseDatabase.add(new Course("IT03", "Operating System",
                "Linux", 30, "Mon/Fri 1:00 AM - 3:00 AM"));
        registrationSystem.courseDatabase.add(new Course("IT04", "DataBase",
                "MySql concepts", 30, "Mon/Wed 3:00 AM - 5:00 AM"));
        registrationSystem.courseDatabase.add(new Course("IT05", "Software Engineering ",
                "Software Engineering concepts", 30, "Mon/Wed 8:00 AM - 10:00 AM"));
        // Populate the student database
        registrationSystem.studentDatabase.add(new Student("S001", "John "));
        registrationSystem.studentDatabase.add(new Student("S002", "Janu"));
        registrationSystem.studentDatabase.add(new Student("S003", "Raam"));
        registrationSystem.studentDatabase.add(new Student("S004", "Swetha"));
        registrationSystem.studentDatabase.add(new Student("S005", "Riya"));

        int choice;
        do {
            System.out.println("\n\n\n\t\t\t*** Course Registration System ***");
            System.out.println("\n\tMenu:");
            System.out.println("\t\t1. Display Course Listing");
            System.out.println("\t\t2. Register Student for Course");
            System.out.println("\t\t3. Remove Student from Course");
            System.out.println("\t\t4. Exit");
            System.out.print("\n\tEnter your choice:");

            choice = registrationSystem.scanner.nextInt();

            switch (choice) {
                case 1:
                    registrationSystem.displayCourseListing();
                    break;
                case 2:
                    registrationSystem.registerStudentForCourse();
                    break;
                case 3:
                    registrationSystem.removeStudentFromCourse();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

        registrationSystem.closeScanner();
    }
}
