package com.rating.service;

import com.rating.entity.ManagerReview;
import com.rating.entity.SelfReview;
import com.rating.repository.ManagerReviewRepository;
import com.rating.repository.SelfReviewRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private SelfReviewRepository selfReviewRepository;

    @Mock
    private ManagerReviewRepository managerReviewRepository;

    public EmployeeServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetPerformanceSummary() {
        when(selfReviewRepository.findByEmployee_Employeeid(1L)).thenReturn(Collections.singletonList(new SelfReview()));
        when(managerReviewRepository.findByEmployee_Employeeid(1L)).thenReturn(Collections.singletonList(new ManagerReview()));

        String result = employeeService.getPerformanceSummary(1L);

        assertEquals("Derived Performance Score: 0.0", result);
    }
}
