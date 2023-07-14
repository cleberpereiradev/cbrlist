package com.api.cbrlist.service;

import com.api.cbrlist.dto.GameListDTO;
import com.api.cbrlist.entities.GameList;
import com.api.cbrlist.projection.GameMinProjection;
import com.api.cbrlist.repository.GameListRepository;
import com.api.cbrlist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository repository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> gameLists = repository.findAll();
        return gameLists.stream().map(GameListDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public GameListDTO findById(Long id) {
        GameList gameList = repository.findById(id).get();
        return new GameListDTO(gameList);
    }
    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {

        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max; i++) {
            repository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }

}
