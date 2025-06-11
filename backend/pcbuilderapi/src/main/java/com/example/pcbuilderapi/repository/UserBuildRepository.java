package com.example.pcbuilderapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pcbuilderapi.model.UserBuild;


public interface UserBuildRepository extends JpaRepository<UserBuild, Long>{
    List<UserBuild> findByUserId(Long userId);
}
