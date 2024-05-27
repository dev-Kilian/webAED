package com.KilianElRincon.webAED.repository;

import com.KilianElRincon.webAED.models.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Integer> {
}