package com.example.wanted.recruitment.domain;

import com.example.wanted.company.domain.Company;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Recruitment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recruitment_id")
    private Long id;

    private String position;

    private int compensation;

    private String details;

    private String techStack;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    public void update(String position, int compensation, String details, String techStack) {
        this.position = position;
        this.compensation = compensation;
        this.details = details;
        this.techStack = techStack;
    }
}
