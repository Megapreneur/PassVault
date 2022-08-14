package com.africa.semicolon.passvault.services;

import com.africa.semicolon.passvault.dtos.requests.AccountCreationRequest;
import com.africa.semicolon.passvault.dtos.requests.DeleteUserRequest;
import com.africa.semicolon.passvault.dtos.requests.UpdateUserRequest;
import com.africa.semicolon.passvault.dtos.response.DeleteResponse;
import com.africa.semicolon.passvault.dtos.response.AccountCreationResponse;

public interface UserService {
    AccountCreationResponse createAccount (AccountCreationRequest accountCreationRequest);
    AccountCreationResponse updateUser(UpdateUserRequest updateUserRequest);
    DeleteResponse deleteUser(DeleteUserRequest deleteUserRequest);
}
