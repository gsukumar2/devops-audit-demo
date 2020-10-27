package com.devops.springboot.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
 
@Repository
public interface RRUserRepository 
        extends JpaRepository<com.devops.springboot.demo.model.RedRockUser, Long> {
 
}