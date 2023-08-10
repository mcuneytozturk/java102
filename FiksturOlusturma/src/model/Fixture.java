package model;

import java.util.ArrayList;
import java.util.List;

public class Fixture {
    public void createFixture(List<Team> teams){
            Team byTeam = new Team("Bay", "by");
        if(teams.size() % 2 == 0){
            teams.add(new Team("Bay", "by"));
        } else {

        }


        int weakNum = (teams.size() - 1) * 2;

        for ( int weak = 0; weak < weakNum; weak++){
            System.out.println(weak + ". hafta maçları");

            ArrayList<Team> homeTeams = new ArrayList<>(teams.subList(0, teams.size() / 2));
            ArrayList<Team> awayTeams = new ArrayList<>(teams.subList(teams.size() / 2, teams.size()));

            for (int i = 0; i < homeTeams.size(); i++) {
                Team homeTeam = homeTeams.get(i);
                Team awayTeam = awayTeams.get(i);

                if (!homeTeam.equals(byTeam) && !awayTeam.equals(byTeam)) {
                    System.out.println(homeTeam.getShortName() + " (Ev Sahibi) - " + awayTeam.getShortName() + " (Deplasman)");
                }
            }

            rotateTeams(teams);
            System.out.println("======================");
        }
        }
     public static void rotateTeams(List<Team> teams) {
        Team lastTeam = teams.remove(teams.size() - 1);
        teams.add(1, lastTeam);
    }
}
