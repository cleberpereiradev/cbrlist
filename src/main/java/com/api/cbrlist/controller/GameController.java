package com.api.cbrlist.controller;

import com.api.cbrlist.dto.GameMinDTO;
import com.api.cbrlist.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {
    @Autowired
    private GameService service;


    @GetMapping
    public List<GameMinDTO> findAll() {
        List<GameMinDTO> games = service.findAll();
        return games;
    }
}
