package academic.model;

public class Course {
    private String code;
    private String name;
    private int sks;
    private String grade; // Asumsi ini adalah grade standar untuk course, mungkin "A" untuk lulus default.

    public Course(String code, String name, int sks, String grade) {
        this.code = code;
        this.name = name;
        this.sks = sks;
        this.grade = grade;
    }

    // Getter methods
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
        // Format output baru sesuai contoh: code|name|sks|grade
        return String.format("%s|%s|%d|%s", code, name, sks, grade);
    }
}