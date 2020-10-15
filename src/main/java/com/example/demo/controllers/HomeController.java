package com.example.demo.controllers;

import com.example.demo.entities.Employee;
import com.example.demo.entities.Project;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository proRepo;

    @Autowired
    EmployeeRepository empRepo;

    @GetMapping("/")
    public String displayHome(Model model) {
        List<Project> projects = proRepo.findAll();
        model.addAttribute("projectsList", projects);

        List<Employee> employees = empRepo.findAll();
        model.addAttribute("employeesList", employees);

        return "home";
    }
}
