import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private Dice dice;
    ArrayList<Property> properties = new ArrayList<>();

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