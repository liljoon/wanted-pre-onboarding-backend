package com.example.wantedpreonboardingbackend.jobposting;

import com.example.wantedpreonboardingbackend.company.CompanyRepository;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
public class JobPostingController {

    JobPostingRepository repository;
    CompanyRepository companyRepository;

    @PostMapping("/jobposting")
    public ResponseEntity createJobPosting(@RequestBody() JobPostingRequestDto jobPostingRequestDto) {
        try {
            JobPosting jobPosting = jobPostingRequestDto.toEntity(companyRepository);
            jobPosting.getCompany().getJobPostings().add(jobPosting);
            repository.save(jobPosting);

            return ResponseEntity.created(null).build();
        }
        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/jobposting/{id}")
    public ResponseEntity updateJobPosting(@PathVariable int id, @RequestBody JobPostingRequestDto jobPostingRequestDto) {
        try {
            JobPosting newJobPosting = jobPostingRequestDto.updateAndToEntity(repository.findById(id).orElseThrow(() -> new Exception("No JobPosting!")));
            repository.save(newJobPosting);

            return ResponseEntity.created(null).build();
        }
        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/jobposting/{id}")
    public ResponseEntity deleteJobPosting(@PathVariable int id) {
        JobPosting jobPosting = repository.findById(id).orElse(null);
        if (jobPosting == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            jobPosting.getCompany().getJobPostings().remove(jobPosting);
            repository.deleteById(id);
            return ResponseEntity.noContent().build();

        }
    }

    @GetMapping("/jobposting")
    public List<JobPostingResponseDto>  retrieveAllJobPostings(@RequestParam(required = false) String search) {
        List<JobPosting> jobPostings = repository.findAll();
        List<JobPostingResponseDto> jobPostingResponseDtoList = new ArrayList<>();

        if (search == null) {
            jobPostings.forEach(jobPosting -> {
                JobPostingResponseDto jobPostingResponseDto = new JobPostingResponseDto();
                jobPostingResponseDto.fromEntity(jobPosting);
                jobPostingResponseDtoList.add(jobPostingResponseDto);
            });
        }
        else {
            jobPostings.forEach(jobPosting -> {
                JobPostingResponseDto jobPostingResponseDto = new JobPostingResponseDto();
                jobPostingResponseDto.fromEntity(jobPosting);
                if (jobPostingResponseDto.getPosition().contains(search)
                        || jobPostingResponseDto.getUsingSkill().contains(search)
                        || jobPostingResponseDto.getCompanyName().contains(search)
                        || jobPostingResponseDto.getCompanyNation().contains(search)
                        || jobPostingResponseDto.getCompanyRegion().contains(search)) {
                    jobPostingResponseDtoList.add(jobPostingResponseDto);
                }
            });
        }

        return jobPostingResponseDtoList;
    }

    @GetMapping("/jobposting/{id}")
    public ResponseEntity retrieveJobPostingDetail(@PathVariable int id) {
        try {
            JobPosting jobPosting = repository.findById(id).orElseThrow(() -> new Exception("No JobPosting!"));
            JobPostingDetailResponseDto jobPostingDetailResponseDto = new JobPostingDetailResponseDto();
            jobPostingDetailResponseDto.fromEntity(jobPosting);

            return ResponseEntity.ok(jobPostingDetailResponseDto);
        }
        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


}
