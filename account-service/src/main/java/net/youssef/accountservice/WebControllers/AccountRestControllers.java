package net.youssef.accountservice.WebControllers;

import lombok.AllArgsConstructor;
import net.youssef.accountservice.Entities.BankAccount;
import net.youssef.accountservice.Repository.BankAccountRepository;
import net.youssef.accountservice.clients.CustomerRestClient;
import net.youssef.accountservice.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AccountRestControllers {
    private BankAccountRepository bankAccountRepository;
    private CustomerRestClient customerRestClient;

    @GetMapping("/accounts")
    public List<BankAccount> getAllBankAccounts() {
        return bankAccountRepository.findAll();
//        Customer customer;
//        for(BankAccount bankAccount:bankAccounts){
//            customer.
//        }
    }
    @GetMapping("/accounts/{id}")
    public BankAccount getBankAccountById(@PathVariable String id) {
        BankAccount bankAccount= bankAccountRepository.findById(id).get();
        Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }

}
