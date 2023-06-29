package com.wisan.project.resources;

import java.net.URI;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.wisan.project.dto.OrderDTO;
import com.wisan.project.entities.Order;
import com.wisan.project.entities.OrderItem;
import com.wisan.project.entities.Payment;
import com.wisan.project.entities.Product;
import com.wisan.project.entities.User;
import com.wisan.project.entities.enums.OrderStatus;
import com.wisan.project.services.OrderService;
import com.wisan.project.services.ProductService;
import com.wisan.project.services.UserService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

	@Autowired
	private OrderService orderService;

	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> list = orderService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Order obj = orderService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping()
	public ResponseEntity<Order> createOrderWithProduct(@RequestBody OrderDTO orderDTO) {
	    Order order = new Order();
	    Long clientId = orderDTO.getClient().getId();
	    
	    if (clientId == null) {
	        return ResponseEntity.notFound().build();
	    }
	    
	    User client = userService.findById(clientId);
	    if (client == null) {
	        return ResponseEntity.notFound().build();
	    }

	    order.setClient(client);
	    order.setMoment(Instant.now());
	    order.setOrderStatusA(OrderStatus.WAITING_PAYMENT); // defina o status do pedido conforme necessário

	    Product product = productService.findById(orderDTO.getProductId());
	    if (product == null) {
	        return ResponseEntity.notFound().build();
	    }
	    OrderItem orderItem = new OrderItem();
	    orderItem.setProduct(product);
	    orderItem.setQuantity(orderDTO.getQuantity());
	    orderItem.setPrice(product.getPrice());

	    order.getItems().add(orderItem);

	    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(order.getId())
	            .toUri();
	    return ResponseEntity.created(uri).body(order);
	}

}
