import java.util.ArrayList;
import java.util.List;

public class Board {
    public static final int GO_POSITION = 0;
    public static final int BOARDWALK_POSITION = 39;

    private List<String> boardPositions;

    public Board() {
        initializeBoard();
    }

    public String getPositionName(int position) {

        return boardPositions.get(position);
    }

    private void initializeBoard() {
        boardPositions = new ArrayList<>();

        boardPositions.add("GO");
        boardPositions.add("OLD KENT \nROAD \n$60");
        boardPositions.add("COMMUNITY CHEST");
        boardPositions.add("WHITECHAPEL \n ROAD \n $50");
        boardPositions.add("INCOME\n TAX \n $100");
        boardPositions.add("KING CROSS \n STATION \n $200");
        boardPositions.add("THE ANGEL \n ISLINGTON \n $100");
        boardPositions.add("CHANCE");
        boardPositions.add("EUSTON \n ROAD \n $100");
        boardPositions.add("PENTOVILLE \n ROAD \n $120");
        boardPositions.add("IN JAIL\n JUST VISITING");
        boardPositions.add("PALL\n MALL\n $140");
        boardPositions.add("ELECTRIC \n COMPANY \n $150");
        boardPositions.add("WHITEHALL \n $140");
        boardPositions.add("NORTHUMBER \n LAND AVENUE \n $160");
        boardPositions.add("MARYLEBONE \n STATION \n $200");
        boardPositions.add("BOW \n STREET \n $180");
        boardPositions.add("COMMUNITY CHEST");
        boardPositions.add("MARLBOROUGH \n STREET \n $180");
        boardPositions.add("VINE \n STREET \n $200");
        boardPositions.add("FREE \n PARKING");
        boardPositions.add("STRAND \n $200");
        boardPositions.add("CHANCE");
        boardPositions.add("FLEET \n STREET \n $220");
        boardPositions.add("TRAFALGAR \n SQUARE \n $240");
        boardPositions.add("FENCHURCH \n STATION \n $200");
        boardPositions.add("LEICESTER \n SQUARE \n $260");
        boardPositions.add("COVENTRY \n STREET \n $260");
        boardPositions.add("WATER \n WORKS \n $150");
        boardPositions.add("PICCADILLY \n $150");
        boardPositions.add("GO TO JAIL!");
        boardPositions.add("REGENT \n STREET \n $300");
        boardPositions.add("OXFORD \n STREET \n $300");
        boardPositions.add("COMMUNITY CHEST");
        boardPositions.add("BOND STREET \n $320");
        boardPositions.add("LIVERPOOL ST \n STATION \n $200");
        boardPositions.add("CHANCE");
        boardPositions.add("PARK \n LANE \n $350");
        boardPositions.add("SUPER \n TAX \n $100");
        boardPositions.add("MAYFAIR \n $400");

    }

    public int getPositionIndexByName(String targetPosition) {
        return boardPositions.indexOf(targetPosition);
    }

    public List<String> getBoardPositions() {
        return boardPositions;
    }
}