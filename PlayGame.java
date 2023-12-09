import java.nio.file.attribute.UserPrincipalLookupService;

public class PlayGame {
    Players users;
    Dice dice;
    private Player currentPlayer;
    private Board gameBoard;
    private CardManager cardManager;

    public PlayGame(Player currentPlayer, Board gameBoard, CardManager cardManager) {
        this.currentPlayer = currentPlayer;
        this.gameBoard = gameBoard;
        this.cardManager = cardManager;
    }
    public void checkAndExecuteCard() {
        int currentPlayerPosition = currentPlayer.getPosition();
        String currentPositionName = gameBoard.getPositionName(currentPlayerPosition);

        if ("Chance".equals(currentPositionName)) {
            drawAndExecuteCard();
        }

        if ("Community Chest".equals(currentPositionName)) {
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
        checkAndExecuteCard();
    }
}