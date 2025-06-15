package com.example.pcbuilderapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.pcbuilderapi.model.PCComponent;
import com.example.pcbuilderapi.repository.UserRepository;
import com.example.pcbuilderapi.service.BuildService;
import com.example.pcbuilderapi.service.ComponentService;

@SpringBootApplication
public class PcbuilderapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PcbuilderapiApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(BuildService buildService, ComponentService componentService, UserRepository userRepository) {
        return args -> {
            // Clear existing data to avoid duplicates on restart during development
            buildService.deleteAllBuilds();
            userRepository.deleteAll();
            componentService.deleteAllComponents(); // You'll need to add this method to your service/repo

            System.out.println("Populating database with realistic sample components...");

            // CPUs
            componentService.persistComponent(new PCComponent("Intel Core i9-14900K", "CPU", "Intel", 549.99, "https://placehold.co/400x400/1e293b/ffffff?text=i9-14900K"));
            componentService.persistComponent(new PCComponent("AMD Ryzen 9 7950X3D", "CPU", "AMD", 699.00, "https://placehold.co/400x400/1e293b/ffffff?text=Ryzen+9"));
            componentService.persistComponent(new PCComponent("Intel Core i5-14600K", "CPU", "Intel", 319.50, "https://placehold.co/400x400/1e293b/ffffff?text=i5-14600K"));

            // GPUs
            componentService.persistComponent(new PCComponent("NVIDIA GeForce RTX 4090", "GPU", "NVIDIA", 1599.99, "https://placehold.co/400x400/1e293b/ffffff?text=RTX+4090"));
            componentService.persistComponent(new PCComponent("AMD Radeon RX 7900 XTX", "GPU", "AMD", 999.00, "https://placehold.co/400x400/1e293b/ffffff?text=RX+7900XTX"));
            componentService.persistComponent(new PCComponent("NVIDIA GeForce RTX 4070 Super", "GPU", "NVIDIA", 599.00, "https://placehold.co/400x400/1e293b/ffffff?text=RTX+4070S"));

            // Motherboards
            componentService.persistComponent(new PCComponent("ASUS ROG Strix Z790-E", "Motherboard", "ASUS", 499.99, "https://placehold.co/400x400/1e293b/ffffff?text=Z790-E"));
            componentService.persistComponent(new PCComponent("Gigabyte B650 AORUS ELITE", "Motherboard", "Gigabyte", 219.99, "https://placehold.co/400x400/1e293b/ffffff?text=B650"));

            // RAM
            componentService.persistComponent(new PCComponent("Corsair Vengeance 32GB DDR5", "RAM", "Corsair", 114.99, "https://placehold.co/400x400/1e293b/ffffff?text=DDR5+RAM"));
            componentService.persistComponent(new PCComponent("G.Skill Trident Z5 32GB DDR5", "RAM", "G.Skill", 124.99, "https://placehold.co/400x400/1e293b/ffffff?text=Trident+Z5"));

            System.out.println("Database population complete.");
        };
    }
}
