package br.com.jopaulo.userapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import br.com.jopaulo.userapi.domain.User;
import br.com.jopaulo.userapi.repository.UserRepository;

@SpringBootApplication
@EnableEurekaClient
public class UserApiApplication implements CommandLineRunner {

	@Autowired
	private UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(UserApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.saveAll(List.of(
				new User(null, "João Paulo", "jp_cbc@hotmail.com", "1234", 50.0),
				new User(null, "Adnari Mendes", "adnari@gmail.com", "1234", 50.5),
				new User(null, "Bruna Suellen", "bruna@hotmail.com", "1234", 60.0),
				new User(null, "Sofia Maila", "sofia@hotmail.com", "1234", 70.8),
				new User(null, "Max Albuquerque", "max@hotmail.com", "1234", 10.5)
		));
	}

}
