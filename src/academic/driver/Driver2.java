package academic.driver;

import academic.model.Student;
import java.util.Scanner;
import java.util.ArrayList; // Menggunakan ArrayList untuk penyimpanan dinamis

public class Driver2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Menggunakan ArrayList untuk penyimpanan dinamis
        ArrayList<Student> students = new ArrayList<>();

        String line;
        while (input.hasNextLine()) {
            line = input.nextLine();

            if (line.equals("---")) {
                break; // Berhenti jika input adalah "---"
            }

            // Memparsing input
            String[] parts = line.split("#");
            if (parts.length == 4) { // Mengharapkan 4 bagian: id#nama#tahunmasuk#programstudi
                try {
                    String id = parts[0];
                    String name = parts[1];
                    int entranceYear = Integer.parseInt(parts[2]);
                    String major = parts[3];

                    // Membuat objek Student dan menambahkannya ke ArrayList
                    students.add(new Student(id, name, entranceYear, major));
                } catch (NumberFormatException e) {
                    // Penanganan error tanpa output ke stderr, sesuai contoh output
                }
            } else {
                // Penanganan error tanpa output ke stderr
            }
        }

        // Menampilkan semua data student tanpa header atau baris kosong, sesuai contoh output
        for (Student student : students) {
            System.out.println(student.toString());
        }

        input.close();
    }
}