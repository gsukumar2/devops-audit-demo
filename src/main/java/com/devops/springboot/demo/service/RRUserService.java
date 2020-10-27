
package com.devops.springboot.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devops.springboot.demo.model.RedRockUser;
import com.devops.springboot.demo.repository.RRUserRepository;

@Service
public class RRUserService {

	@Autowired
	RRUserRepository repository;

	public List<RedRockUser> getAllRRUsers() {
		List<RedRockUser> rrUserList = repository.findAll();

		if (rrUserList.size() > 0) {
			return rrUserList;
		} else {
			return new ArrayList<RedRockUser>();
		}
	}

	public RedRockUser getRRUserById(Long id) {
		Optional<RedRockUser> rrUser = repository.findById(id);

		if (rrUser.isPresent()) {
			return rrUser.get();
		} else {
			return null;
		}
	}

	public RedRockUser createOrUpdateRRUser(RedRockUser entity) {
		Optional<RedRockUser> rrUser = null;
		if(entity.getId()!=null)
		{
		rrUser= repository.findById(entity.getId());
		}

		if (rrUser!=null && rrUser.isPresent()) {
			RedRockUser newEntity = rrUser.get();
			newEntity.setEmail(entity.getEmail());
			newEntity.setFirstName(entity.getFirstName());
			newEntity.setLastName(entity.getLastName());

			newEntity = repository.save(newEntity);

			return newEntity;
		} else {
			entity = repository.save(entity);

			return entity;
		}
	}

	public void deleteRRUserById(Long id) {
		Optional<RedRockUser> rrUser = repository.findById(id);

		if (rrUser.isPresent()) {
			repository.deleteById(id);
		}
	}
}