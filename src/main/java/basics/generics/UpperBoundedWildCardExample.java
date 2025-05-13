package basics.generics;

import java.util.ArrayList;
import java.util.List;

public class UpperBoundedWildCardExample {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 90));
        students.add(new Student("Bob", 85));

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", 50000));
        employees.add(new Employee("Doe", 60000));

        printPerson(students);
        printPerson(employees);
    }

    // Moved outside main
    public static void printPerson(List<? extends Person> list) {
        for (Person person : list) {
            String modified = person.modifyName(person.name);
            System.out.println(modified);
        }
    }
}

class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    public String modifyName(String name) {
        this.name = name;
        return name.toUpperCase();
    }
}

class Employee extends Person {
    int salary;

    public Employee(String name, int salary) {
        super(name);
        this.salary = salary;
    }
}

class Student extends Person {
    int marks;

    public Student(String name, int marks) {
        super(name);
        this.marks = marks;
    }
}

