package academic.model;

/**
 * @author 12S24010 Artha Siregar
 */

public class Course {
    private String code;
    private String name;
    private int credits;
    private String grade; // This field holds the last segment of the course input, e.g., 'C' or 'D'

    public Course(String code, String name, int credits, String grade) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.grade = grade;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return code + "|" + name + "|" + credits + "|" + grade;
    }
}

