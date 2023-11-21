import java.nio.file.attribute.UserPrincipalLookupService;

public class PlayGame {
      Players users;
      Dice dice;
    public PlayGame(Players users, Dice dice) {
        this.users = users;
        this.dice = dice;
    }
    public void Play() {
        users.setPlayer();
        System.out.println(users.players[1].throwDice());
        System.out.println(users.players[1].getName());
        System.out.println(users.players[1].getPosition());
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
       //System.out.println("*************************************************");
       //System.out.println(users.players[0].throwDice());
       //System.out.println(users.players[0].throwDice());
    }
}