package br.com.jopaulo.userapi.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.jopaulo.userapi.domain.User;

public interface UserResource {

	@GetMapping(value = "/{id}")
	ResponseEntity<User> findById(@PathVariable Long id);
	
	ResponseEntity<List<User>> findAll();
}
