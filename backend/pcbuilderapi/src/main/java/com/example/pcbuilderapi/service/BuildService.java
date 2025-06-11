package com.example.pcbuilderapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.pcbuilderapi.dto.BuildRequest;
import com.example.pcbuilderapi.model.User;
import com.example.pcbuilderapi.model.UserBuild;
import com.example.pcbuilderapi.repository.UserBuildRepository;
import com.example.pcbuilderapi.repository.UserRepository;

@Service
public class BuildService {
    @Autowired
    private UserBuildRepository userBuildRepository;

    @Autowired
    private UserRepository userRepository;

    public UserBuild saveBuild(BuildRequest buildRequest, String username){
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found with username " + username));

        UserBuild userBuild = new UserBuild();
        userBuild.setBuildName(buildRequest.getBuildName());
        userBuild.setComponentIds(buildRequest.getComponentIds());
        userBuild.setUser(user);
        return userBuildRepository.save(userBuild);
    }

    public List<UserBuild> getBuildsForUser(String username){
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found with username " + username));
        return userBuildRepository.findByUserId(user.getId());
    }
}
