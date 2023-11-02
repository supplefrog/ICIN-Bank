package com.backend.controller.request;

import lombok.Data;

@Data
public class UserRequest {

    private String username;
    private String password;
    private String email;
    private String roleName;

}