package com.example.pcbuilderapi.repository;

import org.springframework.stereotype.Repository;
import com.example.pcbuilderapi.model.PCComponent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface PCComponentRepository extends JpaRepository<PCComponent, Long>{
    List<PCComponent> findByType(String type);

    List<PCComponent> findByNameContainingIgnoreCase(String nameFragment);

    List<PCComponent> findByTypeAndNameContainingIgnoreCase(String type, String nameFragment);
}
