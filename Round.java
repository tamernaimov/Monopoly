import java.util.Properties;
import java.util.Scanner;

public class Round {
    public int x =0;
    protected Property[] properties;
    House house;
    Players users;
    Dice dice = new Dice();
    Scanner scanner = new Scanner(System.in);
    ChanceCard chanceCard;
    CommunityChestCard communityChestCard;
    MonopolyProperties props;

    public Round(Players users, CommunityChestCard communityChestCard, ChanceCard chanceCard, MonopolyProperties props) {
        this.users = users;
        this.communityChestCard = communityChestCard;
        this.chanceCard = chanceCard;
        this.props = props;
        house = new House();
    }

    public void outcomeResult(int i) {
        System.out.println();

        for (int j = 0; j < 4; j++) {
            System.out.println(users.players[j].getName()+ "'s  Position is: " + users.players[j].getPosition());
        }
        System.out.println();
        properties = props.setProperties();
        if (users.players[i].getPosition() == 20) {
            System.out.println("Just visiting The Parking lot..");
        }
        else if (users.players[i].getPosition() == 10) {
            System.out.println("Just visiting the jail..");
        }
        else if(users.players[i].getPosition() == 28) {
            System.out.println("water or something...");
            //ADd functions!
        }
        else if(users.players[i].getPosition() == 30) {
            users.players[i].setInJail(true);
        }
        else if (users.players[i].getPosition() == 12) {
            //ADd Funcftions
            System.out.println("150 Dollars will be taken!");
           users.players[i].money -= 150;
        }
        else if (users.players[i].getPosition() == 2 || users.players[i].getPosition() == 17 || users.players[i].getPosition() == 33) {
            communityChestCard.executeAction(users.players[i]);
        } else if (users.players[i].getPosition() == 7 || users.players[i].getPosition() == 22 ||users.players[i].getPosition() == 36) {
            chanceCard.executeAction(users.players[i]);
        } else if (users.players[i].getPosition() == 4 || users.players[i].getPosition() ==38) {
            users.players[i].money = users.players[i].money - 100;
        } else if (users.players[i].getPosition() == 5 || users.players[i].getPosition() == 15 || users.players[i].getPosition() == 25 || users.players[i].getPosition() == 35) {
            System.out.println("Visiting the train stations");
            //FUNCTIONS SHOULD BE ADDED
        } else {
            boolean permission = true;

            outerloop:
            for (int j = 0; j < props.ownedProperties().length; j++) {
                if (users.players[i].getPosition() == props.ownedProperties()[j].getPosition()) {
                    String propertyName = props.ownedProperties()[j].getName();

                    if (users.players[i].returnProperties().contains(propertyName)) {
                        // Player landed on their own property
                        System.out.println("You are On your Own Property!");
                        properties[users.players[i].getPosition()].buyHosue(i);
                    } else {
                        // Player landed on someone else's property
                        System.out.println("You have landed on someone else's property! Pay up!");
                        users.players[i].money -= props.ownedProperties()[j].getRent();
                    }

                    permission = false;
                    break; // Exit the loop after handling the scenario
                }
            }


            if (permission == true) {

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
                        users.players[i].properties.add(properties[users.players[i].getPosition()]);
                        System.out.println("You have Successfully bought this property!");
                    } else {
                        System.out.println("You don't have enough money.");
                    }
                }
                properties[users.players[i].getPosition()].buyHosue(i);
                properties[users.players[i].getPosition()].buyHotel(i);
            }
        }
        showMenu(i);
    }

    public void showMenu(int i) {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println();
        System.out.println("Which information about you would you like to see?");
        System.out.println("1: Your Money");
        System.out.println("2: Your Properties");
        System.out.println("3: None");

        int answer = scanner1.nextInt();
        switch (answer) {
            case 1:

                System.out.println(users.players[i].getMoney());
                break;

            case 2:
                System.out.println(users.players[i].returnProperties());
                break;
            case 3:
                break;
        }
    }
}
