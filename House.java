import java.util.ArrayList;

public class House {
    protected ArrayList<House> houses;
    MonopolyProperties props;
    Property[] properties;
    protected int price = 0;

    public House() {
        houses = new ArrayList<>();
        properties = new Property[39];
    }

    public void decideRent() {
        for (Property property : properties) {
            if (property.getColor().equals("Brown") || property.getColor().equals("Light Blue")) {
                property.rent = property.rent + ((houses.size() + 1) * 50);
            }
            if (property.getColor().equals("Pink") || property.getColor().equals("Orange")) {
                property.rent = property.rent + ((houses.size() + 1) * 100);
            }
            if (property.getColor().equals("Red") || property.getColor().equals("Yellow")) {
                property.rent = property.rent + ((houses.size() + 1) * 150);
            }
            if (property.getColor().equals("Green") || property.getColor().equals("Dark Blue")) {
                property.rent = property.rent + ((houses.size() + 1) * 200);
            }

        }
    }

    public int getCost(int i) {
        properties = props.setProperties();
        if (houses.size() == 0) {
            if (properties[i].getName().equals("Brown") || properties[i].getName().equals("Light Blue")) return 50;
            if (properties[i].getName().equals("Pink") || properties[i].getName().equals("Orange")) return 100;
            if (properties[i].getName().equals("Red") || properties[i].getName().equals("Yellow")) return 150;
            if (properties[i].getName().equals("Green") || properties[i].getName().equals("Dark Blue")) return 200;
        } else if (houses.size() == 1) {
            if (properties[i].getName().equals("Brown") || properties[i].getName().equals("Light Blue")) return 100;
            if (properties[i].getName().equals("Pink") || properties[i].getName().equals("Orange")) return 200;
            if (properties[i].getName().equals("Red") || properties[i].getName().equals("Yellow")) return 300;
            if (properties[i].getName().equals("Green") || properties[i].getName().equals("Dark Blue")) return 400;
        } else if (houses.size() == 2) {
            if (properties[i].getName().equals("Brown") || properties[i].getName().equals("Light Blue")) return 150;
            if (properties[i].getName().equals("Pink") || properties[i].getName().equals("Orange")) return 300;
            if (properties[i].getName().equals("Red") || properties[i].getName().equals("Yellow")) return 450;
            if (properties[i].getName().equals("Green") || properties[i].getName().equals("Dark Blue")) return 600;
        } else if (houses.size() == 3) {
            if (properties[i].getName().equals("Brown") || properties[i].getName().equals("Light Blue")) return 200;
            if (properties[i].getName().equals("Pink") || properties[i].getName().equals("Orange")) return 400;
            if (properties[i].getName().equals("Red") || properties[i].getName().equals("Yellow")) return 600;
            if (properties[i].getName().equals("Green") || properties[i].getName().equals("Dark Blue")) return 800;
        }
        return 0;
    }

}


