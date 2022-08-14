package com.africa.semicolon.passvault.dtos.requests;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountCreationRequest {
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private String phoneNumber;

}
