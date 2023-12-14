import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class Property {
    protected String name;
    protected String color;
    protected int price;
    protected int position;
    protected int rent;
    protected boolean isBought = false;
    House house;

    Player[] owner = new Player[1];
    Dice dice = new Dice();
    Players users = new Players(dice);
    protected Property[] properties;
    Properties props = new Properties();
    ArrayList<Hotel> hotels;
    Hotel hotel;


    public Property(String name, String color, int price, int position, int rent) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.position = position;
        this.rent = rent;
        house = new House();
        hotels = new ArrayList<>();
        hotel = new Hotel();
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    public int getPosition() {
        return position;
    }

    public int getRent() {
        return rent;
    }

    public boolean abilityForHotel = false;

    public void buyHosue(int i) {
        Scanner scanner = new Scanner(System.in);
        if (users.players[i].getPosition() == 1 || users.players[i].getPosition() == 3) {
            if (users.players[i].returnProperties().contains(properties[1].getName()) && users.players[i].returnProperties().contains(properties[3].getName())) {
                if (house.houses.size() == 4) {
                    System.out.println("Maximum amount of houses on this property!");
                    abilityForHotel = true;
                } else if (house.houses.size() < 4) {
                    System.out.println("Would you like to buy a house?");
                    String answer = scanner.nextLine();
                    if (answer.equals("Yes") || answer.equals("yes")) {
                        int cost = house.getCost(users.players[i].getPosition());
                        users.players[i].money -= cost;

                        house.houses.add(house);
                        house.decideRent();
                    }
                }
            }
        }
        //6,8,9
        if (users.players[i].getPosition() == 6 || users.players[i].getPosition() == 8 || users.players[i].getPosition() == 9) {
            if (users.players[i].returnProperties().contains(properties[6].getName()) && users.players[i].returnProperties().contains(properties[8].getName()) && users.players[i].returnProperties().contains(properties[9].getName())) {
                if (house.houses.size() == 4) {
                    System.out.println("Maximum amount of houses on this property!");
                    abilityForHotel = true;
                } else if (house.houses.size() < 4) {
                    System.out.println("Would you like to buy a house?");
                    String answer = scanner.nextLine();
                    if (answer.equals("Yes") || answer.equals("yes")) {
                        int cost = house.getCost(users.players[i].getPosition());
                        users.players[i].money -= cost;

                        house.houses.add(house);
                        house.decideRent();
                    }
                }
            }
        }
        //11,13,14
        if (users.players[i].getPosition() == 11 || users.players[i].getPosition() == 13 || users.players[i].getPosition() == 14) {
            if (users.players[i].returnProperties().contains(properties[11].getName()) && users.players[i].returnProperties().contains(properties[13].getName()) && users.players[i].returnProperties().contains(properties[14].getName())) {
                if (house.houses.size() == 4) {
                    System.out.println("Maximum amount of houses on this property!");
                    abilityForHotel = true;
                } else if (house.houses.size() < 4) {
                    System.out.println("Would you like to buy a house?");
                    String answer = scanner.nextLine();
                    if (answer.equals("Yes") || answer.equals("yes")) {
                        int cost = house.getCost(users.players[i].getPosition());
                        users.players[i].money -= cost;

                        house.houses.add(house);
                        house.decideRent();
                    }
                }
            }
        }
        //16,18,19
        if (users.players[i].getPosition() == 16 || users.players[i].getPosition() == 18 || users.players[i].getPosition() == 19) {
            if (users.players[i].returnProperties().contains(properties[16].getName()) && users.players[i].returnProperties().contains(properties[18].getName()) && users.players[i].returnProperties().contains(properties[19].getName())) {
                if (house.houses.size() == 4) {
                    System.out.println("Maximum amount of houses on this property!");
                    abilityForHotel = true;
                } else if (house.houses.size() < 4) {
                    System.out.println("Would you like to buy a house?");
                    String answer = scanner.nextLine();
                    if (answer.equals("Yes") || answer.equals("yes")) {
                        int cost = house.getCost(users.players[i].getPosition());
                        users.players[i].money -= cost;

                        house.houses.add(house);
                        house.decideRent();
                    }
                }
            }
        }
        //21,23,24
        if (users.players[i].getPosition() == 21 || users.players[i].getPosition() == 23 || users.players[i].getPosition() == 24) {
            if (users.players[i].returnProperties().contains(properties[21].getName()) && users.players[i].returnProperties().contains(properties[23].getName()) && users.players[i].returnProperties().contains(properties[24].getName())) {
                if (house.houses.size() == 4) {
                    System.out.println("Maximum amount of houses on this property!");
                    abilityForHotel = true;
                } else if (house.houses.size() < 4) {
                    System.out.println("Would you like to buy a house?");
                    String answer = scanner.nextLine();
                    if (answer.equals("Yes") || answer.equals("yes")) {
                        int cost = house.getCost(users.players[i].getPosition());
                        users.players[i].money -= cost;

                        house.houses.add(house);
                        house.decideRent();
                    }
                }
            }
        }
        //26,27,29
        if (users.players[i].getPosition() == 26 || users.players[i].getPosition() == 27 || users.players[i].getPosition() == 29) {
            if (users.players[i].returnProperties().contains(properties[26].getName()) && users.players[i].returnProperties().contains(properties[27].getName()) && users.players[i].returnProperties().contains(properties[29].getName())) {
                if (house.houses.size() == 4) {
                    System.out.println("Maximum amount of houses on this property!");
                    abilityForHotel = true;
                } else if (house.houses.size() < 4) {
                    System.out.println("Would you like to buy a house?");
                    String answer = scanner.nextLine();
                    if (answer.equals("Yes") || answer.equals("yes")) {
                        int cost = house.getCost(users.players[i].getPosition());
                        users.players[i].money -= cost;

                        house.houses.add(house);
                        house.decideRent();
                    }
                }
            }
        }
        //31,32,34
        if (users.players[i].getPosition() == 31 || users.players[i].getPosition() == 32 || users.players[i].getPosition() == 34) {
            if (users.players[i].returnProperties().contains(properties[31].getName()) && users.players[i].returnProperties().contains(properties[32].getName()) && users.players[i].returnProperties().contains(properties[34].getName())) {
                if (house.houses.size() == 4) {
                    System.out.println("Maximum amount of houses on this property!");
                    abilityForHotel = true;
                } else if (house.houses.size() < 4) {
                    System.out.println("Would you like to buy a house?");
                    String answer = scanner.nextLine();
                    if (answer.equals("Yes") || answer.equals("yes")) {
                        int cost = house.getCost(users.players[i].getPosition());
                        users.players[i].money -= cost;

                        house.houses.add(house);
                        house.decideRent();
                    }
                }
            }
        }
        //37,39
        if (users.players[i].getPosition() == 37 || users.players[i].getPosition() == 39) {
            if (users.players[i].returnProperties().contains(properties[37].getName()) && users.players[i].returnProperties().contains(properties[39].getName())) {
                if (house.houses.size() == 4) {
                    System.out.println("Maximum amount of houses on this property!");
                    abilityForHotel = true;
                } else if (house.houses.size() < 4) {
                    System.out.println("Would you like to buy a house?");
                    String answer = scanner.nextLine();
                    if (answer.equals("Yes") || answer.equals("yes")) {
                        int cost = house.getCost(users.players[i].getPosition());
                        users.players[i].money -= cost;

                        house.houses.add(house);
                        house.decideRent();
                    }
                }
            }
        }
    }

    public void buyHotel(int i) {
        Scanner scanner = new Scanner(System.in);

        if (abilityForHotel == true) {
            if (hotels.isEmpty()) {
                System.out.println("Would you like to buy a hotel");
                String answer = scanner.nextLine();
                if (answer.equals("Yes") || answer.equals("yes")) {
                    if (users.players[i].money - hotel.getCost(users.players[i].getPosition()) > users.players[i].money) {
                        System.out.println("Not enough Money!");
                    } else {
                        hotels.add(hotel);
                        hotel.decideRent();
                        users.players[i].money -= users.players[i].money - hotel.getCost(users.players[i].getPosition());
                        System.out.println("You Have officially purchased a Hotel on this Property");
                    }
                }
            }
        }
    }
}