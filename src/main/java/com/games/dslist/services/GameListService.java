package com.games.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.games.dslist.dto.GameListDTO;
import com.games.dslist.dto.GameMinDTO;
import com.games.dslist.entities.GameList;
import com.games.dslist.repositories.GameListRepository;

@Service
public class GameListService {

	@Autowired
	GameListRepository gameListRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(r -> new GameListDTO(r)).toList();
		
	}
}
