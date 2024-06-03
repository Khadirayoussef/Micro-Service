package net.youssef.accountservice;

import net.youssef.accountservice.Entities.BankAccount;
import net.youssef.accountservice.Repository.BankAccountRepository;
import net.youssef.accountservice.clients.CustomerRestClient;
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
    CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository,CustomerRestClient customerRestClient) {
        return args -> {
            customerRestClient.AllCustomers().forEach(c -> {
                        BankAccount bankAccount1 = BankAccount.builder()
                                .accountid(UUID.randomUUID().toString())
                                .balance(Math.random() * 6590)
                                .Currency("MAD")
                                .createAt(LocalDate.now())
                                .type(AccountType.CURRENT_ACCOUNT)
                                .customerId(c.getId())
                                .build();

                        BankAccount bankAccount = BankAccount.builder()
                                .accountid(UUID.randomUUID().toString())
                                .balance(Math.random() * 7580)
                                .Currency("MAD")
                                .createAt(LocalDate.now())
                                .type(AccountType.SAVING_ACCOUNT)
                                .customerId(c.getId())
                                .build();
                bankAccountRepository.save(bankAccount);
                bankAccountRepository.save(bankAccount1);
                    }
            );



        };
    }
}
