package com.markettb.controller;


import com.markettb.model.Team;
import com.markettb.service.TeamService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
public class TeamController {

    private Logger log = Logger.getLogger(TeamController.class);
    private TeamService teamService;

    @Autowired
    public void setTeamService(TeamService teamService) {
        this.teamService = teamService;
    }

    /* GET Team Home page*/
    @RequestMapping(value = "/teams", method = RequestMethod.GET)
    public ModelAndView listTeams(@ModelAttribute("modelteam") Team team) {
        // Initialize a ModelAndView
        ModelAndView model = new ModelAndView("view/team");

        // Initialize params for sort by Column
        ArrayList<String> params = new ArrayList<>();
        params.add("teamId");

        // Get all Teams
        List<Team> listTeamForm = this.teamService.getAllTeamsOrderByParams(params, "ASC");

        // Add modelAttribute of spring-form in ModelView
        model.addObject("listTeamForm", listTeamForm);

        return model;
    }

    /*POST a new Team*/
    @RequestMapping(value = "/team",method=RequestMethod.POST)
    public ModelAndView saveTeam (@ModelAttribute("modelteam") Team team) {
        if(this.teamService.getTeamById(team.getId()) != null) {
            log.info("Update a Team by teamId = "+ team.getId());
            this.teamService.updateTeam(team);
        }else {
            log.info("Create a new Team !!!");
            this.teamService.saveTeam(team);
        }

        return new ModelAndView("redirect:/teams");
    }

    /*POST for checking teamName is exist*/
    @RequestMapping(value = "/checkteam", method = RequestMethod.POST)
    public @ResponseBody boolean checkTeamName(String nameCheck, int teamIdCheck) {
        // Get all Teams
        List<Team> listTeams = this.teamService.getAllTeams();
        for(int i = 0; i < listTeams.size();i++)
            if(nameCheck.trim().equalsIgnoreCase(listTeams.get(i).getName().trim()) )
                return false;

        return true;
    }

    /*GET editing page for Team by Id*/
    @RequestMapping(value = "/editteam/{id}",method = RequestMethod.GET)
    public ModelAndView editTeam (@ModelAttribute("modelteam") Team team , @PathVariable("id") int id) {
        // Initilaize a new Model
        ModelAndView model = new ModelAndView("edit/edit_team");

        // Get Team by Id
        Team teamer = this.teamService.getTeamById(id);

        // Initialize params for sort by Column
        ArrayList<String> params = new ArrayList<>();
        params.add("teamId");

        // Get all Teams
        List<Team> listTeamForm = this.teamService.getAllTeamsOrderByParams(params,"ASC");

        // Add modelAttribute of spring-form in ModelView
        model.addObject("modelteam",teamer);
        model.addObject("listTeamForm", listTeamForm);

        return model;
    }

    /*UPDATE a particular team*/
    @RequestMapping(value = "/updateteam",method = RequestMethod.POST)
    public ModelAndView updateTeam(@ModelAttribute("modelTeam") Team team){
        if(this.teamService.getTeamById(team.getId()) != null){
            log.info("Update a Team by id = " + team.getId());
            this.teamService.updateTeam(team);
        }else {
            log.info("Create a new Team !!!");
            this.teamService.saveTeam(team);
        }

        return new ModelAndView("redirect:/teams");
    }

    /*DELETE a Team */
    @RequestMapping(value = "/deleteteam/{id}")
    public ModelAndView deleteTeam(@PathVariable("id") int id){
        // Get Team by Id
        Team teamer = this.teamService.getTeamById(id);

        /*Only DELETE team when it is stop*/
        if(teamer.isEnable() == false)
            this.teamService.deleteTeam(id);
        else
            log.info(" ==================== Action DELETE Team is not correctly !!!!  ============================== " + "\n" );

        return new ModelAndView("redirect:/teams");
    }

    /*POST for getting list active Team*/
    @RequestMapping(value = "/listactiveteam",method = RequestMethod.POST)
    public @ResponseBody List<Team> getListActiveTeams(){
        /*Get All teams with status enable by True*/
        List<Team> teamList = this.teamService.getAllTeamsByActive();
        return teamList;
    }


}
