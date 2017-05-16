/**
 * Created by johnkrawulski on 4/26/17.
 */
public class BaseballMain2 {

    public static void main(String[] args) {

        BaseballUtility2 utils = new BaseballUtility2();

        BaseballGame2 teams = new BaseballGame2();

        //Team names and roster, printing of both
        utils.setTeamAName("Braves");
        utils.setTeamBName("White Sox");
        utils.printTeamOverview();
        utils.printRosterAVis();
        utils.printRosterBHome();


        //Start 9 inning game
        int inning;
        for (inning = 0; inning < 9; inning++) {
            teams.generateGame();
        }
        //Print inning stats
        System.out.println("End of No Extra Inning Game, "+ inning +" Innings");
        utils.printFormat();
        System.out.println(utils.getTeamAName()+" "+teams.runsVisTotal);
        System.out.println(utils.getTeamBName()+" "+teams.runsHomeTotal);

        //print team winner for 9 inning game
        if (teams.runsHomeTotal > teams.runsVisTotal) {
            System.out.println(utils.getTeamBName() + " Win!");
        }
        else if (teams.runsVisTotal > teams.runsHomeTotal)
        System.out.println(utils.getTeamAName() + " Win!");
        else
            System.out.println("Extra Innings");

        //Extra innings if game is tied
        while (teams.runsVisTotal==teams.runsHomeTotal) {
            inning = inning + 1;
            teams.generateGame();
            //printing extra inning stats
            System.out.println("Extra Inning Game, " + inning + " Innings");
            utils.printFormat();
            System.out.println(utils.getTeamAName() + " " + teams.runsVisTotal);
            System.out.println(utils.getTeamBName() + " " + teams.runsHomeTotal);

            //print team winner for extra inning game
            if (teams.runsHomeTotal > teams.runsVisTotal) {
                System.out.println(utils.getTeamBName() + " Win!");
            }
            else if (teams.runsVisTotal > teams.runsHomeTotal)
                System.out.println(utils.getTeamAName() + " Win!");
        }

    }


}
