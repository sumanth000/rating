package com.rating.entity;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "managerreview")
public class ManagerReview {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "employeeid", nullable = false)
	private Employee employee;

	@Column(name = "review_text", nullable = false, columnDefinition = "TEXT")
	private String reviewText;

	@Column(nullable = false)
	private Double rating;

	@Column(name = "submitted_at", nullable = false)
	private LocalDateTime submittedAt;

	@Column(name = "reviewtext", length = 255)
	private String reviewTextShort;

	// Default Constructor
	public ManagerReview() {}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public LocalDateTime getSubmittedAt() {
		return submittedAt;
	}

	public void setSubmittedAt(LocalDateTime submittedAt) {
		this.submittedAt = submittedAt;
	}

	public String getReviewTextShort() {
		return reviewTextShort;
	}

	public void setReviewTextShort(String reviewTextShort) {
		this.reviewTextShort = reviewTextShort;
	}
}
