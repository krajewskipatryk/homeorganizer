package com.organizeit.homeorganizer.TaskType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
interface TaskTypeRepository extends JpaRepository<TaskType, UUID> {
}
