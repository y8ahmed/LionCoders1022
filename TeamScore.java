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
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int[] t1Array = new int[4];
        int[] t2Array = new int[4];

        int team1Score = 0;
        int team2Score = 0;


        for (int i = 0; i < 4; i++) {
            System.out.println("Enter Team 1 points: ");
            t1Array[i] = Integer.parseInt(in.nextLine());
            System.out.println("Enter Team 2 points: ");
            t2Array[i] = Integer.parseInt(in.nextLine());
        }
        if (team1Score > team2Score){
            System.out.println("Team 1 won");
        }else if (team2Score > team1Score){
            System.out.println("Team 2 won");
        }else if (team1Score == team2Score){
            System.out.println("Tie");
        }else{
            System.out.println("Error");
        }
    }
}
