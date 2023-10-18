package com.example.wanted.recruitment.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RecruitmentRequest {

    private Long companyId;
    private String position;
    private int compensation;
    private String details;
    private String techStack;
}
