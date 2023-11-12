import java.util.Random;
import java.util.Scanner;
public class Dice {
    private int score;
    public Dice() {
    }
    public int throwDice() {

         while(true) {
              Scanner scanner = new Scanner(System.in);
              Random random1= new Random();
              int num1 = random1.nextInt(1,7);

              Random random2 = new Random();
              int num2= random2.nextInt(1,7);

              if(num1 == num2) {
                  System.out.println("A DOUBLE!");
                  System.out.println("Points From Dice 1: "+ num1);
                  System.out.println("Points From Dice 2: "+ num2);
                  System.out.println("Both Together: " + (num1+num2));
                  System.out.println("Press ENTER To throw the dices again!");
                  scanner.nextLine();
                  score += num1+num2;
              }
              if(num1!=num2) {
                  System.out.println("Points From from Dice 1: "+ num1);
                  System.out.println("Points From from Dice 2: "+ num2);
                  score +=num1+num2;
                  System.out.println("All points from these rolls: "+ score);
                  return score;
              }

         }
    }
    public int getScore() {
        if(score > 28) {
            return score = score -28;
        }
        else
            return score;
    }
}
