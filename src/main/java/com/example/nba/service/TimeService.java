package com.example.nba.service;

import com.example.nba.model.Time;
import com.example.nba.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeService {

    @Autowired
    private TimeRepository timeRepository;

    public List<Time> findAll() {
        return timeRepository.findAll();
    }

    public Time findById(Long id) {
        return timeRepository.findById(id).orElse(null);
    }

    public void save(Time time) {
        timeRepository.save(time);
    }

    public void delete(Long id) {
        timeRepository.deleteById(id);
    }
}
