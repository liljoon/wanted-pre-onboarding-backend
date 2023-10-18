package com.example.wantedpreonboardingbackend.jobposting;

import com.example.wantedpreonboardingbackend.company.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
public class JobPostingController {

    JobPostingRepository repository;
    CompanyRepository companyRepository;

    @PostMapping("/jobposting")
    public void createJobPosting(@RequestBody() JobPostingRequestDto jobPostingRequestDto) {
        JobPosting jobPosting = jobPostingRequestDto.toEntity(companyRepository);
        jobPosting.getCompany().getJobPostings().add(jobPosting);
        repository.save(jobPosting);
    }

    @PutMapping("/jobposting/{id}")
    public void updateJobPosting(@PathVariable int id, @RequestBody JobPostingRequestDto jobPostingRequestDto) {
        JobPosting newJobPosting = jobPostingRequestDto.updateAndToEntity(repository.findById(id).orElse(null));
        repository.save(newJobPosting);
    }

    @DeleteMapping("/jobposting/{id}")
    public void deleteJobPosting(@PathVariable int id) {
        repository.deleteById(id);
    }

    @GetMapping("/jobposting")
    public List<JobPostingResponseDto>  retrieveAllJobPostings() {
        List<JobPosting> jobPostings = repository.findAll();
        List<JobPostingResponseDto> jobPostingResponseDtoList = new ArrayList<>();


        jobPostings.forEach(jobPosting -> {
            JobPostingResponseDto jobPostingResponseDto = new JobPostingResponseDto();
            jobPostingResponseDto.fromEntity(jobPosting);
            jobPostingResponseDtoList.add(jobPostingResponseDto);
        });

        return jobPostingResponseDtoList;
    }

    @GetMapping("/jobposting/{id}")
    public JobPostingDetailResponseDto retrieveJobPostingDetail(@PathVariable int id) {
        JobPosting jobPosting = repository.findById(id).orElse(null);
        JobPostingDetailResponseDto jobPostingDetailResponseDto = new JobPostingDetailResponseDto();
        jobPostingDetailResponseDto.fromEntity(jobPosting);

        return jobPostingDetailResponseDto;
    }


}
