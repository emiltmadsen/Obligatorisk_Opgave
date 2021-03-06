package com.example.demo.controllers;

import com.example.demo.entities.Employee;
import com.example.demo.entities.Project;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    ProjectRepository proRepo;

    @Autowired
    EmployeeRepository empRepo;

    @GetMapping
    public String displayEmployees(Model model) {
        List<Employee> employees = empRepo.findAll();
        model.addAttribute("employees", employees);
        return "employees/list-employees";
    }

    @GetMapping("/new")
    public String displayEmployeeForm(Model model) {

        Employee anEmployee = new Employee();
        List<Project> projects = proRepo.findAll();
        model.addAttribute("allProjects", projects);
        model.addAttribute("employee", anEmployee);


        return "employees/new-employee";
    }

    // This handles the saving to the h2 database
    @PostMapping("/save")
    public String createEmployee(Employee employee, Model model) {
        empRepo.save(employee);

        // Use a redirect to prevent duplicate submissions
        return "redirect:/employees/new";
    }

}