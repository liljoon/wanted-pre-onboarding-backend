package com.example.wantedpreonboardingbackend.jobposting;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class JobPostingDetailResponseDto extends JobPostingResponseDto{
    private String description;
    private List<Long> SameCompanyJobPostingsId;

    @Override
    public JobPostingResponseDto fromEntity(JobPosting jobPosting) {
        super.fromEntity(jobPosting);
        description = jobPosting.getDescription();

        SameCompanyJobPostingsId = new ArrayList<>();
        jobPosting.getCompany().getJobPostings().forEach(sameCompanyJobPosting -> {
            // 자신을 제외한 JobPosting만 띄움
            if (sameCompanyJobPosting.getJobPostingId() != jobPosting.getJobPostingId())
                SameCompanyJobPostingsId.add(sameCompanyJobPosting.getJobPostingId());
        });

        return this;
    }
}
