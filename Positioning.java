public class Positioning {
    private Dice dice;
    public Positioning() {
        dice = new Dice();
    }
    public int getPosition() {
        return dice.getScore();
    }
    //inteface should be added and override this method:
    public void throwDice() {
        dice.throwDice();
    }
}
