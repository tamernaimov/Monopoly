import java.util.List;
import java.util.Random;

public class ChanceCard implements Cards{
    private String description;
    private Board board;
    private Random random = new Random();
    public ChanceCard(Board board) {
        this.board= board;
    }
    @Override
    public String getDescription() {
        return description;
    }
    @Override
    public void executeAction(Player player) {
        int currentMoney = player.getMoney();
        int currentPosition = player.getPosition();
        while(true) {
            int randomNum = random.nextInt(1, 13);
            switch (randomNum) {
                case 1:
                    advanceToPosition(player, "GO");
                    break;

                case 2:
                    System.out.println("Player " + player.getName() + " advanced to Trafalgar Square");
                    advanceToPosition(player, "TRAFALGAR \n SQUARE \n $240");
                    break;

                case 3:
                    System.out.println("Player " + player.getName() + " advanced to Electric company.");
                    advanceToPosition(player, "ELECTRIC \n COMPANY \n $150");
                    break;
                case 4:
                    System.out.println("Player " + player.getName() + " advanced to Pall Mall.");
                    advanceToPosition(player, "PALL\n MALL\n $140");
                    System.out.println(player.getPosition());
                    break;
                case 5:
                    System.out.println("Player " + player.getName() + " receives a dividend of $50 from the bank.");
                    currentMoney = +50;
                    player.setMoney(currentMoney);
                    break;

                case 6:
                    System.out.println("Player " + player.getName() + " receives a Get Out of Jail Free card.");
                    player.setHasGetOutOfJailFreeCard(true);
                    break;

                case 7:
                    System.out.println("Player " + player.getName() + " goes back 3 spaces.");
                    advanceToPosition(player, String.valueOf(currentPosition - 3));
                    break;

                case 8:
                    System.out.println("Player " + player.getName() + " goes to Jail.");
                    advanceToPosition(player, "GO TO JAIL!");
                    player.setInJail(true);
                    player.resetRoundsInJail();
                    Jail.handleJail(player);
                    break;

                case 9:
                    System.out.println("Player " + player.getName() + " makes general repairs on all properties.");
                    //logic for making repairs on properties
                    break;

                case 10:
                    System.out.println("Player " + player.getName() + " pays a speeding fine of $15.");
                    currentMoney = -15;
                    player.setMoney(currentMoney);
                    break;

                case 11:
                    System.out.println("Player " + player.getName() + " takes a trip to King's Cross.");
                    if (player.getPosition() > 1) {
                        System.out.println("Player " + player.getName() + " passed Go and collects $200.");
                        advanceToPosition(player, "KING CROSS \n STATION \n $200");
                        currentMoney = +200;
                        player.setMoney(currentMoney);
                    }
                    break;

                case 12:
                    System.out.println("Player " + player.getName() + " has taken a walk o the Whitechapel Road and collected $50");
                    advanceToPosition(player, "WHITECHAPEL \n ROAD \n $50");
                    break;
                default:
                    System.out.println("No specific action for this card");
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