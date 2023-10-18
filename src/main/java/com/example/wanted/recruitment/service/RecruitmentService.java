package com.example.wanted.recruitment.service;

import com.example.wanted.company.domain.Company;
import com.example.wanted.company.repository.CompanyRepository;
import com.example.wanted.exception.BaseException;
import com.example.wanted.recruitment.domain.Recruitment;
import com.example.wanted.recruitment.repository.RecruitmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecruitmentService {

    private final RecruitmentRepository recruitmentRepository;
    private final CompanyRepository companyRepository;


    @Transactional
    public Long save(Long companyId, Recruitment parameter) {

        Company company = companyRepository.findById(companyId)
                .orElseThrow(BaseException::new);

        Recruitment recruitment = parameter.toBuilder()
                        .company(company)
                        .build();

        recruitmentRepository.save(recruitment);

        return recruitment.getId();
    }

    @Transactional
    public void update(Recruitment parameter) {

        Recruitment recruitment = getRecruitmentById(parameter.getId());

        recruitment.update(parameter.getPosition(),
                            parameter.getCompensation(),
                            parameter.getDetails(),
                            parameter.getTechStack());
    }

    @Transactional
    public void delete(Long id) {

        Recruitment recruitment = getRecruitmentById(id);

        recruitmentRepository.delete(recruitment);
    }

    @Transactional
    public Recruitment getRecruitmentById(Long id) {

        return recruitmentRepository.findById(id)
                .orElseThrow(BaseException::new);
    }

    @Transactional
    public List<Recruitment> getList() {

        return recruitmentRepository.findAll();
    }

}
