public class Person {
    protected String name;
    protected String surname;
    protected int age;
    protected String gender;

    public Person(String name, String surname, int age, String gender) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return String.format("Hi, I am %s %s, a %d-year-old %s",
                name, surname, age, gender);
    }
}