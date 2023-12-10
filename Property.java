public class Property {
    protected String name;
    protected String color;
    protected int price;
    protected boolean isBought = false;
    Player[] owner = new Player[1];
    public Property(String name, String color, int price) {
        this.name = name;
        this.color = color;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public String getColor() {
        return color;
    }
    public int getPrice() {
        return price;
    }

}