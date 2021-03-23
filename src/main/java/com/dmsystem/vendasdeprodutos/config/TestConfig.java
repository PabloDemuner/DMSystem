package com.dmsystem.vendasdeprodutos.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.dmsystem.vendasdeprodutos.entities.Category;
import com.dmsystem.vendasdeprodutos.entities.Order;
import com.dmsystem.vendasdeprodutos.entities.User;
import com.dmsystem.vendasdeprodutos.entities.enums.OrderStatus;
import com.dmsystem.vendasdeprodutos.repositories.CategoryRepository;
import com.dmsystem.vendasdeprodutos.repositories.OrderRepository;
import com.dmsystem.vendasdeprodutos.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics"); 
		Category cat2 = new Category(null, "Books"); 
		Category cat3 = new Category(null, "Computers"); 

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

		User u1 = new User(null, "Marcia Demuner", "marcia@gmail.com", "98888888888", "123456");

		User u2 = new User(null, "Alex Green", "alex@gmail.com", "777777752", "654321");
		
		Order o1 = new Order(null, Instant.parse("2021-03-20T04:12:25Z"), u1, OrderStatus.PAID); 
		Order o2 = new Order(null, Instant.parse("2021-03-20T04:12:25Z"), u2, OrderStatus.WAITING_PAYMENT); 
		Order o3 = new Order(null, Instant.parse("2021-03-20T04:12:25Z"), u1, OrderStatus.WAITING_PAYMENT); 
		
		
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
	
}
