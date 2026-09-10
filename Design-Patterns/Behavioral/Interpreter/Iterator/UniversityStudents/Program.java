package Behavioral.Interpreter.Iterator.UniversityStudents;

public class Program {
    public static void main(String[] args) {
        StudentCollection collection = new StudentCollection();

        collection.addStudent(new Student(1, "Walid"));
        collection.addStudent(new Student(2, "Ahmed"));
        collection.addStudent(new Student(3, "Mohamed"));
        collection.addStudent(new Student(4, "Ali"));

        StudentIterator iterator = collection.createIterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();

            System.out.println(student.getName());
        }
    }
}
