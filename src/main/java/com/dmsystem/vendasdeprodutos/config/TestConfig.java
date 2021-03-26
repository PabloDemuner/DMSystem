package com.dmsystem.vendasdeprodutos.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.dmsystem.vendasdeprodutos.entities.Category;
import com.dmsystem.vendasdeprodutos.entities.Order;
import com.dmsystem.vendasdeprodutos.entities.OrderItem;
import com.dmsystem.vendasdeprodutos.entities.Payment;
import com.dmsystem.vendasdeprodutos.entities.Product;
import com.dmsystem.vendasdeprodutos.entities.User;
import com.dmsystem.vendasdeprodutos.entities.enums.OrderStatus;
import com.dmsystem.vendasdeprodutos.repositories.CategoryRepository;
import com.dmsystem.vendasdeprodutos.repositories.OrderItemRepository;
import com.dmsystem.vendasdeprodutos.repositories.OrderRepository;
import com.dmsystem.vendasdeprodutos.repositories.ProductRepository;
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
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		//TESTES DO JPA COM H2
		
		Category cat1 = new Category(null, "Electronics"); 
		Category cat2 = new Category(null, "Books"); 
		Category cat3 = new Category(null, "Computers"); 
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		

		User u1 = new User(null, "Marcia Demuner", "marcia@gmail.com", "98888888888", "123456");

		User u2 = new User(null, "Alex Green", "alex@gmail.com", "777777752", "654321");
		
		Order o1 = new Order(null, Instant.parse("2021-03-20T04:12:25Z"), u1, OrderStatus.PAID); 
		Order o2 = new Order(null, Instant.parse("2021-03-20T04:12:25Z"), u2, OrderStatus.WAITING_PAYMENT); 
		Order o3 = new Order(null, Instant.parse("2021-03-20T04:12:25Z"), u1, OrderStatus.WAITING_PAYMENT); 
		
		
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice()); 
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice()); 
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice()); 
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice()); 
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		Payment pay1 = new Payment(null, Instant.parse("2021-03-25T22:12:25Z"), o1);
		o1.setPayment(pay1);
		
		orderRepository.save(o1);
	}
	
}
