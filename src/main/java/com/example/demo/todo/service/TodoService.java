package com.example.demo.todo.service;


import com.example.demo.todo.dto.FindAllDTO;
import com.example.demo.todo.dto.TodoDto;
import com.example.demo.todo.entity.ToDo;
import com.example.demo.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// 역할: 컨트롤러와 저장소 사이의 잡일 처리 역할
@Service
@Slf4j
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository repository;

    /*
         - 할 일 목록조회 중간처리
         1. 컨트롤러에게 userId를 뺀 할일 리스트를 전달한다.
         2. 할일 목록의 카운트를 세서 따로 추가해서 전달한다.
     */
    public FindAllDTO findAllServ() {
        return new FindAllDTO(repository.findAll());
    }

}
