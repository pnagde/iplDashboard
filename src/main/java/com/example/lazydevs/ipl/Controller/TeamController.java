package com.example.lazydevs.ipl.Controller;

import java.util.List;

import com.example.lazydevs.ipl.Repository.TeamRepository;
import com.example.lazydevs.ipl.Service.TeamService;
import com.example.lazydevs.ipl.modal.Team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping(path  = "/")
public class TeamController 
{

    @Autowired(required = true)
    private TeamRepository repository;

    @Autowired
    private TeamService service;

    @RequestMapping( path =  "/")
    public ModelAndView index(){
        ModelAndView modelAndView=new ModelAndView("index");
        List<Team> team=(List<Team>)repository.findAll();
        modelAndView.addObject("teams", team);
        return modelAndView;
    }
    @RequestMapping( path =  "/upload")
    public ModelAndView upload(){
        ModelAndView modelAndView=new ModelAndView("upload");
        return modelAndView;
    }

    @GetMapping(path = "/api/teams")
    public @ResponseBody Iterable<Team> teams(){
        return repository.findAll();
    }

    @RequestMapping( path =  "/add")
    public ModelAndView add(){
        ModelAndView modelAndView=new ModelAndView("add");
        List<Team> team=(List<Team>)repository.findAll();
        modelAndView.addObject("teams", team);
        return modelAndView;
    }

    @RequestMapping(path = "/" ,method = RequestMethod.POST)
    public ModelAndView search(@Param ("keyword") String keyword){
        ModelAndView modelAndView=new ModelAndView("index");
        List<Team> teams = service.ListAll(keyword);
        modelAndView.addObject("teams", teams);
        modelAndView.addObject("keyword", keyword);
        return modelAndView;
    }

    @RequestMapping(path = "/save")
    public ModelAndView save(Team team) {
        ModelAndView modelAndView=new ModelAndView("redirect:/add");
        boolean saved=false;
        if(team!=null){
        modelAndView=new ModelAndView("redirect:/edit/"+team.getTeamId());
        saved=service.save(team);
        modelAndView.addObject("saved", saved);
        }
        return modelAndView;
    }
    
    @RequestMapping(path = "/edit/{id}")
    public ModelAndView edit(@PathVariable(name = "id") Integer id ) {
        ModelAndView modelAndView=new ModelAndView("edit");
        if(id>0){
            Team team=service.get(id);
            modelAndView.addObject("team",team);
        }
        return modelAndView;
    }

    @RequestMapping(path = "/delete/{id}")
    public ModelAndView delete(@PathVariable(name = "id") Integer id) {
        ModelAndView modelAndView=new ModelAndView("redirect:/add");
        service.delete(id);
        return modelAndView;
    }

    @RequestMapping(path = "/addteams" ,method = RequestMethod.GET)
    public ModelAndView requestMethodName(Team team) {
        ModelAndView modelAndView=new ModelAndView("redirect:/add");
        if(team!=null){
            if(team.getTeamName()!=null){
                repository.save(team);
            }
            return modelAndView;
        }
        return modelAndView;
    }
}
