package Behavioral.Iterator.UniversityStudents;

import java.util.ArrayList;
import java.util.List;

public class StudentCollection {
    private final List<Student> students;

    public StudentCollection() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public StudentIterator createIterator() {
        return new StudentCollectionIterator(students);
    }
}
