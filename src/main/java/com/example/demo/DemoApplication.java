package com.example.demo;

import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    EmployeeRepository empRepo;

    @Autowired
    ProjectRepository proRepo;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
