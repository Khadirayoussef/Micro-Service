package net.youssef.customerservice.WebController;

import lombok.AllArgsConstructor;
import net.youssef.customerservice.Entities.Customer;
import net.youssef.customerservice.Repositories.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CustomerRestController {
    private CustomerRepository customerRepository;
    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable long id) {
        return customerRepository.findById(id).get();
    }

}
