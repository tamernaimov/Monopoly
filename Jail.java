import java.util.Scanner;

public class Jail {
    private static final int JAIL_ROUNDS = 2;
    private static final int JAIL_FINE = 1500;

    public static void handleJail(Player player) {
        if (player.isInJail()) {
            if (player.getRoundsInJail() == JAIL_ROUNDS) {
                player.setInJail(false);
                System.out.println(player.getName() + " served " + JAIL_ROUNDS + " rounds in jail and is now out.");
            } else {
                System.out.println(player.getName() + " is in jail. Options:");
                System.out.println("1. Pay fine to get out ($" + JAIL_FINE + ")");
                System.out.println("2. Roll the dice for a double");
                System.out.println("3. Use a Get Out of Jail Free card");
                System.out.println("4. Wait for the next round");

                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        payFine(player);
                        break;
                    case 2:
                        rollForDouble(player);
                        break;
                    case 3:
                        useGetOutOfJailFreeCard(player);
                        break;
                    case 4:
                        System.out.println(player.getName() + " is waiting for the next round in jail.");
                        player.incrementRoundsInJail();
                        break;
                    default:
                        System.out.println("Invalid choice. Player remains in jail.");
                }
            }
        }
    }

    private static void payFine(Player player) {
        if (player.getMoney() >= JAIL_FINE) {
            player.setInJail(false);
            player.setMoney(player.getMoney() - JAIL_FINE);
            System.out.println(player.getName() + " paid the fine and is out of jail.");
        } else {
            System.out.println("Insufficient funds. Player remains in jail.");
        }
    }

    private static void rollForDouble(Player player) {
        int diceRoll1 = player.throwDice();
        int diceRoll2 = player.throwDice();
        System.out.println(player.getName() + " rolled a " + diceRoll1 + " and " + diceRoll2);

        if (diceRoll1 == diceRoll2) {
            player.setInJail(false);
            System.out.println(player.getName() + " rolled a double and is out of jail.");
        } else {
            System.out.println(player.getName() + " did not roll a double. Player remains in jail.");
        }
    }

    private static void useGetOutOfJailFreeCard(Player player) {
        if (player.hasGetOutOfJailFreeCard()) {
            player.setInJail(false);
            player.useGetOutOfJailFreeCard();
            System.out.println(player.getName() + " used a Get Out of Jail Free card and is out of jail.");
        } else {
            System.out.println(player.getName() + " does not have a Get Out of Jail Free card.");
        }
    }
}
