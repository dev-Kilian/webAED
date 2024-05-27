package com.KilianElRincon.webAED.controller;

import com.KilianElRincon.webAED.models.Tournament;
import com.KilianElRincon.webAED.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TournamentController {

    @Autowired
    private TournamentRepository tournamentRepository;

    @GetMapping("/tournaments")
    public String getAllTournaments(Model model) {
        model.addAttribute("tournaments", tournamentRepository.findAll());
        return "tournament-list";
    }

    @GetMapping("/tournaments/{id}")
    public String getTournamentById(@PathVariable("id") int id, Model model) {
        Tournament tournament = tournamentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid tournament Id:" + id));
        model.addAttribute("tournament", tournament);
        return "tournament-detail";
    }

    @PostMapping("/tournaments")
    public String createTournament(@ModelAttribute Tournament tournament) {
        tournamentRepository.save(tournament);
        return "redirect:/tournaments";
    }

    @PutMapping("/tournaments/{id}")
    public String updateTournament(@PathVariable("id") int id, @ModelAttribute Tournament tournament) {
        tournament.setId(id);
        tournamentRepository.save(tournament);
        return "redirect:/tournaments";
    }

    @DeleteMapping("/tournaments/{id}")
    public String deleteTournament(@PathVariable("id") int id) {
        tournamentRepository.deleteById(id);
        return "redirect:/tournament";
    }
}
