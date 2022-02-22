package br.com.jopaulo.userapi.services;

import java.util.List;

import br.com.jopaulo.userapi.domain.User;

public interface UserService {
	User findById(Long id);
	List<User> findAll();
}
