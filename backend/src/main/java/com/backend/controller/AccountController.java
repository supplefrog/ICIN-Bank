package com.backend.controller;

import com.backend.controller.request.AccountRequest;
import com.backend.entity.Account;
import com.backend.entity.Status;
import com.backend.service.AccountService;
import com.backend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {

    private final AccountService accountService;
    private final UserService userService;

    public AccountController(AccountService accountService, UserService userService) {
        this.accountService = accountService;
        this.userService = userService;
    }

    @GetMapping("/admin/accounts")
    public List<Account> getAll() {
        return accountService.getAllAccounts();
    }

    @PutMapping(value = "/admin/account")
    public ResponseEntity<?> createAccount(@RequestBody AccountRequest accountRequest) {

        Account account = new Account();
        account.setAccountType(accountRequest.getAccountType());
        account.setUser(userService.findUser(accountRequest.getUserId()));
        account.setStatus(Status.OPEN);
        account.setBalance(0.0);
        accountService.createAccount(account);

        return new ResponseEntity<>("Account created successfully", HttpStatus.OK);
    }

    @GetMapping("admin/account/{id}")
    public Account getAccount(@PathVariable Long id) {
        return accountService.getAccount(id).orElseThrow(() -> new RuntimeException("Account not found"));
    }

    @PostMapping("/user/account/deposit")
    public Account deposit(@RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        return accountService.deposit(amount);
    }

    @PostMapping("/user/account/withdraw")
    public Account withdraw(@RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        return accountService.withdraw(amount);
    }

    @GetMapping("/user/account/balance")
    public Double getCheckingBalance() {
        return accountService.getCheckingBalance();
    }

}
