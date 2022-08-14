package com.africa.semicolon.passvault.models.repositories;

import org.apache.catalina.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long>{

}
