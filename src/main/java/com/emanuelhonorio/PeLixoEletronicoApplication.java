package com.emanuelhonorio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class PeLixoEletronicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeLixoEletronicoApplication.class, args);
	}
	
	@GetMapping("/")
	public ResponseEntity<String> pingServer() {
		return ResponseEntity.ok("Server is running...");
	}

}
