package com.example.pcbuilderapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.pcbuilderapi.model.PCComponent;
import com.example.pcbuilderapi.service.ComponentService;

@SpringBootApplication
public class PcbuilderapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PcbuilderapiApplication.class, args);
	}

	@Bean 
	CommandLineRunner initDatabase(ComponentService componentService){
		return args -> {
			System.out.println("Initializing database with sample components...");

            // Use the constructor that does NOT take an ID, as ID is auto-generated
          	componentService.persistComponent(new PCComponent("AMD Ryzen 7 7800X3D", "CPU", "AMD", 449.00));
			componentService.persistComponent(new PCComponent("NVIDIA GeForce RTX 4080 Super", "GPU", "NVIDIA", 999.99));
			componentService.persistComponent(new PCComponent("G.Skill Trident Z5 32GB", "RAM", "G.Skill", 120.50));
			componentService.persistComponent(new PCComponent("Crucial P5 Plus 2TB", "SSD", "Crucial", 150.00));


            System.out.println("Sample components initialized:");
            componentService.getComponents(null, null).forEach(component ->
                    System.out.println("Found component: " + component.getName() + " (ID: " + component.getId() + ")")
            );
		};
	}

}
