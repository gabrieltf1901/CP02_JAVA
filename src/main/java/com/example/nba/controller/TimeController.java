package com.example.nba.controller;

import com.example.nba.model.Time;
import com.example.nba.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/times")
public class TimeController {

    @Autowired
    private TimeService timeService;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("times", timeService.findAll());
        return "times/listar";
    }

    @GetMapping("/cadastrar")
    public String exibirFormulario(Model model) {
        model.addAttribute("time", new Time());
        return "times/form";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("time") Time time,
                         BindingResult result) {
        if (result.hasErrors()) {
            return "times/form";
        }
        timeService.save(time);
        return "redirect:/times/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Time time = timeService.findById(id);
        model.addAttribute("time", time);
        return "times/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        timeService.delete(id);
        return "redirect:/times/listar";
    }
}
