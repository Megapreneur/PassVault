package com.africa.semicolon.passvault.services;

import com.africa.semicolon.passvault.dtos.requests.AccountCreationRequest;
import com.africa.semicolon.passvault.dtos.requests.DeleteUserRequest;
import com.africa.semicolon.passvault.dtos.requests.UpdateUserRequest;
import com.africa.semicolon.passvault.dtos.response.DeleteResponse;
import com.africa.semicolon.passvault.dtos.response.AccountCreationResponse;
import com.africa.semicolon.passvault.exceptions.InvalidDetailsException;
import com.africa.semicolon.passvault.exceptions.UserAlreadyExistException;
import com.africa.semicolon.passvault.models.data.User;
import com.africa.semicolon.passvault.models.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    ModelMapper modelMapper = new ModelMapper();


    @Override
    public AccountCreationResponse createAccount(AccountCreationRequest accountCreationRequest) {
        if (userRepository.existsUserByEmail(accountCreationRequest.getEmail())){
            throw new UserAlreadyExistException("User already exist");
        }
        User user = new User();
        if (isEmailValid(accountCreationRequest.getEmail())){
            if (isPasswordValid(accountCreationRequest.getPassword())){
                modelMapper.map(accountCreationRequest, user);
                userRepository.save(user);
            }
        }
        AccountCreationResponse accountCreationResponse = new AccountCreationResponse();
        modelMapper.map(user, accountCreationResponse);
        return accountCreationResponse;
    }

    private boolean isPasswordValid(String password) {
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        if (matcher.matches()){
            return true;
        }
        throw new InvalidDetailsException("""
                Invalid password. 
                A valid password must contain at least one Uppercase,
                one lowercase, one special character and length should
                be between 8 and 20 characters""");
    }

    private boolean isEmailValid(String email) {
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern =Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()){
            return true;
        }
        throw new InvalidDetailsException("Email not valid");
    }

    @Override
    public AccountCreationResponse updateUser(UpdateUserRequest updateUserRequest) {
        return null;
    }

    @Override
    public DeleteResponse deleteUser(DeleteUserRequest deleteUserRequest) {
        return null;
    }
}
