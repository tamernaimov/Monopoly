import java.util.Scanner;
public class Properties {
    protected Property[] properties;
    Players users;
    Scanner scanner = new Scanner(System.in);
    public Properties(Players users) {
        properties = new Property[22];
        this.users = users;
    }
    public void setProperties() {
        for (int i = 0; i < 22; i++) {
            properties[0] = new Property("Old Kent Road", "Brown", 60);
            properties[1] = new Property("Whitechapel Road", "Brown", 60);
            properties[2] = new Property("The Angel Islington", "Blue", 100);
            properties[3] = new Property("Euston Road", "Blue", 100);
            properties[4] = new Property("Pentonville Road", "Blue", 120);
            properties[5] = new Property("Pall Mall", "Pink", 140);
            properties[6] = new Property("Whitehall", "Pink", 140);
            properties[7] = new Property("Northumberland Avenue", "Pink", 160);
            properties[8] = new Property("Bow Street", "Orange", 180);
            properties[9] = new Property("Marlborough Street", "Orange", 180);
            properties[10] = new Property("Vine Street", "Orange", 200);
            properties[11] = new Property("Strand", "Red", 220);
            properties[12] = new Property("Fleet Street", "Red", 220);
            properties[13] = new Property("Trafalgar Square", "Red", 240);
            properties[14] = new Property("Leicester Square", "Yellow", 260);
            properties[15] = new Property("Coventry Street", "Yellow", 260);
            properties[16] = new Property("Piccadilly", "Yellow", 280);
            properties[17] = new Property("Regent Street", "Green", 300);
            properties[18] = new Property("Oxford Street", "Green", 300);
            properties[19] = new Property("Bond Street", "Green", 320);
            properties[20] = new Property("Park Lane", "Blue", 350);
            properties[21] = new Property("Mayfair", "Blue", 400);

        }

    }

    public void buyProperty(int i) {
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
