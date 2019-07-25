package com.markettb.dao;

import com.markettb.model.Team;
import com.markettb.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TeamDAOImpl implements TeamDAO {

    private TeamRepository teamRepository;

    /* SPRING will instance and injet it when initialize class*/
    @Autowired
    public void setTeamRepository(TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }

    /* SAVE a team*/
    @Override
    public void saveTeam(Team team) {
        this.teamRepository.save(team);
    }

    /* UPDATE a particular team */
    @Override
    public void updateTeam(Team team) {
        Team temp = teamRepository.getOne(team.getId());
        temp.setName(team.getName());
        temp.setTeamId(team.getTeamId());
        temp.setTotal(team.getTotal());
        temp.setEnable(team.isEnable());
        teamRepository.save(temp);
    }

    /* DELETE a team by Id*/
    @Override
    public void deleteTeam(int id) {
        this.teamRepository.deleteById(id);
    }

    /* GET a team by Id*/
    @Override
    public Team getTeamById(int id) {
        return this.teamRepository.findById(id);
    }

    /* GET all teams */
    @Override
    public List<Team> getAllTeams() {
        return this.teamRepository.findAll();
    }

    /* GET all team by params*/
    @Override
    public List<Team> getAllTeamsOrderByParams(ArrayList<String> listParams, String option) {
        return this.teamRepository.findAll(new Sort(Sort.Direction.ASC,listParams.get(0).toString()));
    }

    /* GET all teams by teamId*/
    @Override
    public List<Team> getAllTeamsByTeamId(int team_id) {
        return this.teamRepository.findByTeamId(team_id);
    }

    /* GET all team by active*/
    @Override
    public List<Team> getAllTeamsByActive() {
        return this.teamRepository.findByEnable(true);
    }

    @Override
    public List<Team> getAllTeamsByTeamIdAndActive(int team_id, boolean enable) {
        return this.teamRepository.findByTeamIdAndEnable(team_id,enable);
    }
}
