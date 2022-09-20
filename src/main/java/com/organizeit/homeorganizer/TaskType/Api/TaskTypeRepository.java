package com.organizeit.homeorganizer.TaskType.Api;

import com.organizeit.homeorganizer.TaskType.Api.Model.TaskTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface TaskTypeRepository extends JpaRepository<TaskTypeEntity, String> {
    Optional<TaskTypeEntity> findById(String id);
}
