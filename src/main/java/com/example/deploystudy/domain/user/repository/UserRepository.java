package com.example.deploystudy.domain.user.repository;

import com.example.deploystudy.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
