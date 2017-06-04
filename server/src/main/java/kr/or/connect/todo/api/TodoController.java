package kr.or.connect.todo.api;

import java.util.*;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import kr.or.connect.todo.domain.*;
import kr.or.connect.todo.service.*;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
	private final TodoService service;
	private final Logger log = LoggerFactory.getLogger(TodoController.class);

	@Autowired
	public TodoController(TodoService service) {
		this.service = service;
	}
	
	@GetMapping
	Collection<Todo> readList() {
		return service.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	Todo create(@RequestBody Todo Todo) {
		Todo newTodo = service.create(Todo);
		log.info("Todo created : {}" , newTodo);
		return newTodo;
	}
	
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void update(@PathVariable Integer id, @RequestBody Todo Todo) {
		Todo.setId(id);
		service.update(Todo);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void deleteById(@PathVariable Integer id) {
		service.deleteById(id);
	}
	
	@DeleteMapping("/completed")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void deleteByCompleted() {
		service.deleteCompleted();
	}
}
