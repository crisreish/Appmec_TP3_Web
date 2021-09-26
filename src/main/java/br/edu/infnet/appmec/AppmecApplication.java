package br.edu.infnet.appmec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppmecApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppmecApplication.class, args);
	}

}
