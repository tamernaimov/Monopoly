import java.util.Scanner;
public class Player {
    private Dice dice = new Dice();
    public Player(Dice dice) {
        this.dice = new Dice();
    }
    Scanner scanner = new Scanner(System.in);
    protected int money;
    protected int position;
    protected String name;
     public int getMoney() {
        return money;
     }
    // Getter for position
   public int throwDice() {
        this.position = dice.throwDice();
        return this.position;
    }
    public int getPosition() {
         return dice.getScore();
    }
    // Getter for name
    public String getName() {
        return name;
    }
}