import java.util.List;
import java.util.Random;

public class CommunityChestCard implements Cards {
    private String description;
    private Board board;
    private Random random = new Random();

    Round round;
    Players users;
    CommunityChestCard communityChestCard;
    ChanceCard chanceCard;
    MonopolyProperties monopolyProperties;
    public CommunityChestCard(Board board) {
        round = new Round(users,communityChestCard,chanceCard, monopolyProperties);
        this.board = board;
    }

    @Override
    public String getDescription() {
        return description;
    }


    @Override
    public void executeAction(Player player) {
        int currentMoney = player.getMoney();
        List<Player> allPlayers = Players.getAllPlayers();
        int i =round.x%4;
        while (true) {

            int randomNum = random.nextInt(1, 17);
            switch (randomNum) {
                case 1:
                    System.out.println("Player " + player.getName() + " advances to Go and collects $200.");
                    currentMoney = +200;
                    player.setMoney(currentMoney);
                    advanceToPosition(player, "GO");
                    round.outcomeResult(i);
                    break;

                case 2:
                    System.out.println("Player " + player.getName() + " collects $200 due to a bank error.");
                    player.setMoney(currentMoney + 200);

                    System.out.println("Money: " + player.getMoney());
                    break;

                case 3:
                    System.out.println("Player " + player.getName() + " pays a doctor's fee of $50.");
                    player.setMoney(currentMoney - 50);

                    System.out.println("Money: " + player.getMoney());
                    break;

                case 4:
                    System.out.println("Player " + player.getName() + " receives $50 from the sale of stock.");
                    player.setMoney(currentMoney + 50);

                    System.out.println("Money: " + player.getMoney());
                    break;

                case 5:
                    System.out.println("Player " + player.getName() + " receives a Get Out of Jail Free card.");
                    player.setHasGetOutOfJailFreeCard(true);
                    break;

                case 6:
                    System.out.println("Player " + player.getName() + " goes to Jail.");
                    advanceToPosition(player, "GO TO JAIL!");
                    player.setInJail(true);
                    player.resetRoundsInJail();
                    Jail.handleJail(player);
                    break;

                case 7:
                    System.out.println("Player " + player.getName() + " receives $100 as the holiday fund matures.");
                    player.setMoney(currentMoney + 100);

                    System.out.println("Money: " + player.getMoney());
                    break;

                case 8:
                    System.out.println("Player " + player.getName() + " collects an income tax refund of $20.");
                    player.setMoney(currentMoney + 20);

                    System.out.println("Money: " + player.getMoney());
                    break;

                case 9:
                    System.out.println("Player " + player.getName() + " collects $10 from every player for their birthday.");
                    for (Player otherPlayer : allPlayers) {
                        if (otherPlayer != player) {
                            int otherPlayerMoney = otherPlayer.getMoney();
                            otherPlayer.setMoney(otherPlayerMoney - 10);
                            player.setMoney(player.getMoney() + 10);
                        }
                    }
                    break;

                case 10:
                    System.out.println("Player " + player.getName() + " collects $100 as their life insurance matures.");
                    player.setMoney(currentMoney + 100);

                    System.out.println("Money: " + player.getMoney());
                    break;

                case 11:
                    System.out.println("Player " + player.getName() + " pays hospital fees of $100.");
                    player.setMoney(currentMoney - 100);

                    System.out.println("Money: " + player.getMoney());
                    break;

                case 12:
                    System.out.println("Player " + player.getName() + " pays school fees of $50.");
                    player.setMoney(currentMoney - 50);

                    System.out.println("Money: " + player.getMoney());
                    break;

                case 13:
                    System.out.println("Player " + player.getName() + " receives a $25 consultancy fee.");
                    player.setMoney(currentMoney + 25);

                    System.out.println("Money: " + player.getMoney());
                    break;

                case 14:
                    System.out.println("Player " + player.getName() + " is assessed for street repair.");
                    break;

                case 15:
                    System.out.println("Player " + player.getName() + " has won second prize in a beauty contest and collects $10.");
                    player.setMoney(currentMoney + 10);

                    System.out.println("Money: " + player.getMoney());
                    break;

                case 16:
                    System.out.println("Player " + player.getName() + " inherits $100.");
                    player.setMoney(currentMoney + 100);

                    System.out.println("Money: " + player.getMoney());
                    break;

                default:
                    System.out.println("No specific action for this Community Chest card");
                    break;
            }
            break;
        }
    }

    private void advanceToPosition(Player player, String targetPosition) {
        List<String> boardPositions = board.getBoardPositions();
        int targetPos = board.getPositionIndexByName(targetPosition);
        int currentPosition = player.getPosition();
        int spacesToMove = (targetPos - currentPosition + boardPositions.size()) % boardPositions.size();
        int newPosition = (currentPosition + spacesToMove) % boardPositions.size();
        player.setPosition(newPosition);

        System.out.println("Player " + player.getName() + " advanced to " + targetPosition);
    }
}