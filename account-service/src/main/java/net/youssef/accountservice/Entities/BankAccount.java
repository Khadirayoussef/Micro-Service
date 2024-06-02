package net.youssef.accountservice.Entities;

import jakarta.persistence.*;
import lombok.*;
import net.youssef.accountservice.enums.AccountType;
import net.youssef.accountservice.model.Customer;

import java.time.LocalDate;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccount {
    @Id
    private String accountid;
    private double balance;
    private LocalDate createAt;
    private String Currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient
    private Customer customer;
    private Long customerId;
}
