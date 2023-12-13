public class PlayGame {
    private Players users;
    private Dice dice;
    private MonopolyProperties monopolyProperties;
    private Player currentPlayer;
    private Board gameBoard;
    private CardManager cardManager;
    Round round;

    public PlayGame(Player currentPlayer, Board gameBoard, CardManager cardManager, Players users, Dice dice, MonopolyProperties monopolyProperties, Round round) {
        this.currentPlayer = currentPlayer;
        this.gameBoard = gameBoard;
        this.cardManager = cardManager;
        this.users = users;
        this.dice = dice;
        this.monopolyProperties = monopolyProperties;
        this.round = round;

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
        users.setPlayer();
        monopolyProperties.setProperties();
        int x = 4;

        while (users.players.length > 0) {
            for (int i = 0; i < x; i++) {
                System.out.println(users.players[i].getName() + "'s turn:");
                System.out.println();
                int newPosition = users.players[i].throwDice();
                users.players[i].setPosition(newPosition);

                round.outcomeResult(i);

                if (users.players[i].getMoney() <= 0) {

                    removePlayer(i);
                    i--;
                    x--;
                }
            }
        }
    }
    private void removePlayer(int index) {
        // Create a new array without the player to be removed
        Player[] newPlayersArray = new Player[users.players.length - 1];
        System.arraycopy(users.players, 0, newPlayersArray, 0, index);
        System.arraycopy(users.players, index + 1, newPlayersArray, index, users.players.length - index - 1);
        users.players = newPlayersArray;
    }
}