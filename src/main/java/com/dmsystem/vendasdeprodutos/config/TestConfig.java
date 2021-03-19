package com.dmsystem.vendasdeprodutos.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.dmsystem.vendasdeprodutos.entities.User;
import com.dmsystem.vendasdeprodutos.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {


		User u1 = new User(null, "Marcia Demuner", "marcia@gmail.com", "98888888888", "123456");

		User u2 = new User(null, "Alex Green", "alex@gmail.com", "777777752", "654321");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
	}
	
}
