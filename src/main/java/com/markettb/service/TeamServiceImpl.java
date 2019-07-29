package com.markettb.service;

import com.markettb.dao.TeamDAO;
import com.markettb.model.Team;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TeamServiceImpl implements TeamService {
    private Logger log = Logger.getLogger(TeamServiceImpl.class);
    private TeamDAO teamDAO;

    @Autowired
    public void setTeamDAO(TeamDAO teamDAO){
        this.teamDAO = teamDAO;
    }

    @Override
    public void saveTeam(Team team) {
        if(team.getName()!= ""){
            team.setTotal(0);
            team.setEnable(true);
            this.teamDAO.saveTeam(team);
        }else
            log.info("===================== WARNING : Cannot SAVE team with name is Blank / spacebar ....  =================");
    }

    @Override
    public void updateTeam(Team team) {
        if(team.getName()!= "")
            this.teamDAO.updateTeam(team);
        else
            log.info("===================== WARNING: Cannot UPDATE a Team when teamName is Blank, Spacebar .... =================== ");
    }

    @Override
    public void deleteTeam(int id) {
        if(id > 0) {
            log.info("Delete an Team by id = " + id );
            this.teamDAO.deleteTeam(id);
        }
        else
            log.info("==================== WARNING : Cannot DELETE a Team with Incorrect Id ======================== ");
    }

    @Override
    public Team getTeamById(int id) {
        if(id != 0)
            return this.teamDAO.getTeamById(id);
        else
            return null;
    }

    @Override
    public List<Team> getAllTeams() {
        return this.teamDAO.getAllTeams();
    }

    @Override
    public List<Team> getAllTeamsOrderByParams(ArrayList<String> listParams, String option) {
        return this.teamDAO.getAllTeamsOrderByParams(listParams,option);
    }

    @Override
    public List<Team> getAllTeamsByTeamId(int team_id) {
        if(team_id > 0)
            return this.teamDAO.getAllTeamsByTeamId(team_id);
        else
            return null;
    }

    @Override
    public List<Team> getAllTeamsByActive() {
        return this.teamDAO.getAllTeamsByActive();
    }

    @Override
    public List<Team> getAllTeamsByTeamIdAndActive(int team_id, boolean enable) {
        return this.teamDAO.getAllTeamsByTeamIdAndActive(team_id,enable);
    }
}
