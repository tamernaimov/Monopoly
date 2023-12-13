import java.util.Properties;
import java.util.Scanner;

public class Round {
    protected Property[] properties;

    Players users;
    Scanner scanner = new Scanner(System.in);
    ChanceCard chanceCard;
    CommunityChestCard communityChestCard;
    MonopolyProperties props;

    public Round(Players users, CommunityChestCard communityChestCard, ChanceCard chanceCard,MonopolyProperties props) {
        this.users = users;
        this.communityChestCard = communityChestCard;
        this.chanceCard = chanceCard;
        this.props = props;


    }

    public void outcomeResult(int i) {

        properties = props.setProperties();
        if (users.players[i].getPosition() == 3 || users.players[i].getPosition() == 17) {
            communityChestCard.executeAction(users.players[i]);
        } else if (users.players[i].getPosition() == 7 || users.players[i].getPosition() == 36) {
            chanceCard.executeAction(users.players[i]);
        } else if (users.players[i].getPosition() == 4) {
            users.players[i].money = users.players[i].getMoney() - 100;
        } else if (users.players[i].getPosition() == 5 || users.players[i].getPosition() == 15 || users.players[i].getPosition() == 25 || users.players[i].getPosition() == 35) {
            System.out.println("Visiting the train stations");
            //FUNCTIONS SHOULD BE ADDED
        } else {
            System.out.println("Would you like to buy this property");
            System.out.println();
            System.out.println("Name: " + properties[users.players[i].getPosition()].getName());
            System.out.println("Price: " + properties[users.players[i].getPosition()].getPrice());
            System.out.println("Color: " + properties[users.players[i].getPosition()].getColor());
            String answer = scanner.nextLine();
            if (answer.equals("Yes") || answer.equals("yes")) {
                if (users.players[i].getMoney() >= properties[users.players[i].getPosition()].getPrice()) {
                    users.players[i].money -= properties[users.players[i].getPosition()].getPrice();

                    properties[users.players[i].getPosition()].isBought = true;
                    properties[users.players[i].getPosition()].owner[0] = users.players[i];
                    System.out.println("You have Successfully bought this property!");
                } else {
                    System.out.println("You don't have enough money.");
                }
            }
        }
    }
}
