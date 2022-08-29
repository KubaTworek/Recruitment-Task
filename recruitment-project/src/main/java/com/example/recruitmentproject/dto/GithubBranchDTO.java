package com.example.recruitmentproject.dto;

import lombok.Getter;

@Getter
public class GithubBranchDTO {
    private String name;
    private GithubCommitDTO commit;
}
