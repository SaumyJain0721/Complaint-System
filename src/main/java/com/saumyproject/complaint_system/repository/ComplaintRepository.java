package com.saumyproject.complaint_system.repository;

import com.saumyproject.complaint_system.entity.Complaint;
import com.saumyproject.complaint_system.entity.Status;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
    List<Complaint> findByStatus(Status status);
    Page<Complaint> findByStatus(Status status, Pageable pageable);
}
