
package com.example.BookYourGroceryHere.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookYourGroceryHere.Model.Grocery;
import com.example.BookYourGroceryHere.Repository.GroceryRepository;
import com.example.BookYourGroceryHere.Service.GroceryService;

import java.util.List;
import java.util.Optional;

@Service
public class GroceryServiceImpl implements GroceryService {

    private final GroceryRepository groceryRepository;

    @Autowired
    public GroceryServiceImpl(GroceryRepository groceryRepository) {
        this.groceryRepository = groceryRepository;
    }

    @Override
    public List<Grocery> findAllGroceries() {
        return groceryRepository.findAll();
    }

    @Override
    public Optional<Grocery> findGroceryById(Long id) {
        return groceryRepository.findById(id);
    }

    @Override
    public void saveGrocery(Grocery grocery) {
        groceryRepository.save(grocery);
    }

    @Override
    public void updateGrocery(Long id, Grocery updatedGrocery) {
        Optional<Grocery> existingGrocery = groceryRepository.findById(id);
        if (existingGrocery.isPresent()) {
            updatedGrocery.setId(id);
            groceryRepository.save(updatedGrocery);
        } else {
            throw new IllegalArgumentException("Grocery with id " + id + " not found");
        }
    }

    @Override
    public void deleteGrocery(Long id) {
        groceryRepository.deleteById(id);
    }

	@Override
	public List<Grocery> findGroceriesByStore(Long storeId) {
		// TODO Auto-generated method stub
		return null;
	}
}

