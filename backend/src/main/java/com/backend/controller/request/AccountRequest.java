package com.backend.controller.request;

import lombok.Data;

@Data
public class AccountRequest {

    private Long userId;
    private String accountNumber;
    private Long balance;
    private String accountType;
}
