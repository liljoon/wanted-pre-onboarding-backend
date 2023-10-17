package com.example.wantedpreonboardingbackend.jobposting;

import lombok.Getter;

@Getter
public class JobPostingResponseDto {

    private Long jobPostingId;

    private String companyName;

    private String companyNation;

    private String companyRegion;

    private String position;

    private int reward;

    private String usingSkill;

    @Override
    public String toString() {
        return "JobPostingResponseDto{" +
                "jobPostingId=" + jobPostingId +
                ", companyName='" + companyName + '\'' +
                ", companyNation='" + companyNation + '\'' +
                ", companyRegion='" + companyRegion + '\'' +
                ", position='" + position + '\'' +
                ", reward=" + reward +
                ", usingSkill='" + usingSkill + '\'' +
                '}';
    }

    public JobPostingResponseDto fromEntity(JobPosting jobPosting) {
        jobPostingId = jobPosting.getJobPostingId();
        companyName = jobPosting.getCompany().getName();
        companyNation = jobPosting.getCompany().getNation();
        companyRegion = jobPosting.getCompany().getRegion();
        position = jobPosting.getPosition();
        reward = jobPosting.getReward();
        usingSkill = jobPosting.getUsingSkill();

        return this;
    }
}
