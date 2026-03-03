package academic.model;

public class Course {
    private String code;
    private String name;
    private int sks;
    private String grade; // grade bisa berupa "A", "B+", "C", dsb.

    public Course(String code, String name, int sks, String grade) {
        this.code = code;
        this.name = name;
        this.sks = sks;
        this.grade = grade;
    }

    // Getter methods (jika diperlukan untuk pengaksesan data dari luar)
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getSks() {
        return sks;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        // Format output: kode (nama) [sks SKS] grade
        return String.format("%s (%s) [%d SKS] %s", code, name, sks, grade);
    }
}

