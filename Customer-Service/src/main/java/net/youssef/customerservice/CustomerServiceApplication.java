package net.youssef.customerservice;

import net.youssef.customerservice.Entities.Customer;
import net.youssef.customerservice.Repositories.CustomerRepository;
import net.youssef.customerservice.config.GlobalConfig;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
		return args -> {
			List<Customer> Customerlist= List.of(
				Customer.builder()
						.id(1)
						.firstName("John")
						.lastName("Doe")
						.email("john@doe.com")
						.build(),
				Customer.builder()
						.id(2)
						.firstName("Jane")
						.lastName("Doe")
						.email("jane@doe.com")
						.build()
			);
			customerRepository.saveAll(Customerlist);
		};
	}
}
