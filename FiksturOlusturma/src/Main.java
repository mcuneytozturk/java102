import model.Fixture;
import model.Team;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Fixture fixture = new Fixture();
        List<Team> teamList = new ArrayList<>();
        Team gs = new Team("Galatasaray", "GS");
        teamList.add(gs);
        Team bjk = new Team("Beşiktaş", "BJK");
        teamList.add(bjk);
        Team fb = new Team("Fenerbahçe", "FB");
        teamList.add(fb);
        Team ts = new Team("Trabszonspor", "TS");
        teamList.add(ts);
        Team fcb = new Team("FC Barcelona", "FCB");
        teamList.add(fcb);
        Team rm = new Team("Real Madrid", "RM");
        teamList.add(rm);
        Team fcam = new Team("Atletico Madrid", "FCAM");
        teamList.add(fcam);



        System.out.println(teamList.toString());

        fixture.createFixture(teamList);
    }
}