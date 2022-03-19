import java.util.Random;
public class guessNumber {
    public int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.ints(min, max)
                .findFirst()
                .getAsInt();

    }

    public int modChoose(String input, int min, int max) {
        //input in android is a button
        int result = 0;
        if (input == "Easy mode") {
            min = 1;
            max = 10;
            result = getRandomNumberUsingNextInt(min, max);
        } else if (input == "Normal mode") {
            min = 1;
            max = 25;
            result = getRandomNumberUsingNextInt(min, max);
        } else if (input == "Hard mode") {
            min = 1;
            max = 50;
            result = getRandomNumberUsingNextInt(min, max);
        } else if (input == "customize") {
            result = getRandomNumberUsingNextInt(min, max);
        }
        return result;
    }

    public static void theme(String color){
        if (color.equals("ocean")){
            // change color to blue
        }else if (color.equals("forest")){
            // change color to green
        }else if (color.equals("dessert")){
            // change color to yellow
        }if (color.equals("default")){
            // change color to default color white
        }
    }


    public String guess(int input){
        input = 0;
        int c = 0;
        while ( input>=0){
            if (input == modChoose("", 2, 3))
            ;
        }
        return null;
    }

}