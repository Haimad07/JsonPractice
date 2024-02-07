package com.jsonpractice.www;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class JsonPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsonPracticeApplication.class, args);
		
		String json = "{\"brand\":\"Hp\" ,\"model\":\"xyz\",\"serial\":\"\"}";
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			Laptop l = mapper.readValue(json,Laptop.class);
			System.out.println(l);
		}
		catch(JsonMappingException e) {
			e.printStackTrace();
		}
		catch(JsonProcessingException e) {
			e.printStackTrace();
		}
	}
		
	}
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	class Laptop{
			private String brand;
			private String model;
			
			@Override
			public String toString() {
				return "Laptop [brand=" + brand + ", model=" + model + "]";
				
			}
			public String getBrand() {
				return brand;
			}
			public void setBrand(String brand) {
				this.brand = brand;
			}
			public String getModel() {
				return model;
			}
			public void setModel(String model) {
				this.model = model;
			}
			
			
	}


