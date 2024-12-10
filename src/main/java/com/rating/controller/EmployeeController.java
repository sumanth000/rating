package com.rating.controller;

import com.rating.entity.SelfReview;
import com.rating.entity.Employee;
import com.rating.entity.ManagerReview;
import com.rating.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    
    @GetMapping("/check")
    public String healthcheck() {
        return "hi";
    }

    
    @PostMapping("/save")
    public String saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployeeIfNotExists(employee);
    }

    @PostMapping("/{employeeId}/self-review")
    public String submitSelfReview(@PathVariable Long employeeId, @RequestBody SelfReview review) {
        return employeeService.submitSelfReview(employeeId, review);
    }

    @PostMapping("/{employeeId}/manager-review")
    public String submitManagerReview(@PathVariable Long employeeId, @RequestBody ManagerReview review) {
        return employeeService.submitManagerReview(employeeId, review);
    }

    @GetMapping("/{employeeId}/summary")
    public String getPerformanceSummary(@PathVariable Long employeeId) {
        return employeeService.getPerformanceSummary(employeeId);
    }
}
