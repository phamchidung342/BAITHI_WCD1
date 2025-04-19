package com.example.Test.controller;

import com.example.Test.model.Employee;
import com.example.Test.repository.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("employees", repository.findAll());
        return "employee-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee-form";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute Employee employee) {
        repository.save(employee);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("employee", repository.findById(id).orElse(new Employee()));
        return "employee-form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        repository.deleteById(id);
        return "redirect:/";
    }
}