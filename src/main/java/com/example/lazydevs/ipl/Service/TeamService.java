package com.example.lazydevs.ipl.Service;

import java.util.List;

import com.example.lazydevs.ipl.Repository.TeamRepository;
import com.example.lazydevs.ipl.modal.Team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;
    
    public List<Team> findAll(){
        return teamRepository.findAll();
    }
    public boolean save(Team team) {
        teamRepository.save(team);
        return true;
    }
     
    public Team get(int id) {
        return teamRepository.findById(id).isPresent()? 
        teamRepository.findById(id).get(): null;
    }
     
    public boolean delete(int id) {
        teamRepository.deleteById(id);
        return true;
    }
}
