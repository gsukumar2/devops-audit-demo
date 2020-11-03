package com.devops.springboot.demo.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devops.springboot.demo.model.RedRockUser;
 
 
/**
 * RRUser Repository
 *
 */
@Repository
public interface RRUserRepository 
        extends  CrudRepository<RedRockUser, Long> {
	 List<RedRockUser> findByFirstName(String name); 
 
}