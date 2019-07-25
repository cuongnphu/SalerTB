package com.markettb.repository;


import com.markettb.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team,Integer> {

    Team findById(int id);
    List<Team> findByTeamId(int team_id);
    List<Team> findByEnable(boolean enable);
}
