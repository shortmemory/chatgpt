package com.plexpt.chatgpt.web.repository;

import com.plexpt.chatgpt.web.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

