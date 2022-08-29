package com.example.recruitmentproject.dto;

import lombok.Getter;

@Getter
public class GithubRepoDTO {
    private String name;
    private boolean fork;
    private GithubOwnerDTO owner;
}
