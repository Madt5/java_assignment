import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Student extends Person {
    private int studentID;
    private List<Integer> grades;

    public Student(String name, String surname, int age, String gender) {
        super(name, surname, age, gender);
        this.grades = new ArrayList<>();
        this.studentID = new Random().nextInt(90000) + 10000;
    }

    public void addGrade(int grade) {
        if (grade >= 0 && grade <= 100) {
            grades.add(grade);
        } else {
            throw new IllegalArgumentException("Grade must be between 0 and 100");
        }
    }

    public double calculateGPA() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" I am a student with ID %d.", studentID);
    }
}
