import java.util.Scanner;
public class Players {
    protected Player[] players;
    private Scanner scanner = new Scanner(System.in);
    public Players(Dice dice) {
        players = new Player[4];
        for (int i = 0; i < 4; i++) {
            players[i] = new Player(dice);
        }
    }
       public void setPlayer() {
        for (int i = 0; i < 4; i++) {
            System.out.println("Enter name for player number " + (i + 1) + ":");
            players[i].name = scanner.nextLine();
            players[i].money = 1500;
        }
    }
}