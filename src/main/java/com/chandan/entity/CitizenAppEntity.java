package com.chandan.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "CITIZEN_APPS")
@Data
public class CitizenAppEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appId;
    private  String fullname;
    private  Long phno;
    private  String gender;
    private  Long ssn;
    private  String stateName;
    @CreationTimestamp
    private  LocalDate createdDate;
    @UpdateTimestamp
    private LocalDate updatedDate;
    private  String createdBy;
    private  String updatedBy;
    private LocalDate dob;




}
