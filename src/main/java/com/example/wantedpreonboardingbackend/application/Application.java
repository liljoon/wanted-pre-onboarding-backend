package com.example.wantedpreonboardingbackend.application;

import com.example.wantedpreonboardingbackend.jobposting.JobPosting;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Application {

    @Id
    @GeneratedValue
    private Long applicationId;

    @ManyToOne
    private JobPosting jobPosting;

    private Integer userId;
}
