import java.io.File;

public class Main {

    public static void cards(){
        String filePathToCards = "C:\\Users\\Lenovo\\Desktop\\Project unit2\\ChancesAndCommunityChestCards";
        String fileName = "Cards.txt";
        String cardPath = filePathToCards + File.separator + fileName;

        // Check if the file exists
        File file = new File(cardPath);
        if (!file.exists()) {
            System.err.println("File does not exist: " + cardPath);
            return;
        }
        Board board = new Board();
        CardManager cardManager = new CardManager(cardPath, board);

    }
    public static void main(String[] args) {
        Dice dice = new Dice();
        Players players = new Players(dice);
        Properties properties = new Properties(players);
        PlayGame playGame = new PlayGame(players, dice,properties);
        Player player = new Player(dice);
        playGame.Play();
        cards();

       //String filePathToCards = "C:\\Users\\Lenovo\\Desktop\\Project unit2\\ChancesAndCommunityChestCards";
       //String fileName = "Cards.txt";
       //String cardPath = filePathToCards + File.separator + fileName;

       //// Check if the file exists
       //File file = new File(cardPath);
       //if (!file.exists()) {
       //    System.err.println("File does not exist: " + cardPath);
       //    return;
       //}

       //Board board = new Board(); // You need to create a Board instance
       //CardManager cardManager = new CardManager(cardPath, board);
       //Player player = new Player(dice);

       //// Draw and execute a Chance card
       //Cards drawnChanceCard = cardManager.pickRandomCard("Chance");
       //if (drawnChanceCard != null) {
       //    System.out.println("Chance Card Drawn: " + drawnChanceCard.getDescription());
       //    drawnChanceCard.executeAction(player);
       //}

       //// Draw and execute a Community Chest card
       //Cards drawnCommunityChestCard = cardManager.pickRandomCard("Community Chest");
       //if (drawnCommunityChestCard != null) {
       //    System.out.println("Community Chest Card Drawn: " + drawnCommunityChestCard.getDescription());
       //    drawnCommunityChestCard.executeAction(player);
       //}

    }
}