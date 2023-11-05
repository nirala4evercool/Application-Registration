package com.chandan.binding;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CitizenApp {
    private String fullname;
    private String email;
    private  Long phno;
    private  String gender;
    private  Long ssn;
    private LocalDate dob;
}
