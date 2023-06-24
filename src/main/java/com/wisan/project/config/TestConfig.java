package com.wisan.project.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.wisan.project.entities.Category;
import com.wisan.project.entities.Order;
import com.wisan.project.entities.User;
import com.wisan.project.entities.enums.OrderStatus;
import com.wisan.project.repositories.CategoryRepository;
import com.wisan.project.repositories.OrderRepository;
import com.wisan.project.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers"); 
		categoryRepository.saveAll(Arrays.asList(cat1, cat2,cat3));
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.CANCELED, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.DELIVERED, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.PAID, u1);
		userRepository.saveAndFlush(u1);
		userRepository.saveAndFlush(u2);
		orderRepository.saveAndFlush(o1);
		orderRepository.saveAndFlush(o2);
		orderRepository.saveAndFlush(o3);
	}

}
