package Lab6;

import java.util.Objects;

public class Human {
    private String lastName;
    private String firstName;
    private String patronymic;
    private int age;

    public Human(String lastName, String firstName, String patronymic, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.age = age;
    }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getPatronymic() { return patronymic; }
    public void setPatronymic(String patronymic) { this.patronymic = patronymic; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age &&
                Objects.equals(lastName, human.lastName) &&
                Objects.equals(firstName, human.firstName) &&
                Objects.equals(patronymic, human.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, patronymic, age);
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " " + patronymic + " (" + age + ")";
    }
}