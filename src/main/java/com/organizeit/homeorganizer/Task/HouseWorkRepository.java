package com.organizeit.homeorganizer.Task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface HouseWorkRepository extends JpaRepository<HouseWork, UUID> {

}
