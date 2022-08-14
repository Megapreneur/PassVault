package com.africa.semicolon.passvault.models.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Validated
@Document
@Table(name = "Users")
public class User {
    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String firstName;
    private String lastName;
    @Column(nullable = false, unique = true)
    private String userName;
    @Email
    private String email;
    private String masterPassword;
    private String phoneNumber;
    @DBRef
    private Set<Url> urls = new HashSet<>();

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", masterPassword='" + masterPassword + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", urls=" + urls +
                '}';
    }
}
