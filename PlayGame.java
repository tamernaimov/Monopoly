import java.nio.file.attribute.UserPrincipalLookupService;

public class PlayGame {
    private Players users;
    private Dice dice;
    private Properties properties;
    private Player currentPlayer;
    private Board gameBoard;
    private CardManager cardManager;

    public PlayGame(Player currentPlayer, Board gameBoard, CardManager cardManager, Players users, Dice dice, Properties properties) {
        this.currentPlayer = currentPlayer;
        this.gameBoard = gameBoard;
        this.cardManager = cardManager;
        this.users = users;
        this.dice = dice;
        this.properties = properties;
    }

    public void checkAndExecuteCard() {
        int currentPlayerPosition = currentPlayer.getPosition();
        String currentPositionName = gameBoard.getPositionName(currentPlayerPosition);

        if ("Chance".equals(currentPositionName) || "Community Chest".equals(currentPositionName)) {
            drawAndExecuteCard();
        }
    }

    public void drawAndExecuteCard() {
        int currentPlayerPosition = currentPlayer.getPosition();
        String currentPositionName = gameBoard.getPositionName(currentPlayerPosition);

        // Check if the current position is a Chance or Community Chest position
        if ("Chance".equals(currentPositionName) || "Community Chest".equals(currentPositionName)) {
            Cards drawnCard = cardManager.pickRandomCard(currentPositionName);
            if (drawnCard != null) {
                System.out.println(currentPositionName + " Card Drawn: " + drawnCard.getDescription());
                drawnCard.executeAction(currentPlayer);
            }
        }
    }

    public void Play() {
        users.setPlayer();  // Allow players to enter their names
        properties.setProperties();

        for (int i = 0; i < 4; i++) {
            System.out.println(users.players[i].getName() + "'s turn:");
            System.out.println();
            System.out.println(users.players[i].throwDice());
            properties.buyProperty(i);
            checkAndExecuteCard();
        }
    }
}