package com.saumyproject.complaint_system.service;


import com.saumyproject.complaint_system.dto.ComplaintDTO;
import com.saumyproject.complaint_system.entity.*;
import com.saumyproject.complaint_system.exception.ResourceNotFoundException;
import com.saumyproject.complaint_system.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


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

    public ComplaintDTO getComplaintById(Long id) {
        Complaint complaint = complaintRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Complaint not found"));

        return mapToDTO(complaint);
    }
    public Complaint updateComplaintStatus(Long id, Status status) {
        
        Complaint complaint = complaintRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Complaint not found"));
        
        complaint.setStatus(status);
        
        return complaintRepository.save(complaint);
        
    }

   public Page<ComplaintDTO> getComplaints(Status status, Pageable pageable) {

        Page<Complaint> complaints;

        if (status != null) {
        complaints = complaintRepository.findByStatus(status, pageable);
        }   
        else {
        complaints = complaintRepository.findAll(pageable);
        }

        return complaints.map(this::mapToDTO);
    }

    private ComplaintDTO mapToDTO(Complaint complaint) {
        return new ComplaintDTO(
            complaint.getId(),
            complaint.getTitle(),
            complaint.getDescription(),
            complaint.getStatus(),
            complaint.getUser().getName()
        );
    }
        
}
    