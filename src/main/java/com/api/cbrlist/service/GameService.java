package com.api.cbrlist.service;

import com.api.cbrlist.dto.GameDTO;
import com.api.cbrlist.dto.GameListDTO;
import com.api.cbrlist.dto.GameMinDTO;
import com.api.cbrlist.entities.Game;
import com.api.cbrlist.projection.GameMinProjection;
import com.api.cbrlist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository repo;
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> games = repo.findAll();
        return games.stream().map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = repo.findById(id).get();
        return new GameDTO(result);
    }

        @Transactional(readOnly = true)
        public List<GameMinDTO> findByList(Long listId) {
            List<GameMinProjection> gamesByList = repo.searchByList(listId);
            return gamesByList.stream().map(GameMinDTO::new).toList();
        }


}
