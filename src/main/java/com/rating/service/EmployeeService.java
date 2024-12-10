package com.rating.service;

import com.rating.entity.SelfReview;
import com.rating.entity.Employee;
import com.rating.entity.ManagerReview;
import com.rating.repository.SelfReviewRepository;
import com.rating.repository.EmployeeRepository;
import com.rating.repository.ManagerReviewRepository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class EmployeeService {

    @Autowired
    private SelfReviewRepository selfReviewRepository;

    @Autowired
    private ManagerReviewRepository managerReviewRepository;
    
    @Autowired
    private EmployeeRepository employeeRepository;

    public String submitSelfReview(Long employeeId, SelfReview review) {
        // Fetch employee by ID
        Employee employee = employeeRepository.findById(Integer.parseInt(employeeId.toString()))
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + employeeId));

        // Map the review data
        review.setEmployee(employee);
        review.setSubmittedAt(LocalDateTime.now());

        // Save review
        selfReviewRepository.save(review);

        return "Self review submitted successfully";
    }

    public String submitManagerReview(Long employeeId, ManagerReview review) {
        // Fetch employee by ID
        Employee employee = employeeRepository.findById(Integer.parseInt(employeeId.toString()))
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + employeeId));

       review.setEmployee(employee);
        managerReviewRepository.save(review);
        return "Manager Review Submitted Successfully";
    }

    public String getPerformanceSummary(Long employeeId) {
        Employee emp = employeeRepository.findByEmployeeid(Integer.parseInt(employeeId.toString()))
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + employeeId));
        var selfReviews = selfReviewRepository.findByEmployee_Employeeid(emp.getEmployeeid());
        var managerReviews = managerReviewRepository.findByEmployee_Employeeid(emp.getEmployeeid());

        double selfScore = selfReviews.stream()
            .mapToDouble(e -> e.getReviewText().length() / 100.0)
            .average()
            .orElse(0.0);

        double managerScore = managerReviews.stream()
            .mapToDouble(e->e.getRating())
            .average()
            .orElse(0.0);

        double finalScore = (selfScore + managerScore) / 2;

        return String.format("Derived Performance Score: %.2f", finalScore);
    }
    public String saveEmployeeIfNotExists(Employee employee) {
        Optional<Employee> existingEmployee = employeeRepository.findByEmployeeid(employee.getEmployeeid());
        
        if (existingEmployee.isPresent()) {
            return "Employee already exists with email: " + employee.getEmail();
        }

        employeeRepository.save(employee);
        return "Employee saved successfully";
    }
}
