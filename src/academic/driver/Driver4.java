package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.Scanner;
import java.util.ArrayList;

public class Driver4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Enrollment> enrollments = new ArrayList<>();

        String line;
        while (input.hasNextLine()) {
            line = input.nextLine();

            if (line.equals("---")) {
                break; // Berhenti jika input adalah "---"
            }

            String[] parts = line.split("#", 2); 
            if (parts.length < 2) {
                continue; 
            }

            String command = parts[0];
            String data = parts[1];

            switch (command) {
                case "course-add":
                    addCourse(data, courses);
                    break;
                case "student-add":
                    addStudent(data, students);
                    break;
                case "enrollment-add":
                    addEnrollment(data, enrollments);
                    break;
                default:
                    break; 
            }
        }

        // Menampilkan semua data yang telah dimasukkan tanpa header atau baris kosong
        displayAllData(courses, students, enrollments);

        input.close();
    }

    private static void addCourse(String data, ArrayList<Course> courses) {
        String[] courseParts = data.split("#");
        if (courseParts.length == 4) {
            try {
                String code = courseParts[0];
                String name = courseParts[1];
                int sks = Integer.parseInt(courseParts[2]);
                String grade = courseParts[3];
                courses.add(new Course(code, name, sks, grade));
            } catch (NumberFormatException e) {
                // Penanganan error tanpa output ke stderr
            }
        } else {
            // Penanganan error tanpa output ke stderr
        }
    }

    private static void addStudent(String data, ArrayList<Student> students) {
        String[] studentParts = data.split("#");
        if (studentParts.length == 4) {
            try {
                String id = studentParts[0];
                String name = studentParts[1];
                int entranceYear = Integer.parseInt(studentParts[2]);
                String major = studentParts[3];
                students.add(new Student(id, name, entranceYear, major));
            } catch (NumberFormatException e) {
                // Penanganan error tanpa output ke stderr
            }
        } else {
            // Penanganan error tanpa output ke stderr
        }
    }

    private static void addEnrollment(String data, ArrayList<Enrollment> enrollments) {
        String[] enrollmentParts = data.split("#");
        if (enrollmentParts.length == 4) { 
            String studentId = enrollmentParts[0];
            String courseCode = enrollmentParts[1];
            String academicYear = enrollmentParts[2];
            String semester = enrollmentParts[3];
            enrollments.add(new Enrollment(studentId, courseCode, academicYear, semester)); 
        } else if (enrollmentParts.length == 5) {
            String studentId = enrollmentParts[0];
            String courseCode = enrollmentParts[1];
            String academicYear = enrollmentParts[2];
            String semester = enrollmentParts[3];
            String grade = enrollmentParts[4];
            enrollments.add(new Enrollment(studentId, courseCode, academicYear, semester, grade)); 
        } else {
            // Penanganan error tanpa output ke stderr
        }
    }

    private static void displayAllData(ArrayList<Course> courses, ArrayList<Student> students, ArrayList<Enrollment> enrollments) {
        for (Course course : courses) {
            System.out.println(course.toString());
        }

        for (Student student : students) {
            System.out.println(student.toString());
        }

        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment.toString());
        }
    }
}