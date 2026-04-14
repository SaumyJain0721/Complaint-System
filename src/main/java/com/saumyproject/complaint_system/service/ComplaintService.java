package com.saumyproject.complaint_system.service;


import com.saumyproject.complaint_system.entity.*;
import com.saumyproject.complaint_system.exception.ResourceNotFoundException;
import com.saumyproject.complaint_system.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    @Autowired
    private UserRepository userRepository;

    public Complaint createComplaint(Long userId, Complaint complaint) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        complaint.setUser(user);
        complaint.setStatus(Status.OPEN);
        complaint.setCreatedAt(LocalDateTime.now());

        return complaintRepository.save(complaint);
    }

    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }
    public Complaint getComplaintById(Long id) {
        return complaintRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Complaint not found"));
    }
}
