package com.example.wantedpreonboardingbackend.jobposting;

import com.example.wantedpreonboardingbackend.company.Company;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
    private int jobPostingId;

    @ManyToOne
    private Company company;

    private String position;

    private int reward;

    private String description;

    private String usingSkill;

}
