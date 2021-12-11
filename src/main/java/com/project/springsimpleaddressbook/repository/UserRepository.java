package com.project.springsimpleaddressbook.repository;

import com.project.springsimpleaddressbook.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

    boolean existsByIdentityNumber(String identityNumber);

    Optional<User> findByEmail(String email);

    Optional<Object> findByIdentityNumber(String identityNumber);
}
