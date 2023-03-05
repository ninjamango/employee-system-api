package com.dailycodebuffer.employee.entity;


import jakarta.persistence.*;
import lombok.*;


//we use this @Entity to save data into our Database
@Entity
@Data
@Table(name="employees")
//inside schema employee_system a new table employee will be created
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // meaning of GenerationType.IDENTITY IS THAT AN INCREMENTAL VALUE WILL BE ADDED TO IT
    //these are all the columns

    private long id ;
    private String firstName;
    private String lastName;
    private String emailId;





}
