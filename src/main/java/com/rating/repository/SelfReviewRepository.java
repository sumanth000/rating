package com.rating.repository;

import com.rating.entity.SelfReview;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SelfReviewRepository extends JpaRepository<SelfReview, Long> {
    List<SelfReview> findByEmployee_Employeeid(Integer employeeId);

}
