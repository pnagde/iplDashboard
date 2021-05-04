package com.example.lazydevs.ipl.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "iplTeams")
public class Team {
    
    @Id
    @Column(name = "teamID")
    private int teamId;
    @Column(name = "teamName")
    private String teamName;
    @Column(name = "totalMatches")
    private int totalMatch;
    @Column(name = "teamWins")
    private int teamWin;
    @Column(name = "teamLosses")
    private int teamLoss;
    @Column(name = "teamNRR")
    private double nrr;
    @Column(name = "teamPoints")
    private int points;

    public Team(int teamId, String teamName, int totalMatch, int teamWin, int teamLoss, double nrr, int points) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.totalMatch = totalMatch;
        this.teamWin = teamWin;
        this.teamLoss = teamLoss;
        this.nrr = nrr;
        this.points = points;
    }
    public Team() {
    }
    public int getTeamId() {
        return teamId;
    }
    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }
    public String getTeamName() {
        return teamName;
    }
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    public int getTotalMatch() {
        return totalMatch;
    }
    public void setTotalMatch(int totalMatch) {
        this.totalMatch = totalMatch;
    }
    public int getTeamWin() {
        return teamWin;
    }
    public void setTeamWin(int teamWin) {
        this.teamWin = teamWin;
    }
    public int getTeamLoss() {
        return teamLoss;
    }
    public void setTeamLoss(int teamLoss) {
        this.teamLoss = teamLoss;
    }
    public double getNrr() {
        return nrr;
    }
    public void setNrr(double nrr) {
        this.nrr = nrr;
    }
    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    @Override
    public String toString() {
        return "Team [nrr=" + nrr + ", points=" + points + ", teamId=" + teamId + ", teamLoss=" + teamLoss
                + ", teamName=" + teamName + ", teamWin=" + teamWin + ", totalMatch=" + totalMatch + "]";
    }
}
