package com.example.demo.student;

import java.util.Date;

public class StudentModel {
    private int id;
    private String firstName;
    private String lastName;

    private Date dateOfBirth;

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    public StudentModel(int id, String firstName, String lastName, Date dateOfBirth) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setDateOfBirth(dateOfBirth);
        this.setId(id);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        Date now = new Date();
        long diff = now.getTime() - dateOfBirth.getTime();

        return (int)Math.floor(diff / 1000 / 3600 / 24 / 365);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}
