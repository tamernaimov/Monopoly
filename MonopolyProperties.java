import java.util.Arrays;
import java.util.Scanner;

public class MonopolyProperties {
    protected Property[] properties;
    Scanner scanner = new Scanner(System.in);

    public MonopolyProperties() {
        properties = new Property[39];
    }

    public Property[] setProperties() {
        properties[1] = new Property("Old Kent Road", "Brown", 60, 1, 2);
        properties[3] = new Property("Whitechapel Road", "Brown", 60, 3, 4);
        properties[6] = new Property("The Angel Islington", "Light Blue", 100, 6, 6);
        properties[8] = new Property("Euston Road", "Light Blue", 100, 8, 8);
        properties[9] = new Property("Pentonville Road", "Light Blue", 120, 9, 9);
        properties[11] = new Property("Pall Mall", "Pink", 140, 11, 11);
        properties[13] = new Property("Whitehall", "Pink", 140, 13, 13);
        properties[14] = new Property("Northumberland Avenue", "Pink", 160, 14, 14);
        properties[16] = new Property("Bow Street", "Orange", 180, 16, 16);
        properties[18] = new Property("Marlborough Street", "Orange", 180, 18, 18);
        properties[19] = new Property("Vine Street", "Orange", 200, 19, 19);
        properties[21] = new Property("Strand", "Red", 220, 21, 21);
        properties[23] = new Property("Fleet Street", "Red", 220, 23, 23);
        properties[24] = new Property("Trafalgar Square", "Red", 240, 24, 24);
        properties[26] = new Property("Leicester Square", "Yellow", 260, 26, 26);
        properties[27] = new Property("Coventry Street", "Yellow", 260, 27, 28);
        properties[29] = new Property("Piccadilly", "Yellow", 280, 29, 31);
        properties[31] = new Property("Regent Street", "Green", 300, 31, 31);
        properties[32] = new Property("Oxford Street", "Green", 300, 32, 32);
        properties[34] = new Property("Bond Street", "Green", 320, 34, 34);
        properties[36] = new Property("Park Lane", "Dark Blue", 350, 36, 36);
        properties[38] = new Property("Mayfair", "Dark Blue", 400, 38, 38);
        return properties;
    }

    public Property[] ownedProperties() {
        Property[] props = setProperties();
        Property[] ownedProperties = new Property[39];
        int count = 0;

        for (Property property : props) {
            if (property != null && property.isBought) {
                ownedProperties[count++] = property;
            }
        }

        return Arrays.copyOfRange(ownedProperties, 0, count);
    }
}