package com.organizeit.homeorganizer.User;

import com.organizeit.homeorganizer.User.Api.Model.UserRequestData;
import com.organizeit.homeorganizer.User.Api.Model.UserResponse;
import com.organizeit.homeorganizer.User.Api.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
class UserController {
    private final UserService userService;

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse createUser(@RequestBody UserRequestData userData) {
        return userService.createUser(userData);
    }

    @GetMapping(path = "/get/{id}")
    public UserResponse getUser(@PathVariable String id) {
        return userService.getUser(id);
    }

    @PutMapping(path = "update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse updateUserInfo(@PathVariable String id, @RequestBody UserRequestData userData) {
        return userService.updateUser(id, userData);
    }
}
