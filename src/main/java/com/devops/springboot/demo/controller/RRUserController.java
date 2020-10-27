package com.devops.springboot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devops.springboot.demo.model.RedRockUser;
import com.devops.springboot.demo.service.RRUserService;

@RestController
@RequestMapping("/rrUsers")
public class RRUserController {
	@Autowired
	RRUserService service;

	@GetMapping
	public ResponseEntity<List<RedRockUser>> getAllRRUsers() {
		List<RedRockUser> list = service.getAllRRUsers();

		return new ResponseEntity<List<RedRockUser>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<RedRockUser> getRRUserById(@PathVariable("id") Long id) {
		RedRockUser entity = service.getRRUserById(id);

		return new ResponseEntity<RedRockUser>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<RedRockUser> createOrUpdateRRUser(@RequestBody RedRockUser rrUser) {
		RedRockUser updated = service.createOrUpdateRRUser(rrUser);
		
		return new ResponseEntity<RedRockUser>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteRRUserById(@PathVariable("id") Long id) {
		service.deleteRRUserById(id);
		return HttpStatus.FORBIDDEN;
	}

}