package com.organizeit.homeorganizer.User.Api.Model;

import lombok.Data;

@Data
public class UserResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
}
