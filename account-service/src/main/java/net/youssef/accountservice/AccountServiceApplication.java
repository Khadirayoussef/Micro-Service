package net.youssef.accountservice;

import net.youssef.accountservice.Entities.BankAccount;
import net.youssef.accountservice.Repository.BankAccountRepository;
import net.youssef.accountservice.enums.AccountType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository) {
        return args -> {
            BankAccount bankAccount1 = BankAccount.builder()
                    .accountid(UUID.randomUUID().toString())
                    .balance(98000)
                    .Currency("MAD")
                    .createAt(LocalDate.now())
                    .type(AccountType.CURRENT_ACCOUNT)
                    .customerId(Long.valueOf(1))
                    .build();
            BankAccount bankAccount=BankAccount.builder()
                    .accountid(UUID.randomUUID().toString())
                    .balance(98000)
                    .Currency("MAD")
                    .createAt(LocalDate.now())
                    .type(AccountType.SAVING_ACCOUNT)
                    .customerId(Long.valueOf(2))
                    .build();
            bankAccountRepository.save(bankAccount);
            bankAccountRepository.save(bankAccount1);
        };
    }
}
