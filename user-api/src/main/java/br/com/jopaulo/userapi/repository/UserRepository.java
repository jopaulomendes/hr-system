package br.com.jopaulo.userapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jopaulo.userapi.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
