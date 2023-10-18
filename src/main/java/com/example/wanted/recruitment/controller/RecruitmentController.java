package com.example.wanted.recruitment.controller;

import com.example.wanted.recruitment.controller.dto.RecruitmentRequest;
import com.example.wanted.recruitment.domain.Recruitment;
import com.example.wanted.recruitment.service.RecruitmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RecruitmentController {

    private final RecruitmentService recruitmentService;

    @PostMapping("/recruitments/new")
    public ResponseEntity<Long> register(@RequestBody @Valid RecruitmentRequest request) {

        Recruitment recruitment = Recruitment.builder()
                                    .position(request.getPosition())
                                    .compensation(request.getCompensation())
                                    .details(request.getDetails())
                                    .techStack(request.getTechStack())
                                    .build();

        Long recruitmentId = recruitmentService.save(request.getCompanyId(), recruitment);

        return ResponseEntity.ok(recruitmentId);
    }

    @PatchMapping("/recruitments/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long id,
                                  @RequestBody @Valid RecruitmentRequest request) {

        Recruitment recruitment = Recruitment.builder()
                                    .id(id)
                                    .position(request.getPosition())
                                    .compensation(request.getCompensation())
                                    .details(request.getDetails())
                                    .techStack(request.getTechStack())
                                    .build();

        recruitmentService.update(recruitment);
    }

    @DeleteMapping("/recruitments/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {

        recruitmentService.delete(id);
    }

    @GetMapping("/recruitments/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Recruitment> getRecruitment(@PathVariable Long id) {

        Recruitment recruitment = recruitmentService.getRecruitmentById(id);

        return ResponseEntity.ok(recruitment);
    }

    @GetMapping("/recruitments")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Recruitment>> getList() {

        List<Recruitment> recruitments = recruitmentService.getList();

        return ResponseEntity.ok(recruitments);
    }
}
