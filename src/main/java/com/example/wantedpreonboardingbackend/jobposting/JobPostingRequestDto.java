package com.example.wantedpreonboardingbackend.jobposting;

import com.example.wantedpreonboardingbackend.company.CompanyRepository;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@Getter
@Service
public class JobPostingRequestDto {
    @JsonProperty("company_id")
    private Integer companyId;

    private String position;

    private Integer reward;

    private String description;

    private String usingSkill;

    @Override
    public String toString() {
        return "JobPostingRequestDto{" +
                "company_id=" + companyId +
                ", position='" + position + '\'' +
                ", reward=" + reward +
                ", description='" + description + '\'' +
                ", usingSkill='" + usingSkill + '\'' +
                '}';
    }

    public JobPosting toEntity(CompanyRepository companyRepository) {
        JobPosting jobPosting = new JobPosting(null, companyRepository.findById(companyId).orElse(null), position, reward, description, usingSkill);

        return jobPosting;
    }

    public JobPosting updateAndToEntity(JobPosting oldJobPosting) {
        if (companyId != null) {
            //company_id 수정 에러
            return null;
        }
        if (position != null)
            oldJobPosting.setPosition(position);
        if (reward != null)
            oldJobPosting.setReward(reward);
        if (description != null)
            oldJobPosting.setDescription(description);
        if (usingSkill != null)
            oldJobPosting.setUsingSkill(usingSkill);

        return oldJobPosting;
    }
}
