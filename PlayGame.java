import java.nio.file.attribute.UserPrincipalLookupService;

public class PlayGame {
      Players users;
      Dice dice;
      Properties properties;
    public PlayGame(Players users, Dice dice,Properties properties) {
        this.users = users;
        this.dice = dice;
        this.properties = properties;
    }
    public void Play() {
        users.setPlayer();  // Allow players to enter their names
        properties.setProperties();

        for (int i = 0; i < 4; i++) {
            System.out.println(users.players[i].getName() + "'s turn:");
            System.out.println();
            System.out.println(users.players[i].throwDice());
            properties.buyProperty(i);
        }
    }
}