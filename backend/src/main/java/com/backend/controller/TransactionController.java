package com.backend.controller;

import com.backend.controller.request.TransactionRequest;
import com.backend.entity.Transaction;
import com.backend.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/user/transaction")
    public ResponseEntity<?> makeTransfer(@RequestBody TransactionRequest transactionRequest) {
            transactionService.makeTransfer(transactionRequest);
            return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/admin/transaction")
    public List<Transaction> getTransactions(){
        return transactionService.getAllTransactions();
    }

}
