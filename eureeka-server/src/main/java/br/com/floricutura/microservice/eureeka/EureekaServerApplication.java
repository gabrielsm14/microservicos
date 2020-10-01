package br.com.floricutura.microservice.eureeka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EureekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EureekaServerApplication.class, args);
	}

}
