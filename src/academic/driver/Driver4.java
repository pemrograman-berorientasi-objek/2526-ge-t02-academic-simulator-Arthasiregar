package academic.driver;

/**
 * @author 12S24010 Artha Siregar
 */

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<Enrollment> enrollments = new ArrayList<>();

        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (line.equals("---")) {
                break;
            }

            String[] parts = line.split("#", 2); // Split only at the first '#' to separate command from data
            if (parts.length < 2) {
                // Invalid input format, continue to next line
                continue;
            }
            String command = parts[0];
            String dataString = parts[1];
            String[] data = dataString.split("#"); // Split the rest of the data by '#'

            switch (command) {
                case "course-add":
                    if (data.length == 4) {
                        String code = data[0];
                        String name = data[1];
                        int credits = Integer.parseInt(data[2]);
                        String grade = data[3];
                        courses.add(new Course(code, name, credits, grade));
                    }
                    break;
                case "student-add":
                    if (data.length == 4) {
                        String id = data[0];
                        String name = data[1];
                        int year = Integer.parseInt(data[2]);
                        String major = data[3];
                        students.add(new Student(id, name, year, major));
                    }
                    break;
                case "enrollment-add":
                    if (data.length == 4) {
                        String courseCode = data[0];
                        String studentId = data[1];
                        String academicYear = data[2];
                        String semester = data[3];
                        enrollments.add(new Enrollment(courseCode, studentId, academicYear, semester));
                    }
                    break;
                default:
                    // Unknown command, ignore
                    break;
            }
        }

        // Display courses
        for (Course course : courses) {
            System.out.println(course);
        }

        // Display students
        for (Student student : students) {
            System.out.println(student);
        }

        // Display enrollments
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }

        input.close();
    }
}

