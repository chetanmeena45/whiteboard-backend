package com.vidyayatan.whiteboard.whiteboard.repository;

import com.vidyayatan.whiteboard.whiteboard.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}