package com.jobapp.companyms.company.dto;

import lombok.Data;

@Data
public class ReviewMessage {


    private Long Id;
    private String title;
    private String description;
    private double rating;
    Long companyId;
}
