package com.example.BookYourGroceryHere.Service;



import java.util.List;
import java.util.Optional;

import com.example.BookYourGroceryHere.Model.User;

public interface UserService {
 Optional<User> findByUsername(String username);

 List<User> findAllUsers();

 void save(User user);

 void delete(Long userId);
 
 Optional<User> findByUserId(Long userId);
}
