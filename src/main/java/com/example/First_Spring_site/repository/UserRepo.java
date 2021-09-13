package com.example.First_Spring_site.repository;

import com.example.First_Spring_site.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;



public interface UserRepo extends CrudRepository<UserEntity,Long>{
    UserEntity findByUsername(String username);
    UserEntity findByEmail(String email);

}
