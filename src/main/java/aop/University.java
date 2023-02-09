package aop;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {
    private List<Student> students = new ArrayList<>();

    public void addStudents() {
        Student student1 = new Student("Yana Yasinovski", 4, 9.1);
        Student student2 = new Student("Denis Teterukov", 4, 9.4);
        Student student3 = new Student("Julia Kravchinskay", 4, 8.6);

        students.add(student1);
        students.add(student2);
        students.add(student3);
    }

    public List<Student> getStudents() {
        System.out.println("Начало работы метода getStudents()");
//        System.out.println(students.get(3));
        System.out.println("Information from method getStudents: ");
        System.out.println(students);
        return students;
    }
}
