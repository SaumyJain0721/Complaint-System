package com.saumyproject.complaint_system.controller;
import com.saumyproject.complaint_system.dto.ComplaintDTO;
import com.saumyproject.complaint_system.entity.Complaint;
import com.saumyproject.complaint_system.entity.Status;
import com.saumyproject.complaint_system.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


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
    public Page<ComplaintDTO> getComplaints(@RequestParam(required = false) Status status,
        Pageable pageable) {

        return complaintService.getComplaints(status, pageable);
    }
    @GetMapping("/{id}")
    public ComplaintDTO getComplaintById(@PathVariable Long id) {
        return complaintService.getComplaintById(id);
    }

    @PutMapping("/{id}/status")
    public Complaint updateStatus(
        @PathVariable Long id,
        @RequestParam Status status) {

        return complaintService.updateComplaintStatus(id, status);
    }
}
