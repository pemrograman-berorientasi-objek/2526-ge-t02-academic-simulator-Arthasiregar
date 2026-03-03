package academic.driver;

/**
 * @author 12S24010 Artha Siregar
 */

import academic.model.Enrollment;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Enrollment> enrollments = new ArrayList<>();

        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (line.equals("---")) {
                break;
            }

            String[] data = line.split("#");
            if (data.length == 4) {
                String courseCode = data[0];
                String studentId = data[1];
                String academicYear = data[2];
                String semester = data[3];
                enrollments.add(new Enrollment(courseCode, studentId, academicYear, semester));
            }
        }

        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }

        input.close();
    }
}
