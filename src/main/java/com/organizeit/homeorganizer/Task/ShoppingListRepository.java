package com.organizeit.homeorganizer.Task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface ShoppingListRepository extends JpaRepository<ShoppingList, UUID> {
}
