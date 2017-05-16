import java.util.Objects;

/**
 * Created by johnkrawulski on 4/26/17.
 */
public class BaseballUtility2 {

    int atBat = 0;
    String batType = null;
    int number;
    int homeBatCounter=0;
    int visitBatCounter=0;
    private String teamAName;
    private String teamBName;
    String[] rosterA = {"Doug1", "Aaron2", "Dean3", "Evan4", "Allen5", "Danny6", "Jim7", "Jeff8", "Richard9"};
    String[] rosterB = {"Frank1", "Miquel2", "Juan3", "Chris4", "Pete5", "Mike6", "Eric7", "Andrew8", "Clint9"};
    static int[] bases = {0,0,0};
    int runsVis=0;
    int runsHome=0;


    public String getTeamAName() {
        return teamAName;
    }

    public void setTeamAName(String teamAName) {
        this.teamAName = teamAName;
    }

    public String getTeamBName() {
        return teamBName;
    }

    public void setTeamBName(String team2Name) {
        this.teamBName = team2Name;
    }


    // Generation of random number to determine batting result
    public int randomNumber() {
        number = (int) ((Math.random() * 100) + 1);
        return number;
    }

    // Printing of Team Names
    public void printTeamOverview() {

        System.out.println(teamAName + " vs " + teamBName);
        System.out.println("**************************************");

    }

    //Printing of Rosters
    public void printRosterAVis() {
        System.out.println(teamAName+" Roster");
        System.out.println("**************************************");
        for (int i = 0; i < rosterA.length; i++)
            System.out.println(rosterA[i]);
        System.out.println("**************************************");

    }

    public void printRosterBHome() {
        System.out.println(teamBName+" Roster");
        System.out.println("**************************************");
        for (int i = 0; i < rosterB.length; i++)
            System.out.println(rosterB[i]);
        System.out.println("**************************************");

    }

    public void printFormat(){
        System.out.println("**************************************");
    }

    //code to advance base runners based on type of hit
    public int evalBases(String bat, char team) {

        //commented out code to use for debugging evaulation of bases with hits
        //for(int t=0; t<bases.length;t++)
        //System.out.println(bases[t]);

        if (Objects.equals(bat, "Single")) {

            if (bases[2] == 1) {
                if (team == 'h') {
                    runsHome = runsHome + 1;
                }
                else
                    runsVis = runsVis+1;

                bases[2] = 0;
            }
            if (bases[1] == 1) {
                bases[1] = 0;
                bases[2] = 1;

            }
            if (bases[0] == 1) {
                bases[1] = 1;
            }
                bases[0]=1;

        }

        if (Objects.equals(bat, "Double")) {
            if (bases[2] == 1) {
                if (team == 'h') {
                    runsHome = runsHome + 1;
                }else
                    runsVis = runsVis+1;
                bases[2] = 0;
            }
            if (bases[1] == 1) {
                if (team == 'h') {
                    runsHome = runsHome + 1;
                }
                else
                    runsVis = runsVis+1;

            }
            if (bases[0] == 1) {
                bases[2] = 1;
                bases[1] = 1;
                bases[0] = 0;
            }
                bases[1]=1;
        }

        if (Objects.equals(bat, "Triple")) {
            if (bases[2] == 1) {
                if (team == 'h') {
                    runsHome = runsHome + 1;
                }
                else
                    runsVis = runsVis+1;
                bases[2] = 1;
            }
            if (bases[1] == 1) {
                if (team == 'h') {
                    runsHome = runsHome + 1;
                }
                else
                    runsVis = runsVis+1;
                bases[1] = 0;

            }
            if (bases[0] == 1) {
                if (team == 'h') {
                    runsHome = runsHome + 1;
                }
                else
                    runsVis = runsVis+1;
                bases[0] = 0;
            }
                bases[2]=1;
        }

        if (Objects.equals(bat, "Home Run")) {
            if (bases[2] == 1) {
                if (team == 'h') {
                    runsHome = runsHome + 1;
                }
                else
                    runsVis = runsVis+1;
                bases[2] = 0;
            }
            if (bases[1] == 1) {
                if (team == 'h') {
                    runsHome = runsHome + 1;
                }
                else
                    runsVis = runsVis+1;
                bases[1] = 0;

            }
            if (bases[0] == 1) {
                if (team == 'h') {
                    runsHome = runsHome + 1;
                }
                else
                    runsVis = runsVis+1;
                bases[0] = 0;
            }

            if (team == 'h') {
                runsHome = runsHome + 1;
            }
            else
                runsVis = runsVis+1;
        }
        return runsHome;

    }


    //method to clear the bases
    public void clearBases(){
        for(int r=0;r<bases.length;r++)
            bases[r]=0;
    }

    //At bat based on random number generator
    public void toBat(int bout, char team) {
        while (bout < 3) {
            atBat = randomNumber();
            if (atBat < 71) {
                batType = "Out";
                bout = bout + 1;
            }
            else if (atBat > 70 && atBat < 88) {
                batType = "Single";
            }
            else if (atBat > 87 && atBat < 95) {
                batType = "Double";
            }
            else if (atBat > 94 && atBat < 97) {
                batType = "Triple";
            }
            else
                batType = "Home Run";

            if (team=='h'){
            evalBases(batType, team);
            System.out.println(rosterB[homeBatCounter] + " At bat was a " + batType);
            homeBatCounter = homeBatCounter + 1;
                    if (homeBatCounter > 8) {
                    homeBatCounter = 0;
                    }
            }
            else if (team=='v') {
                evalBases(batType, team);
                System.out.println(rosterA[visitBatCounter] + " At bat was a " + batType);
                visitBatCounter = visitBatCounter + 1;
                    if (visitBatCounter > 8) {
                    visitBatCounter = 0;
                    }
            }
        }

    }

}
