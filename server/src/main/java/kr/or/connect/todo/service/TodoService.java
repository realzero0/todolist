package kr.or.connect.todo.service;

import java.util.*;

import org.springframework.stereotype.*;

import kr.or.connect.todo.domain.*;
import kr.or.connect.todo.persistence.*;

@Service
public class TodoService {
	private TodoDao dao;

	public TodoService(TodoDao dao) {
		this.dao = dao;
	}

	public Collection<Todo> findAll() {
		return dao.selectAll();
	}

	public Todo create(Todo todo) {
		Integer id = dao.insert(todo);
		todo.setId(id);
		return todo;
	}

	public boolean update(Todo todo) {
		int affected = dao.update(todo);
		return affected == 1;
	}

	public boolean deleteById(Integer id) {
		int affected = dao.deleteById(id);
		return affected == 1;
	}

	public boolean deleteCompleted() {
		int affected = dao.deleteByCompleted(1);
		return affected >= 1;
	}
}
