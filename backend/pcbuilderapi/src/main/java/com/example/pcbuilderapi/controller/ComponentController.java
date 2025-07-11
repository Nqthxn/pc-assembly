package com.example.pcbuilderapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping; // Ensure this imports CrossOrigin
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pcbuilderapi.dto.ComponentRequestDTO;
import com.example.pcbuilderapi.model.PCComponent;
import com.example.pcbuilderapi.service.ComponentService;

@RestController
@RequestMapping("/api/components") 
public class ComponentController {

    private final ComponentService componentService;

    @Autowired
    public ComponentController(ComponentService componentService) {
        this.componentService = componentService;
    }

    @GetMapping
    public List<PCComponent> getComponents(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String name) {
        return componentService.getComponents(type, name);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PCComponent> getComponentById(@PathVariable Long id) {
        Optional<PCComponent> componentOptional = componentService.getComponentById(id);
        if (componentOptional.isPresent()) {
            return ResponseEntity.ok(componentOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<PCComponent> createComponent(@RequestBody ComponentRequestDTO componentRequestDTO) {
        PCComponent createdComponent = componentService.createComponent(componentRequestDTO);
        return new ResponseEntity<>(createdComponent, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PCComponent> updateComponent(
            @PathVariable Long id,
            @RequestBody ComponentRequestDTO componentRequestDTO) {
        Optional<PCComponent> updatedComponentOptional = componentService.updateComponent(id, componentRequestDTO);
        if (updatedComponentOptional.isPresent()) {
            return ResponseEntity.ok(updatedComponentOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComponent(@PathVariable Long id) {
        boolean deleted = componentService.deleteComponent(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}