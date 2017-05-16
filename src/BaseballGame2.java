/**
 * Created by johnkrawulski on 4/26/17.
 */
public class BaseballGame2 extends BaseballUtility2 {

    int homeBatCounter=0;
    int visitBatCounter=0;
    private static int nextBatterHome=0;
    private static int nextBatterVisit=0;
    int runsHomeTotal=0;
    int runsVisTotal=0;

    //Not req'd because of inheritance, used to show instantiation
    BaseballUtility2 bbUtil = new BaseballUtility2();
    int inning=1;



    // code for Home team inning at bat
    public void generateHomeHalfInning() {
        //clear bases, reset outs, set next batter
        bbUtil.clearBases();
        int out = 0;
        char team='h';
        homeBatCounter=nextBatterHome;

        toBat(out, team);

        //Tracking runs
        System.out.println("Inning runs = "+runsHome);
        runsHomeTotal = runsHomeTotal+runsHome;
        System.out.println("Home team total runs = "+runsHomeTotal);
        printFormat();
        nextBatterHome=homeBatCounter;
        runsHome=0;

    }

    // code for Visitor team inning at bat
    public void generateVisitorHalfInning() {
        //clear bases, reset outs, set next batter
        bbUtil.clearBases();
        int out = 0;
        char team='v';
        visitBatCounter = nextBatterVisit;

        //Print inning header
        System.out.println("This is inning number " + inning);
        printFormat();

        toBat(out, team);

        //Tracking runs
        System.out.println("Inning runs = "+runsVis);
        runsVisTotal = runsVisTotal+runsVis;
        System.out.println("Visitor team total runs = "+runsVisTotal);
        printFormat();
        nextBatterVisit=visitBatCounter;
        runsVis=0;
        inning=inning+1;


    }
    //code to start game
    public void generateGame(){
        generateVisitorHalfInning();
        generateHomeHalfInning();

    }


}
