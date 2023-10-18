package com.example.wantedpreonboardingbackend.company;

import com.example.wantedpreonboardingbackend.jobposting.JobPosting;
import jakarta.persistence.*;
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
