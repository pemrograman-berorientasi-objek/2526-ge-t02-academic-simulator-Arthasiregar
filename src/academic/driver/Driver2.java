package academic.driver;

import academic.model.Student;
import java.util.Scanner;

public class Driver2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Menggunakan array biasa dengan ukuran tetap, misalnya 100
        // Karena kapasitas maksimum tidak ditentukan, saya menggunakan nilai default yang cukup besar.
        Student[] students = new Student[100]; 
        int studentCount = 0;

        System.out.println("Masukkan data student dengan format: id#nama#tahunmasuk#programstudi");
        System.out.println("Ketik '---' untuk berhenti.");

        String line;
        while (input.hasNextLine()) {
            line = input.nextLine();

            if (line.equals("---")) {
                break; // Berhenti jika input adalah "---"
            }

            // Memeriksa apakah array sudah penuh
            if (studentCount >= students.length) {
                System.err.println("Peringatan: Array penyimpanan student sudah penuh. Tidak dapat menambahkan student baru.");
                break;
            }

            // Memparsing input
            String[] parts = line.split("#");
            if (parts.length == 4) {
                try {
                    String id = parts[0];
                    String name = parts[1];
                    int entranceYear = Integer.parseInt(parts[2]);
                    String major = parts[3];

                    // Membuat objek Student dan menambahkannya ke array
                    students[studentCount] = new Student(id, name, entranceYear, major);
                    studentCount++;
                } catch (NumberFormatException e) {
                    System.err.println("Peringatan: Tahun Masuk harus berupa angka. Input diabaikan: " + line);
                }
            } else {
                System.err.println("Peringatan: Format input salah. Harap gunakan: id#nama#tahunmasuk#programstudi. Input diabaikan: " + line);
            }
        }

        // Menampilkan semua data student dalam satu baris, dipisahkan dengan tanda "|"
        if (studentCount > 0) {
            StringBuilder outputBuilder = new StringBuilder();
            for (int i = 0; i < studentCount; i++) {
                outputBuilder.append(students[i].toString());
                if (i < studentCount - 1) {
                    outputBuilder.append(" | ");
                }
            }
            System.out.println("\n--- Daftar Student ---");
            System.out.println(outputBuilder.toString());
        } else {
            System.out.println("\nTidak ada data student yang dimasukkan.");
        }

        input.close();
    }
}