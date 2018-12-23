package com.openclassrooms.shop.domain;

public class Product {

	private Long id;
	private String name, description, details;
	private int stock;
	private double price;

	public Product() {
		super();
	}
	
	public Product(Long id, int quantity, double price, String name, String description) {
		setId(id);
		setStock(quantity);
		setPrice(price);
		setName(name);
		setDescription(description);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int quantity) {
		if (quantity < 0) {
			quantity = 0;
		}
		this.stock = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price < 0) {
			price = 0;
		} else if (price > 1000) {
			price = 1000;
		}
		this.price = price;
	}

	public double getInventoryPrice() {
		return getStock() * getPrice();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
