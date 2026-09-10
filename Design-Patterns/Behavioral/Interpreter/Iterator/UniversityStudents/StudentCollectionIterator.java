package Behavioral.Interpreter.Iterator.UniversityStudents;

import java.util.List;

public class StudentCollectionIterator implements StudentIterator{
    private final List<Student> students;
    private int position = 0;

    public StudentCollectionIterator(List<Student> students) {
        this.students = students;
    }


    @Override
    public boolean hasNext() {
        return position < students.size();
    }

    @Override
    public Student next() {
        return students.get(position++);
    }
}
