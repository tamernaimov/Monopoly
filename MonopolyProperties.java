import java.util.Scanner;
public class MonopolyProperties {
    protected Property[] properties;
    Scanner scanner = new Scanner(System.in);

    public MonopolyProperties() {
        properties = new Property[39];
    }
    public Property[] setProperties() {
        properties[1] = new Property("Old Kent Road", "Brown", 60);
        properties[4] = new Property("Whitechapel Road", "Brown", 60);
        properties[6] = new Property("The Angel Islington", "Blue", 100);
        properties[8] = new Property("Euston Road", "Blue", 100);
        properties[9] = new Property("Pentonville Road", "Blue", 120);
        properties[11] = new Property("Pall Mall", "Pink", 140);
        properties[13] = new Property("Whitehall", "Pink", 140);
        properties[14] = new Property("Northumberland Avenue", "Pink", 160);
        properties[16] = new Property("Bow Street", "Orange", 180);
        properties[18] = new Property("Marlborough Street", "Orange", 180);
        properties[19] = new Property("Vine Street", "Orange", 200);
        properties[21] = new Property("Strand", "Red", 220);
        properties[23] = new Property("Fleet Street", "Red", 220);
        properties[24] = new Property("Trafalgar Square", "Red", 240);
        properties[26] = new Property("Leicester Square", "Yellow", 260);
        properties[27] = new Property("Coventry Street", "Yellow", 260);
        properties[29] = new Property("Piccadilly", "Yellow", 280);
        properties[31] = new Property("Regent Street", "Green", 300);
        properties[32] = new Property("Oxford Street", "Green", 300);
        properties[34] = new Property("Bond Street", "Green", 320);
        properties[36] = new Property("Park Lane", "Blue", 350);
        properties[38] = new Property("Mayfair", "Blue", 400);
        return properties;
    }
}