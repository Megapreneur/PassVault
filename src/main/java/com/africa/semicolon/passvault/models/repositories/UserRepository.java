package com.africa.semicolon.passvault.models.repositories;

import com.africa.semicolon.passvault.dtos.requests.AccountCreationRequest;
import org.apache.catalina.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String>{


    boolean existsUserByEmail(String email);
}
