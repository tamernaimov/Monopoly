import java.util.List;

public class ChanceCard implements Cards{
    private String description;
    private Board board;
    public ChanceCard(String description,Board board) {
        this.description = description;
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
        // description for cards
        switch (getDescription()) {
            case "Advance to GO":
                System.out.println("Player " + player.getName() + "to GO");
                advanceToPosition(player, "GO");
                break;

            case "Advance to Trafalgar Square":
                System.out.println("Player " + player.getName() + " advanced to Trafalgar Square");
                advanceToPosition(player, "TRAFALGAR \n SQUARE \n $240");
                break;

            case "Advance to Electric company. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times the amount thrown.":
                System.out.println("Player " + player.getName() + " advanced to Electric company.");
                advanceToPosition(player, "ELECTRIC \n COMPANY \n $150");
                break;
            case "Advance to Pall Mall":
                System.out.println("Player " + player.getName() + " advanced to Pall Mall.");
                advanceToPosition(player, "Advance to Pall Mall");
                break;
            case "Bank pays you dividend of $50":
                System.out.println("Player " + player.getName() + " receives a dividend of $50 from the bank.");
                currentMoney = + 50;
                player.setMoney(currentMoney);
                break;

            case "Get Out of Jail Free":
                System.out.println("Player " + player.getName() + " receives a Get Out of Jail Free card.");
                // Add logic for handling the Get Out of Jail Free card
                break;

            case "Go Back 3 Spaces":
                System.out.println("Player " + player.getName() + " goes back 3 spaces.");
                advanceToPosition(player, String.valueOf(currentPosition-3));
                break;

            case "Go to Jail. Go directly to Jail, do not pass Go, do not collect $200":
                System.out.println("Player " + player.getName() + " goes to Jail.");
                advanceToPosition(player,"GO TO JAIL!");
                break;

            case "Make general repairs on all your property. For each house pay $25. For each hotel pay $100":
                System.out.println("Player " + player.getName() + " makes general repairs on all properties.");
                //logic for making repairs on properties
                break;

            case "Speeding fine $15":
                System.out.println("Player " + player.getName() + " pays a speeding fine of $15.");
                currentMoney =- 15;
                player.setMoney(currentMoney);
                break;

            case "Take a trip to King's Cross Station: If you pass GO, collect $200.":
                System.out.println("Player " + player.getName() + " takes a trip to King's Cross.");
                if (player.getPosition() > 1) {
                    System.out.println("Player " + player.getName() + " passed Go and collects $200.");
                    advanceToPosition(player,"KING CROSS \n STATION \n $200");
                    currentMoney= + 200;
                    player.setMoney(currentMoney);
                }
                break;

            case "Take a walk on the Whitechapel Road: Collect $50.":
                System.out.println("Player " + player.getName() + " has taken a walk o the Whitechapel Road and collected $50");
                advanceToPosition(player,"WHITECHAPEL \n ROAD \n $50");
                break;
            default:
                System.out.println("No specific action for this card");
                break;
        }
    }
    private void advanceToPosition(Player player, String targetPosition) {
        List<String> boardPositions = board.getBoardPositions();
        int targetPos = board.getPositionIndexByName(targetPosition);
        int currentPosition = player.getPosition();
        int spacesToMove = (targetPos - currentPosition + boardPositions.size()) % boardPositions.size();

        // Update the player's position
        int newPosition = (currentPosition + spacesToMove) % boardPositions.size();
        player.setPosition(newPosition);

        System.out.println("Player " + player.getName() + " advanced to " + targetPosition);
    }
}
