package academic.model;

public class Enrollment {
    private String studentId;
    private String courseCode;
    private String academicYear; // e.g., "2023/2024"
    private String semester;     // e.g., "Ganjil", "Genap", "Pendek"
    private String grade;        // e.g., "A", "B+", "C", atau "None" jika tidak ada

    public Enrollment(String studentId, String courseCode, String academicYear, String semester, String grade) {
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.academicYear = academicYear;
        this.semester = semester;
        // Mengatur default grade menjadi "None" jika parameter grade adalah null atau string kosong
        this.grade = (grade == null || grade.isEmpty()) ? "None" : grade;
    }
    
    // Overload konstruktor untuk kasus tanpa grade eksplisit
    public Enrollment(String studentId, String courseCode, String academicYear, String semester) {
        this(studentId, courseCode, academicYear, semester, "None"); // Otomatis set grade "None"
    }


    // Getter methods
    public String getStudentId() {
        return studentId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public String getSemester() {
        return semester;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        // Format output: studentId|courseCode|academicYear|semester|grade (dengan grade "None" jika tidak ada)
        return String.format("%s|%s|%s|%s|%s", studentId, courseCode, academicYear, semester, grade);
    }
}