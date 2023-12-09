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
        PlayGame playGame = new PlayGame(players, dice);
        playGame.Play();
        Player player = new Player(dice);
        cards();
    }
}