package com.KilianElRincon.webAED.repository;

import com.KilianElRincon.webAED.models.Tournament;
import org.springframework.data.repository.CrudRepository;

public interface TournamentRepository extends CrudRepository<Tournament, Integer> {
}