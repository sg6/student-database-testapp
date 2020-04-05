package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public Collection<StudentModel> getAllStudents() {
        return this.studentDao.getAllStudents();
    }

    public StudentModel getStudentById(int id) {
        return this.studentDao.getStudentById(id);
    }

    public Collection<StudentModel> removeStudentById(int id) {
        return this.studentDao.removeStudentById(id);
    }

    public StudentModel updateStudent(StudentModel student) {
        return this.studentDao.updateStudent(student);
    }
}
