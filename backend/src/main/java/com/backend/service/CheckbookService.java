package com.backend.service;

import com.backend.entity.Account;
import com.backend.entity.Checkbook;
import com.backend.entity.Status;
import com.backend.repository.AccountRepository;
import com.backend.repository.CheckbookRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

@Service
public class CheckbookService {

    private final CheckbookRepository checkbookRepository;
    private final AccountRepository accountRepository;

    public CheckbookService(CheckbookRepository checkbookRepository, AccountRepository accountRepository) {
        this.checkbookRepository = checkbookRepository;
        this.accountRepository = accountRepository;
    }

    public List<Checkbook> getAllCheckbookRequests(){
        return checkbookRepository.findAll();
    }

    public Checkbook approveStatus(Long checkId) {
        Checkbook checkbook = checkbookRepository.findById(checkId)
                .orElseThrow(() -> new IllegalArgumentException("Ticket not found with ID: " + checkId));

        checkbook.setStatus(Status.APPROVED);

        return checkbookRepository.save(checkbook);
    }

    public Checkbook denyStatus(Long checkId) {
        Checkbook checkbook = checkbookRepository.findById(checkId)
                .orElseThrow(() -> new IllegalArgumentException("Ticket not found with ID: " + checkId));

        checkbook.setStatus(Status.DENIED);

        return checkbookRepository.save(checkbook);
    }

    public Checkbook createCheckbookRequest() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        var accountOptional = accountRepository.findAccountsByUserUsername(username)
                .stream().filter(c -> "CHECKING".equals(c.getAccountType()))
                .findFirst();

        if(accountOptional.isEmpty() || accountOptional.get().getAccountNumber() == null) {
            throw new IllegalArgumentException("Account ID is required");
        }

        Account account = accountRepository.findById(accountOptional.get().getId())
                .orElseThrow(() -> new EntityNotFoundException("Account not found with ID: " + accountOptional.get().getId()));

        if (!Objects.equals(account.getAccountType(), "CHECKING")) {
            throw new IllegalArgumentException("Account type must be CHECKING");
        }

        Checkbook checkbook = new Checkbook();
        checkbook.setStatus(Status.OPEN);
        checkbook.setAccount(account);

        return checkbookRepository.save(checkbook);
    }

}
