package com.example.wantedpreonboardingbackend.jobposting;

import com.example.wantedpreonboardingbackend.company.CompanyRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@Getter
@Service
public class JobPostingRequestDto {
    private Integer company_id;

    private String position;

    private Integer reward;

    private String description;

    private String usingSkill;

    @Override
    public String toString() {
        return "JobPostingRequestDto{" +
                "company_id=" + company_id +
                ", position='" + position + '\'' +
                ", reward=" + reward +
                ", description='" + description + '\'' +
                ", usingSkill='" + usingSkill + '\'' +
                '}';
    }

    public JobPosting toEntity(CompanyRepository companyRepository) {
        JobPosting jobPosting = new JobPosting(null, companyRepository.findById(company_id).orElse(null), position, reward, description, usingSkill);

        return jobPosting;
    }

    public JobPosting updateAndToEntity(JobPosting oldJobPosting) {
        if (company_id != null) {
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
