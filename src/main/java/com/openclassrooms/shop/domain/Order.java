package com.openclassrooms.shop.domain;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;


public class Order {
	
	private Long id;
	
	private LocalDate date = LocalDate.now();

	private List<CartLine> lines;

	@NotBlank
	private String name;

	@NotBlank
	private String address;

	@NotBlank
	private String city;

	private String zip;

	@NotBlank
	private String country;

	public List<CartLine> getLines() {
		return lines;
	}

	public void setLines(List<CartLine> lines) {
		this.lines = lines;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
}
