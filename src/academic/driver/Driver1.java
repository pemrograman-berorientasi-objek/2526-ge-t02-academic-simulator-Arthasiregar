package academic.driver;

/**
 * @author 12S24010 Artha Siregar
 */

import academic.model.Course;
import java.util.ArrayList;
import java.util.List; // Using List interface for better practice
import java.util.Scanner;

public class Driver1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Course> courses = new ArrayList<>(); // Using List interface

        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (line.equals("---")) {
                break;
            }

            String[] data = line.split("#");
            if (data.length == 4) {
                String code = data[0];
                String name = data[1];
                int credits = Integer.parseInt(data[2]);
                String grade = data[3];
                courses.add(new Course(code, name, credits, grade));
            }
        }

        for (Course course : courses) {
            System.out.println(course);
        }

        input.close();
    }
}

