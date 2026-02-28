package com.sahil.taskmanager.repository;

import com.sahil.taskmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User , Integer>{
    User getUserByUsername(String username);
}
