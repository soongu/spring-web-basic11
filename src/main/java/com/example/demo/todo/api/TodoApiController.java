package com.example.demo.todo.api;

import com.example.demo.todo.dto.FindAllDTO;
import com.example.demo.todo.entity.ToDo;
import com.example.demo.todo.repository.TodoRepository;
import com.example.demo.todo.repository.TodoRepositoryMemoryImpl;
import com.example.demo.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoApiController {

    private final TodoService service;

    // 할 일 목록 전체조회 요청
    @GetMapping
    public FindAllDTO todos() {
        log.info("/api/todos GET request!");
        return service.findAllServ();
    }

    // 할 일 목록 등록 요청
    @PostMapping
    public FindAllDTO create(@RequestBody ToDo newTodo) {

        newTodo.setUserId("noname");
        log.info("/api/todos POST request! - {}", newTodo);

        FindAllDTO dto = service.createServ(newTodo);

        return dto;
    }

}
