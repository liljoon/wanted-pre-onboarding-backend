package com.example.wantedpreonboardingbackend.application;

import com.example.wantedpreonboardingbackend.jobposting.JobPosting;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Application {

    @Id
    @GeneratedValue
    private int applicationId;

    @ManyToOne
    private JobPosting jobPosting;
}
