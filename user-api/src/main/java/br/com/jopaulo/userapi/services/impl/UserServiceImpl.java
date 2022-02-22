package br.com.jopaulo.userapi.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jopaulo.userapi.domain.User;
import br.com.jopaulo.userapi.repository.UserRepository;
import br.com.jopaulo.userapi.services.UserService;
import br.com.jopaulo.userapi.services.exceptions.ObjectNotFoundException;

//@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repository;

	@Override
	public User findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
	}

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}
}
