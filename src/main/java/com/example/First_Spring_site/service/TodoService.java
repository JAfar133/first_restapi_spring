package com.example.First_Spring_site.service;

import com.example.First_Spring_site.entity.TodoEntity;
import com.example.First_Spring_site.entity.UserEntity;
import com.example.First_Spring_site.model.Todo;
import com.example.First_Spring_site.repository.TodoRepo;
import com.example.First_Spring_site.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todoRepo;
    @Autowired
    private UserRepo userRepo;

    public Todo createTodo(TodoEntity todo, Long userId){
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        return Todo.toModel(todoRepo.save(todo));
    }
    public Todo completeTodo(Long id){
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted(!todo.getCompleted());
        return Todo.toModel(todoRepo.save(todo));
    }
}
