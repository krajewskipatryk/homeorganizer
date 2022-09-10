package com.organizeit.homeorganizer.User.Api.Model;

import lombok.Data;

@Data
public class UserRequestData {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
