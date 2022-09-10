package com.organizeit.homeorganizer.User.Api;

import com.organizeit.homeorganizer.User.Api.Exception.UserNotFoundException;
import com.organizeit.homeorganizer.User.Api.Model.UserEntity;
import com.organizeit.homeorganizer.User.Api.Model.UserRequestData;
import com.organizeit.homeorganizer.User.Api.Model.UserResponse;
import com.organizeit.homeorganizer.Utils.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse createUser(UserRequestData userData) {
        UserEntity user = userMapper.userDataToEntity(userData);
        user.setId(IdGenerator.generateId());
        return userMapper.userEntityToResponse(userRepository.save(user));
    }

    @Override
    public UserResponse getUser(String id) {
        return userMapper.userEntityToResponse(this.getUserEntity(id));
    }

    @Override
    public UserResponse updateUser(UserEntity user) {
        return userMapper.userEntityToResponse(userRepository.save(user));
    }

    @Override
    public UserResponse updateUser(String id, UserRequestData userData) {
        UserEntity user = this.getUserEntity(id);
        user = userMapper.userDataToEntity(userData);
        return userMapper.userEntityToResponse(userRepository.save(user));
    }

    @Override
    public UserEntity getUserEntity(String id) {
        return userRepository.findById(id).orElseThrow(() -> {
            throw new UserNotFoundException();
        });
    }
}
