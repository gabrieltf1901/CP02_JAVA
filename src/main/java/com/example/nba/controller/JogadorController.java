package com.example.nba.controller;

import com.example.nba.model.Jogador;
import com.example.nba.service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/jogadores")
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("jogadores", jogadorService.findAll());
        return "jogadores/listar";
    }

    @GetMapping("/cadastrar")
    public String exibirFormulario(Model model) {
        model.addAttribute("jogador", new Jogador());
        model.addAttribute("times", jogadorService.findAllTimes());
        return "jogadores/form";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("jogador") Jogador jogador,
                         BindingResult result,
                         Model model) {
        if (result.hasErrors()) {
            model.addAttribute("times", jogadorService.findAllTimes());
            return "jogadores/form";
        }
        jogadorService.save(jogador);
        return "redirect:/jogadores/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Jogador jogador = jogadorService.findById(id);
        model.addAttribute("jogador", jogador);
        model.addAttribute("times", jogadorService.findAllTimes());
        return "jogadores/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        jogadorService.delete(id);
        return "redirect:/jogadores/listar";
    }
}
