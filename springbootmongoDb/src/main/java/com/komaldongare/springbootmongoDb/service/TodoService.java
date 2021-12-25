package com.komaldongare.springbootmongoDb.service;

import java.util.List;

import javax.validation.ConstraintViolationException;

import com.komaldongare.springbootmongoDb.exception.TodoCollectionException;
import com.komaldongare.springbootmongoDb.model.TodoDTO;

public interface TodoService {

	public void createTodo(TodoDTO todo) throws TodoCollectionException, ConstraintViolationException;
	public List<TodoDTO> getAllTodos();
	public TodoDTO getSingleTodo(String id) throws TodoCollectionException;
	public void updateTodo(String id, TodoDTO todo) throws TodoCollectionException;
	public void deleteTodoById(String id) throws TodoCollectionException;
	
}
