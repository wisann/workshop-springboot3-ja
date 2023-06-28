package com.wisan.project.resources;

import java.net.URI;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.wisan.project.dto.ProductDTO;
import com.wisan.project.entities.Category;
import com.wisan.project.entities.Product;
import com.wisan.project.services.CategoryService;
import com.wisan.project.services.OrderService;
import com.wisan.project.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private OrderService orderService;

	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = productService.findAll();
		return ResponseEntity.ok().body(list);
	};

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product obj = productService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Product> insertProduct(@RequestBody ProductDTO request) {
	    Product product = new Product();
	    product.setName(request.getName());
	    product.setDescription(request.getDescription());
	    product.setPrice(request.getPrice());
	    product.setImgUrl(request.getImgUrl());

	    Set<Category> categories = request.getCategoryIds().stream()
	            .map(categoryService::findById)
	            .collect(Collectors.toSet());

	    product.setCategories(categories);

	    // Call the service to insert the product
	    productService.insert(product);

	    // Build the response
	    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product.getId())
	            .toUri();
	    return ResponseEntity.created(uri).body(product);
	}

}