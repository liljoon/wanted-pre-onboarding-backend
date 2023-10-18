package com.example.wantedpreonboardingbackend.application;

import com.example.wantedpreonboardingbackend.jobposting.JobPostingRepository;
import com.example.wantedpreonboardingbackend.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class ApplicationController {
    ApplicationRepository repository;
    JobPostingRepository jobPostingRepository;
    UserRepository userRepository;

    @PostMapping("/application")
    public ResponseEntity createApplication(@RequestBody ApplicationRequestDto applicationRequestDto) {
        try {
            Application application = new Application(null,
                    jobPostingRepository.findById(applicationRequestDto.getJobPostingId()).orElseThrow(() -> new Exception("No Company!")),
                    userRepository.findById(applicationRequestDto.getUserId().longValue()).orElseThrow(() -> new Exception("No User!")));
            repository.save(application);

            return ResponseEntity.created(null).build();
        }
        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
