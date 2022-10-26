package com.organizeit.homeorganizer.Task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface TaskTypeRepository extends JpaRepository<TaskType, String> {
    Optional<TaskType> findById(String id);
}
