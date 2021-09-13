package com.example.First_Spring_site.service;

import com.example.First_Spring_site.entity.UserEntity;
import com.example.First_Spring_site.exceptions.EmailAlreadyExistException;
import com.example.First_Spring_site.exceptions.EmailUnsatisfactory;
import com.example.First_Spring_site.exceptions.UserAlreadyExistException;
import com.example.First_Spring_site.exceptions.UserNotFoundException;
import com.example.First_Spring_site.model.User;
import com.example.First_Spring_site.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public UserEntity registration(UserEntity user) throws UserAlreadyExistException, EmailAlreadyExistException, EmailUnsatisfactory {
        try{
        String strEmail = user.getEmail().substring((user.getEmail().length()-8));
        String strGmail = user.getEmail().substring((user.getEmail().length()-10));
        if(!(strEmail.equals("@mail.ru")
                    ||strGmail.equals("@gmail.com"))){
                throw new EmailUnsatisfactory("this email is incorrect");
            }}
        catch (IndexOutOfBoundsException e){
            throw new EmailUnsatisfactory("this email is incorrect");
        }
            if(userRepo.findByUsername(user.getUsername())!=null){
                throw new UserAlreadyExistException("user with this name already exist");
            }
            else if(userRepo.findByEmail(user.getEmail())!=null){
                throw new EmailAlreadyExistException("This email already registered");
            }
            return userRepo.save(user);
    }
    public User getOne(Long id) throws UserNotFoundException {
        try{
            return User.toModel(userRepo.findById(id).get());}
        catch (Exception e){
            throw new UserNotFoundException("User was not found");
        }
    }
    public Long delete(Long id){
        userRepo.deleteById(id);
        return id;
    }
}
