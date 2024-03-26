package com.jobapp.companyms.company.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

//    @JsonIgnore
//    @OneToMany(mappedBy = "company")
//    List<Job> jobs;
//
//
//    @OneToMany(mappedBy = "company")
//    List<Review> reviews;


}
