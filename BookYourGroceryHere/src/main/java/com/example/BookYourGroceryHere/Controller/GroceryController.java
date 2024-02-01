package com.example.BookYourGroceryHere.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.BookYourGroceryHere.Model.Grocery;
import com.example.BookYourGroceryHere.Service.GroceryService;
import com.example.BookYourGroceryHere.Service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/grocery")
public class GroceryController {

    private final UserService userService;
    private final GroceryService groceryService;

    @Autowired
    public GroceryController(UserService userService, GroceryService groceryService) {
        this.userService = userService;
        this.groceryService = groceryService;
    }

   
    @PostMapping("/addGrocery")
    public String addGrocery(@RequestBody Grocery grocery) {
        groceryService.saveGrocery(grocery);
        return "Grocery added successfully!";
    }

    @PutMapping("/updateGrocery/{groceryId}")
    public String updateGrocery(@PathVariable Long groceryId, @RequestBody Grocery updatedGrocery) {
        Optional<Grocery> existingGrocery = groceryService.findGroceryById(groceryId);
        if (existingGrocery.isPresent()) {
            groceryService.updateGrocery(groceryId, updatedGrocery);
            return "Grocery updated successfully!";
        } else {
            return "Grocery not found!";
        }
    }

    @GetMapping("/groceries")
    public List<Grocery> getAllGroceries() {
        return groceryService.findAllGroceries();
    }

    @DeleteMapping("/deleteGrocery/{groceryId}")
    public String deleteGrocery(@PathVariable Long groceryId) {
        Optional<Grocery> grocery = groceryService.findGroceryById(groceryId);
        if (grocery.isPresent()) {
            groceryService.deleteGrocery(groceryId);
            return "Grocery deleted successfully!";
        } else {
            return "Grocery not found!";
        }
    }
}


