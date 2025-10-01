package com.practice.springboot.todowebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int todosCount = 0;
    static {
        todos.add(new Todo(++todosCount, "bozdemir", "Java Spring Boot", LocalDate.now().plusMonths(1), true));
        todos.add(new Todo(++todosCount, "bozdemir", "Fullstack Development", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "bozdemir", "AWS", LocalDate.now().plusMonths(1), false));
    }

    public List<Todo> findByUsername(String username) {
        return todos.stream().filter(pred -> pred.getUsername().equalsIgnoreCase(username)).toList();
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
        todos.add(new Todo(++todosCount, username, description, targetDate, done));
    }

    public void deleteById(int id) {
        todos.removeIf(todo -> todo.getId() == id);
    }

    public Todo findById(int id) {
        Todo todo = todos.stream().filter(pred -> pred.getId() == id).findFirst().get();
        return todo;
    }

    public void updateTodo(Todo updateTodo) {
        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).getId() == updateTodo.getId()) {
                todos.set(i, updateTodo);
                return;
            }
        }
    }
}
