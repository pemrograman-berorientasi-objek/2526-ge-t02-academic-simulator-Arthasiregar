package academic.driver;

import academic.model.Course;
import java.util.Scanner;

public class Driver1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Menggunakan array biasa dengan ukuran tetap, misalnya 100
        // Karena kapasitas maksimum tidak ditentukan, saya menggunakan nilai default yang cukup besar.
        Course[] courses = new Course[100]; 
        int courseCount = 0;

        System.out.println("Masukkan data course dengan format: kode#nama#sks#grade");
        System.out.println("Ketik '---' untuk berhenti.");

        String line;
        while (input.hasNextLine()) {
            line = input.nextLine();

            if (line.equals("---")) {
                break; // Berhenti jika input adalah "---"
            }

            // Memeriksa apakah array sudah penuh
            if (courseCount >= courses.length) {
                System.err.println("Peringatan: Array penyimpanan course sudah penuh. Tidak dapat menambahkan course baru.");
                break; // Atau Anda bisa memilih untuk tidak break dan hanya mengabaikan input selanjutnya
            }

            // Memparsing input
            String[] parts = line.split("#");
            if (parts.length == 4) {
                try {
                    String code = parts[0];
                    String name = parts[1];
                    int sks = Integer.parseInt(parts[2]);
                    String grade = parts[3];

                    // Membuat objek Course dan menambahkannya ke array
                    courses[courseCount] = new Course(code, name, sks, grade);
                    courseCount++;
                } catch (NumberFormatException e) {
                    System.err.println("Peringatan: SKS harus berupa angka. Input diabaikan: " + line);
                }
            } else {
                System.err.println("Peringatan: Format input salah. Harap gunakan: kode#nama#sks#grade. Input diabaikan: " + line);
            }
        }

        // Menampilkan semua data course dalam satu baris, dipisahkan dengan tanda "|"
        if (courseCount > 0) {
            StringBuilder outputBuilder = new StringBuilder();
            for (int i = 0; i < courseCount; i++) {
                outputBuilder.append(courses[i].toString());
                if (i < courseCount - 1) {
                    outputBuilder.append(" | ");
                }
            }
            System.out.println("\n--- Daftar Course ---");
            System.out.println(outputBuilder.toString());
        } else {
            System.out.println("\nTidak ada data course yang dimasukkan.");
        }

        input.close();
    }
}