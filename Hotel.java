import java.util.ArrayList;

public class Hotel implements PropertyManager{
    MonopolyProperties props;
    Property[] properties;
    House house;
    public Hotel() {
        properties = new Property[39];
        house = new House();
    }
    public void decideRent() {
        for (Property property : properties) {
            if (property.getColor().equals("Brown") || property.getColor().equals("Light Blue")) {
                property.rent = 320;
            }
            if (property.getColor().equals("Pink") || property.getColor().equals("Orange")) {
                property.rent = 640;
            }
            if (property.getColor().equals("Red") || property.getColor().equals("Yellow")) {
                property.rent = 960;
            }
            if (property.getColor().equals("Green") || property.getColor().equals("Dark Blue")) {
                property.rent = 1280;
            }

        }
    }
    public int getCost(int i) {
        properties = props.setProperties();

        if (house.houses.size() == 3) {
            if (properties[i].getName().equals("Brown") || properties[i].getName().equals("Light Blue")) return 200;//will be needed for hotel
            if (properties[i].getName().equals("Pink") || properties[i].getName().equals("Orange")) return 400;//will be needed for hotel
            if (properties[i].getName().equals("Red") || properties[i].getName().equals("Yellow")) return 600;//will be needed for hotel
            if (properties[i].getName().equals("Green") || properties[i].getName().equals("Dark Blue")) return 800;//will be needed for hotel
        }
        return 0;
    }
}
