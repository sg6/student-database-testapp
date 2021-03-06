package com.example.demo.student;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentDao {

    private static Map<Integer, StudentModel> students;

    static {
        students = new HashMap<Integer, StudentModel>() {
            {
                put(1, new StudentModel(1, "Dave", "Days", new GregorianCalendar(1992, Calendar.FEBRUARY, 19).getTime()));
                put(2, new StudentModel(2, "Martin", "Moore", new GregorianCalendar(1995, Calendar.SEPTEMBER, 12).getTime()));
                put(3, new StudentModel(3, "Selina", "Sanchez", new GregorianCalendar(1997, Calendar.JANUARY, 24).getTime()));
            }
        };
    }

    public Collection<StudentModel> getAllStudents() {
        return this.students.values();
    }

    public StudentModel getStudentById(int id) {
        return this.students.get(id);
    }

    public Collection<StudentModel> removeStudentById(int id) {
        this.students.remove(id);
        return this.getAllStudents();
    }

    public StudentModel updateStudent(StudentModel student) {
        StudentModel s = students.get(student.getId());
        s.setFirstName(student.getFirstName());
        s.setLastName(student.getLastName());
        s.setDateOfBirth(student.getDateOfBirth());
        students.put(student.getId(), student);
        return student;
    }
}
