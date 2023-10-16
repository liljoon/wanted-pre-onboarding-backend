package com.example.wantedpreonboardingbackend.company;

import com.example.wantedpreonboardingbackend.jobposting.JobPosting;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Company {

    @Id
    @GeneratedValue
    private int companyId;

    private String name;

    private String nation;

    private String region;

    @OneToMany
    private List<JobPosting> jobPostings;
}
