package PRO.Lektion9_JavaCollectionsFramework.Exercise3;

import java.util.ArrayList;
import java.util.List;

public class Student implements Comparable<Student> {

    private final int studentNo;
    private final List<Integer> grades = new ArrayList<>();
    private String name;

    public Student(int studentNo, String name) {

        this.studentNo = studentNo;
        this.name = name;
    }

    public int getStudentNo() {

        return studentNo;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void addGrade(int grade) {

        grades.add(grade);
    }

    public List<Integer> getGrades() {

        return grades;
    }

    @Override
    public int compareTo(Student o) {

        return Integer.compare(this.studentNo, o.getStudentNo());
    }

    @Override
    public String toString() {

        return "(" + this.studentNo + ")" + this.name;
    }

}
