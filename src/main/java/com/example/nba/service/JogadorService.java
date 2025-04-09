package com.example.nba.service;

import com.example.nba.model.Jogador;
import com.example.nba.model.Time;
import com.example.nba.repository.JogadorRepository;
import com.example.nba.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;

    @Autowired
    private TimeRepository timeRepository;

    public List<Jogador> findAll() {
        return jogadorRepository.findAll();
    }

    public Jogador findById(Long id) {
        return jogadorRepository.findById(id).orElse(null);
    }

    public void save(Jogador jogador) {
        jogadorRepository.save(jogador);
    }

    public void delete(Long id) {
        jogadorRepository.deleteById(id);
    }


    public List<Time> findAllTimes() {
        return timeRepository.findAll();
    }
}
