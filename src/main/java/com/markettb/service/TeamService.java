package com.markettb.service;

import java.util.ArrayList;
import java.util.List;
import com.markettb.model.Team;



public interface TeamService {

    public void saveTeam(Team team);

    public void updateTeam(Team team);

    public void deleteTeam(int id);

    public Team getTeamById(int id);

    public List<Team> getAllTeams();

    public List<Team> getAllTeamsOrderByParams(ArrayList<String> listParams, String option);

    public List<Team> getAllTeamsByTeamId(int team_id);

    public List<Team> getAllTeamsByActive();
}
