package PRO.Lektion9_JavaCollectionsFramework.Exercise2;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private final int StudentNo;
    private String name;
    private final List<Integer> grades = new ArrayList<>();

    public Student(int studentNo, String name) {

        this.StudentNo = studentNo;
        this.name = name;
    }

    public int getStudentNo() {

        return StudentNo;
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

}
