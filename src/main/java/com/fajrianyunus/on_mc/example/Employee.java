package com.fajrianyunus.on_mc.example;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Employee {
	@Id
	@GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(updatable=false)	
	private Long id;
	
	@Column(columnDefinition="TEXT", nullable=false)
	private String fullName;
	
	@Column(nullable=false)
	private Double wage;
	
	private Date createdAt;
	
	private Date updatedAt;
	
	@Version
	private Long updateCounter;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Double getWage() {
		return wage;
	}

	public void setWage(Double wage) {
		this.wage = wage;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@PrePersist
    public void beforeInsert() {
		Date now = new Date();
        createdAt = now;
        updatedAt = now;
    }
     
    @PreUpdate
    public void beforeUpdate() {
        updatedAt = new Date();
    }

	public Long getUpdateCounter() {
		return updateCounter;
	}

	public void setUpdateCounter(Long updateCounter) {
		this.updateCounter = updateCounter;
	}	
}
