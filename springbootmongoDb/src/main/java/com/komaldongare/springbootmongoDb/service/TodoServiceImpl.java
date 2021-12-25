package com.komaldongare.springbootmongoDb.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.komaldongare.springbootmongoDb.exception.TodoCollectionException;
import com.komaldongare.springbootmongoDb.model.TodoDTO;
import com.komaldongare.springbootmongoDb.repository.TodoRepository;


@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoRepository todoRepo;
	
	public void createTodo(TodoDTO todo) throws TodoCollectionException, ConstraintViolationException{
		Optional<TodoDTO> todoOptional = todoRepo.findByTodo(todo.getTodo());
		if(todoOptional.isPresent()) {
			
			throw new TodoCollectionException(TodoCollectionException.TodoAlreadyExists());
			
		}else {
			todo.setCreatedAt(new Date(System.currentTimeMillis()));
			todoRepo.save(todo);
		}
		
	}
	
	
	public List<TodoDTO> getAllTodos(){
		
		List<TodoDTO> todos = todoRepo.findAll();
		if(todos.size()>0) {
			return todos;
		}
		else {
			return new ArrayList<TodoDTO>();
		}
		
	}
	
	public TodoDTO getSingleTodo(String id) throws TodoCollectionException{
		Optional<TodoDTO> optionalTodo = todoRepo.findById(id);
		if(!optionalTodo.isPresent()) {
			throw new TodoCollectionException(TodoCollectionException.NotFoundException(id));
		}
		else {
			return optionalTodo.get();
		}
		
	}
	
	
	public void updateTodo(String id, TodoDTO todo) throws TodoCollectionException
	{		
		Optional<TodoDTO> todoWithId = todoRepo.findById(id);
		Optional<TodoDTO> todoWithSameName = todoRepo.findByTodo(todo.getTodo());
		
		if(todoWithId.isPresent()) {
		
			if(todoWithSameName.isPresent() && !todoWithSameName.get().getId().equals(id)) {
				
				throw new TodoCollectionException(TodoCollectionException.TodoAlreadyExists());
				
			}
			
			TodoDTO updateTodo = todoWithId.get();
			updateTodo.setCompleted(todo.getCompleted());
			updateTodo.setDescription(todo.getDescription());
			updateTodo.setTodo(todo.getTodo());
			updateTodo.setUpdatedAt(new Date(System.currentTimeMillis()));
			todoRepo.save(updateTodo);
		}
	}
	
		
	public void deleteTodoById(String id) throws TodoCollectionException{
		Optional<TodoDTO> todoOptional = todoRepo.findById(id);
		if(!todoOptional.isPresent()) {
			throw new TodoCollectionException(TodoCollectionException.NotFoundException(id));
		}else {
			todoRepo.deleteById(id);
		}
	}
	
	
	
}
