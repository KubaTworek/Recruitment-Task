package com.example.recruitmentproject.service;

import com.example.recruitmentproject.client.GithubClient;
import com.example.recruitmentproject.dto.GithubUser;
import com.example.recruitmentproject.model.GithubDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GithubService {

    @Autowired
    private GithubClient githubClient;

    public List<GithubDTO> getInfo(String username){
        return githubClient.getInfo(username);
    }

    public GithubUser getUser(String username){
        return githubClient.getUser(username);
    }
}
