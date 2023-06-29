package com.wisan.project.dto;

import java.util.List;

import com.wisan.project.entities.User;

public class OrderDTO {
    private Long productId;
    private Integer quantity;
    private Double price;
    private List<Long> productIds;
    private ProductDTO productDTO;
    private User client;

    public OrderDTO() {
        
    }

	public OrderDTO(Long productId, Integer quantity, Double price, List<Long> productIds, ProductDTO productDTO, User client) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
		this.productIds = productIds;
		this.productDTO = productDTO;
		this.client = client;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public List<Long> getProductIds() {
		return productIds;
	}

	public void setProductIds(List<Long> productIds) {
		this.productIds = productIds;
	}

	public ProductDTO getProductDTO() {
		return productDTO;
	}

	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}
	
	
    
    

}