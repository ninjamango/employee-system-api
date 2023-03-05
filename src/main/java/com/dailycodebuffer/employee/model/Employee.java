package com.dailycodebuffer.employee.model;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private long id ;
    private String firstName;
    private String lastName;
    private String emailId;


}
