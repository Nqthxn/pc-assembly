package com.example.pcbuilderapi.service;

import com.example.pcbuilderapi.dto.ComponentRequestDTO;
import com.example.pcbuilderapi.model.PCComponent;
import com.example.pcbuilderapi.repository.PCComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComponentService {
    private final PCComponentRepository pcComponentRepository;

    @Autowired
    public ComponentService(PCComponentRepository pcComponentRepository){
        this.pcComponentRepository = pcComponentRepository;
    }

    public List<PCComponent> getComponents(String type, String name){
        boolean hasType = type != null && !type.trim().isEmpty();
        boolean hasName = name != null && !name.trim().isEmpty();

        if(hasName && hasType){
            return pcComponentRepository.findByTypeAndNameContainingIgnoreCase(type, name);
        }else if(hasType){
            return pcComponentRepository.findByType(type);
        }else if(hasName){
            return pcComponentRepository.findByNameContainingIgnoreCase(name);
        }else{
            return pcComponentRepository.findAll();
        }
    }

    public PCComponent createComponent(ComponentRequestDTO componentDTO){
        PCComponent newComponent = new PCComponent(
            componentDTO.getName(),
            componentDTO.getType(),
            componentDTO.getBrand(),
            componentDTO.getPrice()
        );

        return pcComponentRepository.save(newComponent);
    }

    public Optional<PCComponent> getComponentById(Long id){
        return pcComponentRepository.findById(id);
    }

    public PCComponent persistComponent(PCComponent component) {
         return pcComponentRepository.save(component);
    }


    public Optional<PCComponent> updateComponent(Long id, ComponentRequestDTO componentRequestDTO){
        Optional<PCComponent> existingComponentOptional = pcComponentRepository.findById(id);

        if(existingComponentOptional.isPresent()){
            PCComponent existingComponent = existingComponentOptional.get();

            existingComponent.setName(componentRequestDTO.getName());
            existingComponent.setType(componentRequestDTO.getType());
            existingComponent.setBrand(componentRequestDTO.getBrand());
            existingComponent.setPrice(componentRequestDTO.getPrice());

            return Optional.of(pcComponentRepository.save(existingComponent));
        }else{
            return Optional.empty();
        }
    }

    public boolean deleteComponent(Long id){
        if(pcComponentRepository.existsById(id)){
            pcComponentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
