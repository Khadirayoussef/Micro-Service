package net.youssef.customerservice.Repositories;

import net.youssef.customerservice.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
