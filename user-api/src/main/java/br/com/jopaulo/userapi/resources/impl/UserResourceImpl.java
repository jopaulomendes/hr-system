package br.com.jopaulo.userapi.resources.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jopaulo.userapi.domain.User;
import br.com.jopaulo.userapi.resources.UserResources;
import br.com.jopaulo.userapi.services.UserService;

@RestController
@RequestMapping(value = "/api/users")
public class UserResourceImpl implements UserResources{
	
	@Autowired
	private UserService service;

	@Override
	public ResponseEntity<User> findById(Long id) {
		return ResponseEntity.ok().body(service.findById(id));
	}

	@Override
	public ResponseEntity<List<User>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}

}
