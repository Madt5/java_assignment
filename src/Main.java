import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        School school = new School();

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\admin\\IdeaProjects\\asihgment\\src\\students.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(" ");
                Student student = new Student(
                        data[0],
                        data[1],
                        Integer.parseInt(data[2]),
                        data[3]
                );

                for (int i = 4; i < data.length; i++) {
                    student.addGrade(Integer.parseInt(data[i]));
                }
                school.addMember(student);
            }
        } catch (IOException e) {
            System.err.println("Error reading students file: " + e.getMessage());
        }

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\admin\\IdeaProjects\\asihgment\\src\\teachers.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(" ");
                Teacher teacher = new Teacher(
                        data[0],
                        data[1],
                        Integer.parseInt(data[2]),
                        data[3],
                        data[4],
                        Integer.parseInt(data[5]),
                        Integer.parseInt(data[6])
                );
                school.addMember(teacher);
            }
        } catch (IOException e) {
            System.err.println("Error reading teachers file: " + e.getMessage());
        }

        System.out.println("Initial salaries:");
        for (Person member : school.getMembers()) {
            if (member instanceof Teacher) {
                Teacher teacher = (Teacher) member;
                System.out.printf("%s %s: $%d%n",
                        teacher.name, teacher.surname, teacher.getSalary());
            }
        }

        System.out.println("\nApplying 10% raise to teachers with >10 years experience...\n");
        for (Person member : school.getMembers()) {
            if (member instanceof Teacher) {
                Teacher teacher = (Teacher) member;
                if (teacher.getYearsOfExperience() > 10) {
                    teacher.giveRaise(10);
                }
            }
        }

        System.out.println("School Members:");

        System.out.println("\nStudent GPAs:");
        for (Person member : school.getMembers()) {
            if (member instanceof Student) {
                Student student = (Student) member;
                System.out.printf("%s %s: %.2f%n",
                        student.name, student.surname, student.calculateGPA());
            }
        }
    }
}