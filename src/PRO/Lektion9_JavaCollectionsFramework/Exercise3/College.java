package PRO.Lektion9_JavaCollectionsFramework.Exercise3;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class College {

    private final String name;
    private final LinkedHashMap<Integer, Student> students = new LinkedHashMap<>();

    public College(String name) { this.name = name; }

    public LinkedHashMap<Integer, Student> getStudents() {

        return students;
    }

    public String getName() { return name; }

    public void addStudent(Student student) {

        if (students.containsKey(student.getStudentNo())) {
            throw new RuntimeException("Student: " + student + " is already registered");
        }
        students.put(student.getStudentNo(), student);
    }

    public void removeStudent(Student student) {

        if (!students.containsKey(student.getStudentNo())) {
            throw new RuntimeException("Student: " + student + " is already registered");
        }
        students.remove(student.getStudentNo(), student);
    }

    public double calcAverage() {

        int count = 0;
        int total = 0;

        for (Map.Entry<Integer, Student> s : students.entrySet()) {

            for (int grade : s.getValue().getGrades()) {
                count++;
                total += grade;
            }
        }

        return (double) total / count;
    }

    public Student findStudent(int studentNo) {

        Optional<Student> student = Optional.ofNullable(students.get(studentNo));

        if (student.isPresent()) { return student.get(); }
        else {
            System.out.println("Student with ID: " + studentNo + " not found");
            return null;
        }
    }

    public String toString() {

        return name;
    }

}
