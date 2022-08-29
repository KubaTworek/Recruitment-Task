package com.example.recruitmentproject.client;

import com.example.recruitmentproject.dto.GithubBranchDTO;
import com.example.recruitmentproject.dto.GithubRepoDTO;
import com.example.recruitmentproject.dto.GithubUser;
import com.example.recruitmentproject.errors.GithubUserNotFoundException;
import com.example.recruitmentproject.model.GithubDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import com.example.recruitmentproject.dto.GithubRepoDTO;

@Component
public class GithubClient {
    private static final String GITHUB_URL = "https://api.github.com/users/";
    private static final String REPOS_URL = "/repos";
    private RestTemplate restTemplate = new RestTemplate();

    public List<GithubDTO> getInfo(String username) {
        List<GithubRepoDTO> test = new ArrayList<>();
        GithubRepoDTO[] githubReposDTO = callGetMethod("https://api.github.com/users/{username}/repos",GithubRepoDTO[].class , username);


        List<GithubDTO> githubDTOs = new ArrayList<>();

        for(GithubRepoDTO githubRepoDTO : githubReposDTO){

            String repoName = githubRepoDTO.getName();
            GithubBranchDTO[] githubBranchesDTO = callGetMethod("https://api.github.com/repos/{username}/{repoName}/branches",GithubBranchDTO[].class, username, repoName);

            GithubDTO githubDTO = GithubDTO.builder()
                    .name(githubRepoDTO.getName())
                    .login(githubRepoDTO.getOwner().getLogin())
                    .branches(Arrays.stream(githubBranchesDTO).toList())
                    .build();
            if(!githubDTO.isFork()) githubDTOs.add(githubDTO);

        }

        return githubDTOs;
    }

    public GithubUser getUser(String username) throws GithubUserNotFoundException{
        GithubUser user = callGetMethod("https://api.github.com/users/{username}",GithubUser.class, username);
        return user;
    }

    private <T> T callGetMethod(String url, Class<T> responseType, Object... objects){
        return restTemplate.getForObject(url, responseType, objects);
    }
}
