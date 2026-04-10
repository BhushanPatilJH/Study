package com.study.dsa.week1;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {
    // Record defined at class level
    public record Student(String name, int mark) {}

    public record Employee(String name, int id,String dept,double salary) {}

    public static void main(String[] args) {
        // Create Student records
        Student student1 = new Student("Alice", 95);
        Student student2 = new Student("Bob", 78);
        Student student3 = new Student("Charlie", 92);
        List<Student> list = List.of(student1, student2, student3);

        list.stream().filter(student -> student.mark() > 80)
                .forEach(System.out::println);

        List<Employee> employees = List.of(
                new Employee("Alice", 1, "HR", 70000),
                new Employee("Bob", 2, "IT", 90000),
                new Employee("Charlie", 3, "HR", 75000),
                new Employee("David", 4, "IT", 85000)
        );

        // Group employees by department
        employees.stream().collect(Collectors.groupingBy(Employee::dept))
                .forEach((dept, empList) -> {
                    System.out.println("Department: " + dept);
                    empList.forEach(emp -> System.out.println(" - " + emp.name()));
                });
        employees.stream().max(Comparator.comparingDouble(Employee::salary))
                .ifPresent(emp -> System.out.println("Highest Salary: " + emp.name() + " with $" + emp.salary()));
        //using reduce to calculate max salary
        employees.stream().map(Employee::salary)
                .reduce(Double::max)
                .ifPresent(maxSalary -> System.out.println("Max Salary using reduce: $" + maxSalary));

        String countWord = "hello world hello stream";
        // Count occurrences of each word
        countWord.replace(" ","").chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .forEach((character, count) -> System.out.println(character + ": " + count));
    }
}

