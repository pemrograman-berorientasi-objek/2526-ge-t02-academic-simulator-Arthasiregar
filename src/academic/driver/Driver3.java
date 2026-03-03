package academic.driver;

import academic.model.Enrollment;
import java.util.Scanner;

public class Driver3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Menggunakan array biasa dengan ukuran tetap, misalnya 100
        Enrollment[] enrollments = new Enrollment[100]; 
        int enrollmentCount = 0;

        // Mengubah instruksi format input sesuai dengan contoh yang diberikan
        System.out.println("Masukkan data enrollment dengan format: studentId#courseCode#tahunAkademik#semester");
        System.out.println("Ketik '---' untuk berhenti.");

        String line;
        while (input.hasNextLine()) {
            line = input.nextLine();

            if (line.equals("---")) {
                break; // Berhenti jika input adalah "---"
            }

            // Memeriksa apakah array sudah penuh
            if (enrollmentCount >= enrollments.length) {
                System.err.println("Peringatan: Array penyimpanan enrollment sudah penuh. Tidak dapat menambahkan enrollment baru.");
                break;
            }

            // Memparsing input, kini diharapkan 4 bagian
            String[] parts = line.split("#");
            if (parts.length == 4) { // Mengharapkan 4 bagian: studentId#courseCode#tahunAkademik#semester
                String studentId = parts[0];
                String courseCode = parts[1];
                String academicYear = parts[2];
                String semester = parts[3];
                // Grade akan otomatis diatur menjadi "None" oleh konstruktor Enrollment(4 parameter)
                
                // Membuat objek Enrollment dan menambahkannya ke array menggunakan konstruktor 4 parameter
                enrollments[enrollmentCount] = new Enrollment(studentId, courseCode, academicYear, semester);
                enrollmentCount++;
            } else if (parts.length == 5) { // Masih support input 5 bagian jika user ingin memberi grade
                String studentId = parts[0];
                String courseCode = parts[1];
                String academicYear = parts[2];
                String semester = parts[3];
                String grade = parts[4]; // Grade yang diberikan
                
                // Menggunakan konstruktor 5 parameter
                enrollments[enrollmentCount] = new Enrollment(studentId, courseCode, academicYear, semester, grade);
                enrollmentCount++;
            }
            else {
                System.err.println("Peringatan: Format input salah. Harap gunakan: studentId#courseCode#tahunAkademik#semester (opsional: #grade). Input diabaikan: " + line);
            }
        }

        // Menampilkan semua data enrollment dalam format: studentId|courseCode|academicYear|semester|grade
        if (enrollmentCount > 0) {
            System.out.println("\n--- Daftar Enrollment ---");
            for (int i = 0; i < enrollmentCount; i++) {
                System.out.println(enrollments[i].toString());
            }
        } else {
            System.out.println("\nTidak ada data enrollment yang dimasukkan.");
        }

        input.close();
    }
}