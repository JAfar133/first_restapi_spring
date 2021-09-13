package com.example.First_Spring_site.repository;

import com.example.First_Spring_site.entity.TodoEntity;
import com.example.First_Spring_site.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<TodoEntity,Long> {
}
