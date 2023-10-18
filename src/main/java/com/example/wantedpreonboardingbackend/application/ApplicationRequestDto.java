package com.example.wantedpreonboardingbackend.application;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ApplicationRequestDto {

    @JsonProperty("jobPosting_id")
    private Integer jobPostingId;

    @JsonProperty("user_id")
    private Integer userId;
}
