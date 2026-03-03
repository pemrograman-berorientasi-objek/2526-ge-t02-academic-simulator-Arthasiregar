package academic.model;

public class Student {
    private String id;
    private String name;
    private int entranceYear;
    private String major;

    public Student(String id, String name, int entranceYear, String major) {
        this.id = id;
        this.name = name;
        this.entranceYear = entranceYear;
        this.major = major;
    }

    // Getter methods
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getEntranceYear() {
        return entranceYear;
    }

    public String getMajor() {
        return major;
    }

    @Override
    public String toString() {
        // Format output baru sesuai contoh: id|name|entranceYear|major
        return String.format("%s|%s|%d|%s", id, name, entranceYear, major);
    }
}