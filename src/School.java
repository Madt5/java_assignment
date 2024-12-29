import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class School {
    private List<Person> members;

    public School() {
        this.members = new ArrayList<>();
    }

    public void addMember(Person member) {
        members.add(member);
    }

    public List<Person> getMembers() {
        return members;
    }

    @Override
    public String toString() {
        Collections.sort(members, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.surname.compareTo(p2.surname);
            }
        });

        StringBuilder result = new StringBuilder();
        result.append("School Members:\n");
        result.append("\nTeachers:\n");
        for (Person member : members) {
            if (member instanceof Teacher) {
                result.append(member.toString()).append("\n");
            }
        }

        result.append("\nStudents:\n");
        for (Person member : members) {
            if (member instanceof Student) {
                result.append(member.toString()).append("\n");
            }
        }
        return result.toString();
    }
}