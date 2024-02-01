package com.example.BookYourGroceryHere.ServiceImpl;



import com.example.BookYourGroceryHere.Model.User;
import com.example.BookYourGroceryHere.Repository.UserRepository;
import com.example.BookYourGroceryHere.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

 private final UserRepository userRepository;

 @Autowired
 public UserServiceImpl(UserRepository userRepository) {
     this.userRepository = userRepository;
 }

 @Override
 public Optional<User> findByUsername(String username) {
     return userRepository.findByUsername(username);
 }

 @Override
 public List<User> findAllUsers() {
     return userRepository.findAll();
 }

 @Override
 public void save(User user) {
     userRepository.save(user);
 }

 @Override
 public void delete(Long userId) {
     userRepository.deleteById(userId);
 }

@Override
public Optional<User> findByUserId(Long userId) {
	// TODO Auto-generated method stub
	return Optional.empty();
}
}

