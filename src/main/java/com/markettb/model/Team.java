package com.markettb.model;


import javax.persistence.*;




@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "team_id")
    private Integer teamId;

    @Column(name = "total")
    private Integer total;

    @Column(name = "enable")
    private boolean enable;

    // Implement Contructor
    public Team() { this.id = 0 ;    }

    public Team(String name, Integer teamId, Integer total, boolean enable) {
        this.name = name;
        this.teamId = teamId;
        this.total = total;
        this.enable = enable;
    }

    // Generate Getter & Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teamId=" + teamId +
                ", total=" + total +
                ", enable=" + enable +
                '}';
    }
}
