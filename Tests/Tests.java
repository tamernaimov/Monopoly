import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static javax.management.Query.times;
import static org.junit.Assert.*;
public class Tests {
    //board test
    @Test
    public void testGetPositionName() {
        Board board = new Board();
        assertEquals("GO", board.getPositionName(Board.GO_POSITION));
        assertEquals("WHITECHAPEL \n ROAD \n $50", board.getPositionName(3));
    }

    @Test
    public void testInitializeBoard() {
        Board board = new Board();
        assertEquals("GO", board.getBoardPositions().get(Board.GO_POSITION));
        assertEquals("OLD KENT \nROAD \n$60", board.getBoardPositions().get(1));
    }

    @Test
    public void testGetPositionIndexByName() {
        Board board = new Board();
        assertEquals(Board.GO_POSITION, board.getPositionIndexByName("GO"));
        assertEquals(3, board.getPositionIndexByName("WHITECHAPEL \n ROAD \n $50"));
    }
    //cardManager test
    @Test
    public void testReadCardsFromFile() {
        Board board = new Board();
        CardManager cardManager = new CardManager("C:\\Users\\Lenovo\\Desktop\\Project unit2\\ChancesAndCommunityChestCards", board);
        List<Cards> chanceCards = cardManager.readCardsFromFile("Chance:");
        List<Cards> communityChestCards = cardManager.readCardsFromFile("Community Chest:");

        assertNotNull(chanceCards);
        assertNotNull(communityChestCards);
    }
    @Test
    public  void testPickRandomCard() {
        Board board = new Board();
        CardManager cardManager = new CardManager("C:\\Users\\Lenovo\\Desktop\\Project unit2\\ChancesAndCommunityChestCards", board);
        Cards randomChanceCard = cardManager.pickRandomCard("Chance");
        Cards randomCommunityChestCard = cardManager.pickRandomCard("Community Chest");

        assertNotNull(randomChanceCard);
        assertNotNull(randomCommunityChestCard);
    }
    //community chest
    @Test
    public void testExecuteActionCommunityChest() {
        Board board = new Board();
        Dice dice = new Dice();
        Player player = new Player(dice);
        CommunityChestCard communityChestCard = new CommunityChestCard(board);
        int initialPosition = player.getPosition();
        communityChestCard.executeAction(player);
        assertNotEquals(initialPosition, player.getPosition());
    }
    //chance
    @Test
    public void testExecuteAction() {
        Board board = new Board();
        Dice dice = new Dice();
        Player player = new Player(dice);
        ChanceCard chanceCard = new ChanceCard(board);
        int initialPosition = player.getPosition();
        chanceCard.executeAction(player);
        assertNotEquals(initialPosition, player.getPosition());
    }
    //dice
    @Test
    public void testDiceScore() {
        Dice dice = new Dice();
        Player player = new Player(dice);
        int score = player.diceScore();
        assertTrue(score >= 2 && score <= 12);
    }
    //house
    @Test
    public void testDecideRent() {
        House house = new House();
        Property testProperty = new Property("Whitechapel Road", "Brown", 60, 3, 4);
        house.properties = new Property[]{testProperty};
        house.houses.add(new House());
        house.decideRent();
        assertEquals("Brown", testProperty.rent);
    }
    @Test
    public void testGetCost() {
        House house = new House();
        Property testProperty = new Property("Pall Mall", "Pink", 140, 11, 11);
        house.props = new MonopolyProperties();
        house.properties = house.props.setProperties();
        house.houses.add(new House());

        int cost = house.getCost(11);
        assertEquals(11, cost);
    }
    //players
    @Test
    public void testGetAllPlayers() {
        List<Player> allPlayers = Players.getAllPlayers();
        assertNotNull(allPlayers);
    }
    //Property
    @Test
    public void testConstructor() {
        Property property = new Property("Old Kent Road", "Brown", 60, 1, 2);
        assertEquals("Old Kent Road", property.getName());
        assertEquals("Brown", property.getColor());
        assertEquals(60,property.getPrice());
        assertEquals(1,property.getPosition());
        assertEquals(2,property.getRent());

    }
    //Monopoly constructor
    @Test
    public void testSetProperties() {
        MonopolyProperties monopolyProperties = new MonopolyProperties();
        Property[] properties = monopolyProperties.setProperties();

        assertNotNull(properties);
        assertEquals(39, properties.length);

        // Add more specific assertions based on your implementation
        assertNotNull(properties[1]);
        assertNotNull(properties[3]);
        assertNotNull(properties[6]);
        assertNotNull(properties[38]);
    }

    @Test
    public void testOwnedPropertiesNoPropertiesBought() {
        MonopolyProperties monopolyProperties = new MonopolyProperties();
        Property[] ownedProperties = monopolyProperties.ownedProperties();

        assertNotNull(ownedProperties);
        assertEquals(0, ownedProperties.length);
    }

    @Test
    public void testOwnedPropertiesSomePropertiesBought() {
        MonopolyProperties monopolyProperties = new MonopolyProperties();
        Property[] properties = monopolyProperties.setProperties();
        properties[1].buyHosue(1);
        properties[6].buyHosue(3);
        properties[21].buyHosue(4);

        Property[] ownedProperties = monopolyProperties.ownedProperties();
        assertNotNull(ownedProperties);
        assertEquals(3, ownedProperties.length);

        assertTrue(ownedProperties[0].isBought);
        assertTrue(ownedProperties[1].isBought);
        assertTrue(ownedProperties[2].isBought);
    }

    //jail
    @Test
    public void testHandleJail_PayFine() {
        Dice dice = new Dice();
        Player player = new Player(dice);
        player.setInJail(true);
        player.setRoundsInJail(0);
        player.setMoney(Jail.JAIL_FINE + 100);

        ByteArrayInputStream in = new ByteArrayInputStream("1\n".getBytes());
        System.setIn(in);

        Jail.handleJail(player);
        System.setIn(System.in);
        assertFalse(player.isInJail());
        assertEquals(0, player.getRoundsInJail());
    }

    @Test
    public void testHandleJail_RollForDouble() {
        Dice dice = new Dice();
        Player player = new Player(dice);
        player.setInJail(true);
        player.setRoundsInJail(0);

        ByteArrayInputStream in = new ByteArrayInputStream("2\n".getBytes());
        System.setIn(in);
        Jail.handleJail(player);

        System.setIn(System.in);
        assertTrue(player.isInJail());
        assertEquals(1, player.getRoundsInJail());
    }

    @Test
    public void testHandleJail_UseGetOutOfJailFreeCard() {
        Dice dice = new Dice();
        Player player = new Player(dice);
        player.setInJail(true);
        player.setRoundsInJail(0);
        player.setHasGetOutOfJailFreeCard(true);

        ByteArrayInputStream in = new ByteArrayInputStream("3\n".getBytes());
        System.setIn(in);
        Jail.handleJail(player);

        System.setIn(System.in);
        assertFalse(player.isInJail());
        assertFalse(player.hasGetOutOfJailFreeCard());
    }
    //player
    @Test
    public void testThrowDice() {
        Dice dice = new Dice();
        Player player = new Player(dice);
        int result = player.diceScore();
        assertTrue(result >= 2 && result <= 12);
    }

    @Test
    public void testMoneyOperations() {
        Dice dice = new Dice();
        Player player = new Player(dice);

        assertEquals(0, player.getMoney());

        player.setMoney(500);
        assertEquals(500, player.getMoney());

        player.setMoney(-200);
        assertEquals(-200, player.getMoney());
    }

    @Test
    public void testPosition() {
        Dice dice = new Dice();
        Player player = new Player(dice);
        assertEquals(0, player.getPosition());

        player.setPosition(5);
        assertEquals(5, player.getPosition());
    }

    @Test
    public void testProperties() {
        Dice dice = new Dice();
        Player player = new Player(dice);
        assertEquals("No Properties!", player.returnProperties());

        Property property = new Property("Test Property", "TestColor", 200, 1, 1);
        player.properties.add(property);
        assertEquals("Test Property", player.returnProperties());

        Property property2 = new Property("Another Property", "AnotherColor", 300, 2, 2);
        player.properties.add(property2);
        assertEquals("Test Property Another Property", player.returnProperties());
    }
    //round
    @Test
    public void testOutcomeResult_PlayerVisitsParkingLot() {
        Dice dice = new Dice();
        Players players = new Players(dice);
        CommunityChestCard communityChestCard = new CommunityChestCard(new Board());
        ChanceCard chanceCard = new ChanceCard(new Board());
        MonopolyProperties monopolyProperties = new MonopolyProperties();
        Round round = new Round(players, communityChestCard, chanceCard, monopolyProperties);
        round.outcomeResult(0);
    }

    @Test
    public  void testRemovePlayer() {
        Dice dice = new Dice();
        Players players = new Players(dice);
        Player player1 = new Player(dice);
        Player player2 = new Player(dice);
        Player player3 = new Player(dice);
        Player player4 = new Player(dice);
        players.setAllPlayers(List.of(new Player[]{player1,player2,player3,player4}));

        PlayGame playGame = new PlayGame(player1, new Board(), new CardManager("C:\\Users\\Lenovo\\Desktop\\Project unit2\\ChancesAndCommunityChestCards", new Board()), players, dice, new MonopolyProperties(), new Round(players, new CommunityChestCard(new Board()), new ChanceCard(new Board()), new MonopolyProperties()));
        assertEquals(2, players.players.length);
        assertSame(player1, players.players[0]);
        assertSame(player3, players.players[1]);
    }
}
