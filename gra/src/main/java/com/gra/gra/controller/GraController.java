package com.gra.gra.controller;

import com.gra.gra.parts.Game;
import com.gra.gra.parts.Gracz;
import com.gra.gra.repository.GraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GraController {

    Gracz gracz1 = new Gracz();
    Gracz gracz2 = new Gracz();
    int rundy=5;
    int aktualnaRunda=1;

    String winnerName;
    @Autowired
    private GraRepository graRepository;


    @GetMapping("/")
    String gra(Model model) {
        model.addAttribute("gracz1", gracz1);
        model.addAttribute("gracz2", gracz2);
        model.addAttribute("aktualnaRunda", aktualnaRunda);
        model.addAttribute("rundy", rundy);
        model.addAttribute("graczwin", "Wygrał " + winnerName);
        model.addAttribute("winnerName", winnerName);
        return "index";
    }

    @PostMapping("/start")
    public String start(@RequestParam("imie") String imie, Model model) {
        if (gracz1.getImie() == null) {
            gracz1.setImie(imie);
        } else if (gracz2.getImie() == null) {
            gracz2.setImie(imie);
        }
        if(gracz1.getScore() + gracz2.getScore() == 5 ){
            gracz1 = new Gracz();
            gracz2 = new Gracz();
        }

        model.addAttribute("gracz1", gracz1);
        model.addAttribute("gracz2", gracz2);
        model.addAttribute("aktualnaRunda", aktualnaRunda);
        model.addAttribute("rundy", rundy);
        model.addAttribute("graczwin", "Wygrał " + winnerName );
        model.addAttribute("winnerName", winnerName);
        return "index";
    }

    @PostMapping("/game/shoot")
    public String shoot(@RequestParam String player, @RequestParam int shotTime, Model model) {
        if(aktualnaRunda==1){
            winnerName=null;
        }
        if (aktualnaRunda < rundy) {
        if (player.equals("gracz1") && shotTime == 0) {
            gracz2.setScore(gracz2.getScore() + 1);
        } else if (player.equals("gracz1") && shotTime == 1) {
            gracz1.setScore(gracz1.getScore() + 1);
        } else if (player.equals("gracz2") && shotTime == 0) {
            gracz1.setScore(gracz1.getScore() + 1);
        } else if (player.equals("gracz2") && shotTime == 1) {
            gracz2.setScore(gracz2.getScore() + 1);
        }
        aktualnaRunda++;
        }
        else {
            if (player.equals("gracz1") && shotTime == 0) {
                gracz2.setScore(gracz2.getScore() + 1);
            } else if (player.equals("gracz1") && shotTime == 1) {
                gracz1.setScore(gracz1.getScore() + 1);
            } else if (player.equals("gracz2") && shotTime == 0) {
                gracz1.setScore(gracz1.getScore() + 1);
            } else if (player.equals("gracz2") && shotTime == 1) {
                gracz2.setScore(gracz2.getScore() + 1);
            }
            if (gracz1.getScore() > gracz2.getScore()) {
                winnerName = gracz1.getImie();
            } else {
                winnerName = gracz2.getImie();
            }

                Game game = new Game();
                game.setPlayer1Name(gracz1.getImie());
                game.setPlayer2Name(gracz2.getImie());
                game.setPlayer1Score(gracz1.getScore());
                game.setPlayer2Score(gracz2.getScore());
                graRepository.save(game);

            aktualnaRunda = 1;

            return "redirect:/";
        }
        model.addAttribute("graczwin", "Wygrał " + winnerName );
        model.addAttribute("gracz1", gracz1);
        model.addAttribute("gracz2", gracz2);
        model.addAttribute("aktualnaRunda", aktualnaRunda);
        model.addAttribute("rundy", rundy);
        model.addAttribute("winnerName", winnerName);
        return "index";
    }
}
