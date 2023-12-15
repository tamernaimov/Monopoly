import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player {
    private Dice dice;
    Players players;
    Round round;
    Board board =new Board();
    ArrayList<Property> properties = new ArrayList<>();
    CommunityChestCard communityChestCard;
    ChanceCard chanceCard;
    MonopolyProperties monopolyProperties;
    int score =0;

    public Player(Dice dice) {
        this.dice =dice;
    }

    protected int money;
    private int position;
    protected String name;
    private boolean hasGetOutOfJailFreeCard;

    public int getMoney() {
        return money;
    }

    public void setMoney(int newMoney) {
        money = newMoney;
    }

    public int diceScore() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            Random random1 = new Random();
            int num1 = random1.nextInt(1, 2);

            Random random2 = new Random();
            int num2 = random2.nextInt(2, 3);

            if (num1 == num2) {
                System.out.println("A DOUBLE!");
                System.out.println("Points From Dice 1: " + num1);
                System.out.println("Points From Dice 2: " + num2);
                System.out.println("Both Together: " + (num1 + num2));
                System.out.println("Press ENTER To throw the dices again!");
                scanner.nextLine();
                score += num1 + num2;
                if (score > 39) {
                    score = score - 39;
                }


            }
            if (num1 != num2) {
                System.out.println("Points From from Dice 1: " + num1);
                System.out.println("Points From from Dice 2: " + num2);
                score += num1 + num2;

                if (score > 39) {
                    score = score - 39;
                }
                return score;
            }
        }
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int newPosition) {
        this.position = newPosition;
    }

    public String getName() {
        return name;
    }

    public String returnProperties() {
        StringBuilder result = new StringBuilder();
        if (properties.size() == 0) {
            return "No Properties!";
        }
        for (Property property : properties) {
            result.append(property.getName()).append(" ");
        }
        return result.toString().trim();
    }

    private boolean isInJail;
    private int roundsInJail;

    public boolean isInJail() {
        return isInJail;
    }

    public void setInJail(boolean inJail) {
        isInJail = inJail;
    }

    public void setRoundsInJail(int roundsInJail) {
        this.roundsInJail = roundsInJail;
    }

    public int getRoundsInJail() {
        return roundsInJail;
    }

    public void incrementRoundsInJail() {
        roundsInJail++;
    }

    public void resetRoundsInJail() {
        roundsInJail = 0;
    }

    public boolean hasGetOutOfJailFreeCard() {
        return hasGetOutOfJailFreeCard;
    }

    public void setHasGetOutOfJailFreeCard(boolean hasCard) {
        this.hasGetOutOfJailFreeCard = hasCard;
    }

    public void useGetOutOfJailFreeCard() {
        if (hasGetOutOfJailFreeCard) {
            this.hasGetOutOfJailFreeCard = false;
        }
    }
}