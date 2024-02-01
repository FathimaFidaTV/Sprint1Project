package com.example.BookYourGroceryHere.Service;

import java.util.List;
import java.util.Optional;

import com.example.BookYourGroceryHere.Model.Grocery;

public interface GroceryService {
    List<Grocery> findAllGroceries();

    Optional<Grocery> findGroceryById(Long id);

    void saveGrocery(Grocery grocery);

    void updateGrocery(Long id, Grocery updatedGrocery);

    void deleteGrocery(Long id);
    
    List<Grocery> findGroceriesByStore(Long storeId);
}
