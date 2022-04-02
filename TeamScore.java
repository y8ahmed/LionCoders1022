import java.util.Scanner;

public class TeamScore {

    public static boolean createWinner(int points1, int points2)
    {
        if (points1 > points2)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    public static String scoreBoard(int point1, int point2){
        String score = "|-----------------|" + "\n";
        score += "| Team 1 Score: " + point1 + " |" + "\n";
        score += "|-----------------|" + "\n";
        score += "| Team 2 Score: " + point2 + " |" + "\n";
        score += "|-----------------|";
        return score;
    }

  
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int[] t1Array = new int[4];
        int[] t2Array = new int[4];

       

        int team1Score = 0;
        int team2Score = 0;

        int rounds = 0;

        System.out.println("Enter how many rounds you would like to play: ");
        rounds = Integer.parseInt(in.nextLine());


        for (int i = 0; i < rounds; i++) {
            System.out.println("Enter Team 1 points: ");
            t1Array[i] = Integer.parseInt(in.nextLine());
            System.out.println("Enter Team 2 points: ");
            t2Array[i] = Integer.parseInt(in.nextLine());
            if (t1Array[i] > t2Array[i]){
                System.out.println("Team 1 won this round.");
                team1Score++;
                System.out.println("Current Score: " + "\n" + scoreBoard(team1Score, team2Score));
            }else if (t2Array[i] > t1Array[i]){
                System.out.println("Team 2 won this round.");
                team2Score++;
                System.out.println("Current Score: " + "\n" + scoreBoard(team1Score, team2Score));
            }else if (t1Array[i] == t2Array[i]){
                System.out.println("This round ended in a tie.");
                System.out.println("Current Score: " + "\n" + scoreBoard(team1Score, team2Score));
            }else{
                System.out.println("Error");
            }
        }

        if(team1Score > team2Score){
            System.out.println("Team 1 has won the game with a score of: " + team1Score);
            System.out.println("Team 1 beat Team 2 by " + (team1Score - team2Score) + " points.");
        }

        else if(team2Score > team1Score){
            System.out.println("Team 2 has won the game with a score of: " + team2Score);
            System.out.println("Team 2 beat Team 1 by " + (team2Score - team1Score) + " points.");
        }

        else if(team1Score == team2Score){
            System.out.println("Tie. No One has won the game.");
        }
        

    
       
    }

    
    
}


