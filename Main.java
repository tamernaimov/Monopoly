import java.io.File;
import java.util.Scanner;

public class Main {


    public static void cards() {

        String filePathToCards = whoIsWorking();
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

    public static String whoIsWorking() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("who is working?");
        String answer = scanner.nextLine();
        if (answer.equals("Tamer")) {
            return "C:\\Users\\Tamer\\IdeaProjects\\Monopoly";
        } else {
            return "C:\\Users\\Lenovo\\Desktop\\Project unit2\\ChancesAndCommunityChestCards";
        }
    }

    public static void main(String[] args) {
        Dice dice = new Dice();
        Players players = new Players(dice);
        Player player = new Player(dice);
        Board board = new Board();
        MonopolyProperties monopolyProperties = new MonopolyProperties();
        CommunityChestCard communityChestCard = new CommunityChestCard(board);
        ChanceCard chanceCard = new ChanceCard(board);

        Round round = new Round(players, communityChestCard, chanceCard, monopolyProperties);

        String filePathToCards = whoIsWorking();
        String fileName = "Cards.txt";
        String cardPath = filePathToCards + File.separator + fileName;
        CardManager cardManager = new CardManager(cardPath, board);

        PlayGame playGame = new PlayGame(player, board, cardManager, players, dice, monopolyProperties, round);

        playGame.Play();
        cards();
    }
}