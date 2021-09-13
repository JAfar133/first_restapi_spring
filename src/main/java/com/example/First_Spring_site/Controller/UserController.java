package com.example.First_Spring_site.Controller;

import com.example.First_Spring_site.entity.UserEntity;
import com.example.First_Spring_site.exceptions.EmailAlreadyExistException;
import com.example.First_Spring_site.exceptions.EmailUnsatisfactory;
import com.example.First_Spring_site.exceptions.UserAlreadyExistException;
import com.example.First_Spring_site.exceptions.UserNotFoundException;
import com.example.First_Spring_site.repository.UserRepo;
import com.example.First_Spring_site.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user){
        try {
            userService.registration(user);
            return ResponseEntity.ok().body("user was saved");
        }catch(UserAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch(EmailUnsatisfactory e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch(EmailAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch(Exception e){
            return ResponseEntity.badRequest().body("->Error<-");
        }
    }
    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id){
        try {
            return ResponseEntity.ok().body(userService.getOne(id));
        } catch(UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch(Exception e){
            return ResponseEntity.badRequest().body("->Error<-");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        try {
            return ResponseEntity.ok(userService.delete(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("->Error<-");
        }
    }
}
