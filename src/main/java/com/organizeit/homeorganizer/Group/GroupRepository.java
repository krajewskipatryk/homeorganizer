package com.organizeit.homeorganizer.Group;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
interface GroupRepository extends JpaRepository<Group, UUID> {
    Optional<Group> findById(UUID id);
}
