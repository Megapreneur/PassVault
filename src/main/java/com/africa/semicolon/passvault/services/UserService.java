package com.africa.semicolon.passvault.services;

import com.africa.semicolon.passvault.dtos.requests.AccountCreationRequest;
import com.africa.semicolon.passvault.dtos.response.UserResponse;

public interface UserService {
    UserResponse createAccount (AccountCreationRequest accountCreationRequest);
}
