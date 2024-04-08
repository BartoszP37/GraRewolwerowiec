package com.gra.gra.controller;

import com.gra.gra.parts.Gracz;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GraController {

    Gracz gracz1 = new Gracz();
    Gracz gracz2 = new Gracz();

    @GetMapping("/")
    String gra(Model model) {
        model.addAttribute("gracz1", gracz1);
        model.addAttribute("gracz2", gracz2);
        return "index";
    }

    @PostMapping("/start")
    public String start(@RequestParam("imie") String imie, Model model) {
        if (gracz1.getImie() == null) {
            gracz1.setImie(imie);
        } else if (gracz2.getImie() == null) {
            gracz2.setImie(imie);
        }
        model.addAttribute("gracz1", gracz1);
        model.addAttribute("gracz2", gracz2);
        return "index";
    }
}
