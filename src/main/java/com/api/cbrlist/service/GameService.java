package com.api.cbrlist.service;

import com.api.cbrlist.dto.GameMinDTO;
import com.api.cbrlist.entities.Game;
import com.api.cbrlist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository repo;

    public List<GameMinDTO> findAll() {
        List<Game> games = repo.findAll();
        return games.stream().map(GameMinDTO::new).toList();
    }
}
