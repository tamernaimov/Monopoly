import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardManager {
    private String cardFilePath;
    private Board board;

    public CardManager(String filePath, Board board) {
        this.cardFilePath = filePath;
        this.board = board;
    }

    public List<Cards> readCardsFromFile(String prefix) {
        List<Cards> cards = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(cardFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(prefix)) {
                    Cards card = createCardFromDescription(line.substring(prefix.length()));
                    cards.add(card);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        return cards;
    }

    private Cards createCardFromDescription(String description) {
        if (description.startsWith("Chance:")) {
            return new ChanceCard(board);
        } else if (description.startsWith("Community Chest:")) {
            return new CommunityChestCard(board);
        } else {
            return null;
        }
    }

    public Cards pickRandomCard(String cardType) {
        List<Cards> cards;
        if ("Chance".equalsIgnoreCase(cardType)) {
            cards = readCardsFromFile("Chance:");
        } else if ("Community Chest".equalsIgnoreCase(cardType)) {
            cards = readCardsFromFile("Community Chest:");
        } else {
            return null;
        }

        if (!cards.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(cards.size());
            return cards.get(randomIndex);
        } else {
            return null;
        }
    }
}