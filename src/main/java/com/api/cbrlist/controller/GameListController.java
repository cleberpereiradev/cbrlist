package com.api.cbrlist.controller;

import com.api.cbrlist.dto.GameListDTO;
import com.api.cbrlist.dto.GameMinDTO;
import com.api.cbrlist.service.GameListService;
import com.api.cbrlist.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService service;
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll() {
        return service.findAll();
    }

    @GetMapping
    @RequestMapping(value = "/{id}")
    public GameListDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        return gameService.findByList(listId);
    }
}
