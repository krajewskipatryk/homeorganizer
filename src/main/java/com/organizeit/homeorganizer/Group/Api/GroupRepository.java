package com.organizeit.homeorganizer.Group.Api;

import com.organizeit.homeorganizer.Group.Api.Model.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface GroupRepository extends JpaRepository<GroupEntity, String> {
    Optional<GroupEntity> findById(String id);
}
