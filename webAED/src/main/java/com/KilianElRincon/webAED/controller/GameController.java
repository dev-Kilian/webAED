package com.KilianElRincon.webAED.controller;

import com.KilianElRincon.webAED.models.Game;
import com.KilianElRincon.webAED.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @GetMapping("/games")
    public String getAllGames(Model model) {
        model.addAttribute("games", gameRepository.findAll());
        return "game-list";
    }

    @GetMapping("/games/{id}")
    public String getGameById(@PathVariable("id") int id, Model model) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid game Id:" + id));
        model.addAttribute("game", game);
        return "game-detail";
    }

    @GetMapping("/game-create")
    public String showGameForm(Model model) {
        model.addAttribute("game", new Game());
        return "game-create";
    }

    @PostMapping("/game-create")
    public String createGame(@ModelAttribute Game game) {
        gameRepository.save(game);
        return "redirect:/games";
    }

    @GetMapping("/games/{id}/edit")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid game Id:" + id));
        model.addAttribute("game", game);
        return "game-list";
    }

    @PostMapping("/games/{id}/edit")
    public String updateGame(@PathVariable("id") int id, @ModelAttribute Game game) {
        game.setId(id);
        gameRepository.save(game);
        return "redirect:/games";
    }

    @GetMapping("/games/{id}/delete")
    public String deleteGame(@PathVariable("id") int id) {
        gameRepository.deleteById(id);
        return "redirect:/games";
    }
}
