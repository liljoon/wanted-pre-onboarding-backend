package com.example.wantedpreonboardingbackend.jobposting;

import com.example.wantedpreonboardingbackend.company.Company;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JobPosting {

    @Id
    @GeneratedValue
    private Long jobPostingId;

    @ManyToOne
    private Company company;

    private String position;

    private int reward;

    private String description;

    private String usingSkill;

    @Override
    public String toString() {
        return "JobPosting{" +
                "jobPostingId=" + jobPostingId +
                ", company=" + company +
                ", position='" + position + '\'' +
                ", reward=" + reward +
                ", description='" + description + '\'' +
                ", usingSkill='" + usingSkill + '\'' +
                '}';
    }
}
