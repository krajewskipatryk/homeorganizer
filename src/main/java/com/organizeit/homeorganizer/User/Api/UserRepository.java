package com.organizeit.homeorganizer.User.Api;

import com.organizeit.homeorganizer.User.Api.Model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface UserRepository extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findById(String id);
}