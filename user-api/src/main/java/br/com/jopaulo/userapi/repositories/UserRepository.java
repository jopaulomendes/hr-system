package br.com.jopaulo.userapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jopaulo.userapi.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
