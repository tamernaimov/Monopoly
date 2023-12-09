import java.util.Scanner;
public class Player {
    private Dice dice = new Dice();
    public Player(Dice dice) {
        this.dice = new Dice();
    }
    Scanner scanner = new Scanner(System.in);
    protected int money;
    private int position;
    protected String name;
     public int getMoney() {
        return money;
     }
    // Getter for position
    public void setMoney(int newMoney) {
        money = newMoney;
    }
    public int throwDice() {
        position = dice.diceScore();
        return position;
    }
    public int getPosition() {
         return position;
    }
    public void setPosition(int newPosition) {
        this.position = newPosition;
    }
    // Getter for name
    public String getName() {
        return name;
    }
}