package com.example.recruitmentproject.model;

import com.example.recruitmentproject.dto.GithubBranchDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class GithubDTO {
    private String name;
    @JsonIgnore
    private boolean fork;
    private String login;
    private List<GithubBranchDTO> branches;
}
