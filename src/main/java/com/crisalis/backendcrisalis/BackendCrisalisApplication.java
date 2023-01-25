package com.crisalis.backendcrisalis;

import javax.validation.constraints.Null;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.crisalis.backendcrisalis.models.OrderDetail;
import com.crisalis.backendcrisalis.models.Productos;
import com.crisalis.backendcrisalis.repository.OrderDetailRepository;
import com.crisalis.backendcrisalis.repository.ProductosRepository;



@SpringBootApplication
public class BackendCrisalisApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendCrisalisApplication.class, args);
	}


	/*
	@Bean
	CommandLineRunner commandLineRunner(
		OrderDetailRepository orderDetailRepository,
		ProductosRepository productosRepository
	){
		return args -> {
			Productos productos = productosRepository.save(
				new Productos (
				null,
				4.1,
				"celular",	
				false,
				false,
				false
				)
			);
			OrderDetail orderDetail = orderDetailRepository.save(new OrderDetail(null, ))
		}
	}
	*/

}
