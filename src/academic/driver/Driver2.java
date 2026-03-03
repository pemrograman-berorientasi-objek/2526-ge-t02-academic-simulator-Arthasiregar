package academic.driver;

/**
 * @author 12S24010 Artha Siregar
 */

import academic.model.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (line.equals("---")) {
                break;
            }

            String[] data = line.split("#");
            if (data.length == 4) {
                String id = data[0];
                String name = data[1];
                int year = Integer.parseInt(data[2]);
                String major = data[3];
                students.add(new Student(id, name, year, major));
            }
        }

        for (Student student : students) {
            System.out.println(student);
        }

        input.close();
    }
}

