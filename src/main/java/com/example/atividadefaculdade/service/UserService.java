package com.example.atividadefaculdade.service;

import com.example.atividadefaculdade.entities.User;
import com.example.atividadefaculdade.repositories.UserRepository;
import com.example.atividadefaculdade.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public void insert(User user) {
        userRepository.save(user);
    }

    public void delete(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException();
        }
    }

    public void update(User user) {
        try {
            userRepository.save(user);
        } catch (Exception e) {
            throw new ResourceNotFoundException();
        }
    }
}
