package academic.driver;

import academic.model.Course;
import java.util.Scanner;
import java.util.ArrayList; // Menggunakan ArrayList untuk penyimpanan dinamis

public class Driver1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Menggunakan ArrayList untuk penyimpanan dinamis
        ArrayList<Course> courses = new ArrayList<>();

        String line;
        while (input.hasNextLine()) {
            line = input.nextLine();

            if (line.equals("---")) {
                break; // Berhenti jika input adalah "---"
            }

            // Memparsing input
            String[] parts = line.split("#");
            if (parts.length == 4) { // Mengharapkan 4 bagian: code#name#sks#grade
                try {
                    String code = parts[0];
                    String name = parts[1];
                    int sks = Integer.parseInt(parts[2]);
                    String grade = parts[3];

                    // Membuat objek Course dan menambahkannya ke ArrayList
                    courses.add(new Course(code, name, sks, grade));
                } catch (NumberFormatException e) {
                    // Penanganan error tanpa output ke stderr, sesuai contoh output
                }
            } else {
                // Penanganan error tanpa output ke stderr
            }
        }

        // Menampilkan semua data course tanpa header atau baris kosong, sesuai contoh output
        for (Course course : courses) {
            System.out.println(course.toString());
        }

        input.close();
    }
}