package org.wrabz.com.project_with_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wrabz.com.project_with_security.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findUserByUsername(String username);
}
