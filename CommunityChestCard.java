import java.util.List;

public class CommunityChestCard implements Cards{
    private String description;
    private Board board;

    public CommunityChestCard(String description, Board board) {
        this.description = description;
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

        switch (getDescription()) {
            case "Advance to Go (Collect $200)":
                System.out.println("Player " + player.getName() + " advances to Go and collects $200.");
                player.setMoney(currentMoney + 200);
                advanceToPosition(player,"GO");
                break;

            case "Bank error in your favor. Collect $200":
                System.out.println("Player " + player.getName() + " collects $200 due to a bank error.");
                player.setMoney(currentMoney + 200);
                break;

            case "CommunityChest:Doctor's fee. Pay $50":
                System.out.println("Player " + player.getName() + " pays a doctor's fee of $50.");
                player.setMoney(currentMoney - 50);
                break;

            case "CommunityChest:From sale of stock you get $50":
                System.out.println("Player " + player.getName() + " receives $50 from the sale of stock.");
                player.setMoney(currentMoney + 50);
                break;

            case "CommunityChest:Get Out of Jail Free":
                System.out.println("Player " + player.getName() + " receives a Get Out of Jail Free card.");
                player.setHasGetOutOfJailFreeCard(true);
                break;

            case "CommunityChest:Go to Jail. Go directly to jail, do not pass Go, do not collect $200":
                System.out.println("Player " + player.getName() + " goes to Jail.");
                advanceToPosition(player,"GO TO JAIL!");
                player.setInJail(true);
                player.resetRoundsInJail();
                Jail.handleJail(player);
                break;

            case "CommunityChest:Holiday fund matures. Receive $100":
                System.out.println("Player " + player.getName() + " receives $100 as the holiday fund matures.");
                player.setMoney(currentMoney + 100);
                break;

            case "CommunityChest:Income tax refund. Collect $20":
                System.out.println("Player " + player.getName() + " collects an income tax refund of $20.");
                player.setMoney(currentMoney + 20);
                break;

            case "CommunityChest:It is your birthday. Collect $10 from every player":
                System.out.println("Player " + player.getName() + " collects $10 from every player for their birthday.");
                for (Player otherPlayer : allPlayers) {
                    if (otherPlayer != player) {
                        int otherPlayerMoney = otherPlayer.getMoney();
                        otherPlayer.setMoney(otherPlayerMoney - 10);
                        player.setMoney(player.getMoney() + 10);
                    }
                }
                break;

            case "CommunityChest:Life insurance matures.Collect $100":
                System.out.println("Player " + player.getName() + " collects $100 as their life insurance matures.");
                player.setMoney(currentMoney + 100);
                break;

            case "CommunityChest:Pay hospital fees of $100":
                System.out.println("Player " + player.getName() + " pays hospital fees of $100.");
                player.setMoney(currentMoney - 100);
                break;

            case "CommunityChest:Pay school fees of $50":
                System.out.println("Player " + player.getName() + " pays school fees of $50.");
                player.setMoney(currentMoney - 50);
                break;

            case "CommunityChest:Receive $25 consultancy fee":
                System.out.println("Player " + player.getName() + " receives a $25 consultancy fee.");
                player.setMoney(currentMoney + 25);
                break;

            case "CommunityChest:You are assessed for street repair. $40 per house. $115 per hotel":
                System.out.println("Player " + player.getName() + " is assessed for street repair.");
                break;

            case "CommunityChest:You have won second prize in a beauty contest. Collect $10":
                System.out.println("Player " + player.getName() + " has won second prize in a beauty contest and collects $10.");
                player.setMoney(currentMoney + 10);
                break;

            case "CommunityChest:You inherit $100":
                System.out.println("Player " + player.getName() + " inherits $100.");
                player.setMoney(currentMoney + 100);
                break;

            default:
                System.out.println("No specific action for this Community Chest card");
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
