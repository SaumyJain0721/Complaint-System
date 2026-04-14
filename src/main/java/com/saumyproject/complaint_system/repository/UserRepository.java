package com.saumyproject.complaint_system.repository;

import com.saumyproject.complaint_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}