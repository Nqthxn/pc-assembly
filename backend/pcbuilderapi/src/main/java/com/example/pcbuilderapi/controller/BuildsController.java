package com.example.pcbuilderapi.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pcbuilderapi.dto.BuildRequest;
import com.example.pcbuilderapi.dto.BuildResponse;
import com.example.pcbuilderapi.model.UserBuild;
import com.example.pcbuilderapi.service.BuildService;

@RestController
@RequestMapping("/api/builds")
public class BuildsController {

    @Autowired
    private BuildService buildService;

    @PostMapping
    public ResponseEntity<?> saveBuild(@RequestBody BuildRequest buildRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        UserBuild savedBuild = buildService.saveBuild(buildRequest, currentPrincipalName);
        return ResponseEntity.ok(new BuildResponse(savedBuild.getId(), savedBuild.getBuildName(), savedBuild.getComponentIds()));
    }

    @GetMapping
    public ResponseEntity<List<BuildResponse>> getUserBuilds() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        List<UserBuild> builds = buildService.getBuildsForUser(currentPrincipalName);
        List<BuildResponse> response = builds.stream()
                .map(build -> new BuildResponse(build.getId(), build.getBuildName(), build.getComponentIds()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }
}