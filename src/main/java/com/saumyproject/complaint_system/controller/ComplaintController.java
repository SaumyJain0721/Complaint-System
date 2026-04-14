package com.saumyproject.complaint_system.controller;
import com.saumyproject.complaint_system.entity.Complaint;
import com.saumyproject.complaint_system.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/complaints")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @PostMapping("/{userId}")
    public Complaint createComplaint(
            @PathVariable Long userId,
            @RequestBody Complaint complaint) {

        return complaintService.createComplaint(userId, complaint);
    }

    @GetMapping
    public List<Complaint> getAllComplaints() {
        return complaintService.getAllComplaints();
    }
    @GetMapping("/{id}")
    public Complaint getComplaintById(@PathVariable Long id) {
        return complaintService.getComplaintById(id);
    }
}
