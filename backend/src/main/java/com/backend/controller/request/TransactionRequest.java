package com.backend.controller.request;

import lombok.Data;

@Data
public class TransactionRequest {

    private Long transactionId;

    private String sourceAccountNumber;

    private String targetAccountNumber;

    private String targetOwnerName;

    private String accountType;

    private Double amount;
}
