package com.komaldongare.springbootmongoDb.model;


import java.util.Date;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {

	@Id
	private String id;
	
	@NotNull(message = "todo cannot be null")
	private String todo;
	public TodoDTO(String id, String todo, String description, Boolean completed, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.todo = todo;
		this.description = description;
		this.completed = completed;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	@Override
	public int hashCode() {
		return Objects.hash(completed, createdAt, description, id, todo, updatedAt);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TodoDTO other = (TodoDTO) obj;
		return Objects.equals(completed, other.completed) && Objects.equals(createdAt, other.createdAt)
				&& Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(todo, other.todo) && Objects.equals(updatedAt, other.updatedAt);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTodo() {
		return todo;
	}
	public void setTodo(String todo) {
		this.todo = todo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getCompleted() {
		return completed;
	}
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	@NotNull(message = "Description cannot be null")
	private String description;

	@NotNull(message = "Decription cannot be null")
	private Boolean completed;
	
	private Date createdAt;
	private Date updatedAt;
	public void setCreatedAt(Date date) {
		this.createdAt = date;
		
	}
	
	
	
}
