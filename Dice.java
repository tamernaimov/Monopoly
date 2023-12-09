import java.util.Random;
import java.util.Scanner;
public class Dice {
    private int score = 0;
    public Dice() {
    }
    public int diceScore() {
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
                   if(score > 28) {
                       score = score -28;
                   }
                   //Function to add properties should be added
              }
              if(num1!=num2) {
                  System.out.println("Points From from Dice 1: "+ num1);
                  System.out.println("Points From from Dice 2: "+ num2);
                  score +=num1+num2;

                  return score;
              }
         }
    }

      public int getScore() {
         return score;
      }
}