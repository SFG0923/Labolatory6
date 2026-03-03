package Lab6;


public class Student extends Human {
    private String faculty;

    public Student(String lastName, String firstName, String patronymic, int age, String faculty) {
        super(lastName, firstName, patronymic, age);
        this.faculty = faculty;
    }

    public String getFaculty() { return faculty; }
    public void setFaculty(String faculty) { this.faculty = faculty; }
}