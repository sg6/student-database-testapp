package com.example.demo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@RestController
public class StudentController {

    private int counter;

    @GetMapping(value="/student/{id}")
    @ResponseBody
    public StudentModel getStudent(@PathVariable String id) {
        ++counter;

        Date dob = new GregorianCalendar(1992, Calendar.FEBRUARY, 19).getTime();
        StudentModel student = new StudentModel(1, "Dave", "Days", dob);
        student.getAge();

        System.out.println(counter);
        return student;
    }

}
