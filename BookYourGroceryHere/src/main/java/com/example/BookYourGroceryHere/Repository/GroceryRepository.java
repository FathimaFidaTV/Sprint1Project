package com.example.BookYourGroceryHere.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookYourGroceryHere.Model.Grocery;

public interface GroceryRepository extends JpaRepository<Grocery, Long> {
	
}
