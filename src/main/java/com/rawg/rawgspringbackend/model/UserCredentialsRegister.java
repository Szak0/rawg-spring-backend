package com.rawg.rawgspringbackend.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCredentialsRegister {
    private String userName;
    private String password;
    private String email;
}
