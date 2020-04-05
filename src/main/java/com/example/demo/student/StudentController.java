package com.example.demo.student;

import com.example.demo.utils.EmptyJsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

@RestController
@RequestMapping("/students")
public class StudentController {

    private int counter;

    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<StudentModel> getAllStudents() {
        return studentService.getAllStudents();
    }

    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public StudentModel getStudentById(@PathVariable("id") int id) {
        return studentService.getStudentById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Collection<StudentModel> deleteStudentById(@PathVariable("id") int id) {
        return studentService.removeStudentById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public StudentModel updateStudent(@RequestBody StudentModel student) {
        return studentService.updateStudent(student);
    }

    // Clowning around
    @GetMapping(value="/clown/{id}")
    public ResponseEntity<StudentModel> getStudent(@PathVariable String id) {
        ++counter;
        int studentId;

        try {
            studentId = Integer.parseInt(id);
            Date dob = new GregorianCalendar(1992, Calendar.FEBRUARY, 19).getTime();
            StudentModel student = new StudentModel(studentId, "Dave", "Days", dob);
            student.getAge();

            System.out.println(counter);
            return new ResponseEntity<StudentModel>(student, new HttpHeaders(), HttpStatus.OK);
        } catch(Exception ex) {
            System.out.println("ERROR!!!");
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
        }
    }

}
