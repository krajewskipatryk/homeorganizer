package com.organizeit.homeorganizer.Task;

import com.organizeit.homeorganizer.Group.Group;
import com.organizeit.homeorganizer.Product.Product;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@RequiredArgsConstructor
class ShoppingListService {
    private final ShoppingListRepository shoppingListRepository;
    public ShoppingList createShoppingList(Group group) {
        ShoppingList shoppingList = new ShoppingList(UUID.randomUUID(), group, new HashSet<>(), new HashSet<>());

        return shoppingListRepository.save(shoppingList);
    }

    public Set<Product> getProductsList(UUID id) {
        return this.getShoppingListEntity(id).getProducts();
    }

    public Set<TaskHistory> getShoppingListHistory(UUID id) {
        return this.getShoppingListEntity(id).getTaskHistory();
    }

    public void updateShoppingListStatus(ShoppingList shoppingList) {
        shoppingListRepository.save(shoppingList);
    }

    public ShoppingList getShoppingListEntity(UUID id) {
        return this.shoppingListRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("ni ma");
        });
    }
}
