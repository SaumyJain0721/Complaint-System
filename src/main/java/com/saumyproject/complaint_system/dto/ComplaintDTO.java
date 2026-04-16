package com.saumyproject.complaint_system.dto;
import lombok.Getter;
import lombok.Setter;

import com.saumyproject.complaint_system.entity.Status;
@Getter@Setter
public class ComplaintDTO {

    private Long id;
    private String title;
    private String description;
    private Status status;
    private String userName;

    public ComplaintDTO() {}

    public ComplaintDTO(Long id, String title, String description, Status status, String userName) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.userName = userName;
    }

}
