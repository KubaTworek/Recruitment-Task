package com.example.recruitmentproject.api;

import com.example.recruitmentproject.dto.GithubRepoDTO;
import com.example.recruitmentproject.errors.GithubUserNotFoundException;
import com.example.recruitmentproject.errors.IncorrectHeaderException;
import com.example.recruitmentproject.model.GithubDTO;
import com.example.recruitmentproject.service.GithubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private GithubService githubService;

    @GetMapping("/{username}")
    public List<GithubDTO> getUsers(@PathVariable String username,@RequestHeader(HttpHeaders.CONTENT_TYPE) String contentType) throws GithubUserNotFoundException{
        if(!contentType.equals("application/json")) throw new IncorrectHeaderException("You should use header - application/json");
        try{
            githubService.getUser(username);
        } catch (HttpClientErrorException e){
            throw new GithubUserNotFoundException("User " + username + " not found");
        }
        return githubService.getInfo(username);
    }
}
