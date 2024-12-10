package com.rating.repository;

import com.rating.entity.ManagerReview;
import com.rating.entity.SelfReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ManagerReviewRepository extends JpaRepository<ManagerReview, Long> {
    List<ManagerReview> findByEmployee_Employeeid(Integer employeeid);

}
