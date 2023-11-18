public class Main {
    public static void main(String[] args) {
        Dice dice = new Dice();
        Players players = new Players(dice);
        PlayGame playGame = new PlayGame(players, dice);
        playGame.Play();
    }
}