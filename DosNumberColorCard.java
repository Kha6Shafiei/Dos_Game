public class DosNumberColorCard extends DosCard {

    public DosNumberColorCard(int faceValue, int suitValue) {
        super(faceValue, suitValue);
    }

    @Override
    protected void setFaceName() {
        switch (face) {
            case ONE:
                faceName = "One";
                break;
            case TWO:
                faceName = "Two";
                break;
            case THREE:
                faceName = "Three";
                break;
            case FOUR:
                faceName = "Four";
                break;
            case FIVE:
                faceName = "Five";
                break;
            case SIX:
                faceName = "Six";
                break;
            case SEVEN:
                faceName = "Seven";
                break;
            case EIGHT:
                faceName = "Eight";
                break;
            case NINE:
                faceName = "Nine";
                break;
            case TEN:
                faceName = "Ten";
                break;
        }
    }

    @Override
    protected void setSuitName() {
        switch (suit) {
            case RED:
                suitName = "Red";
                break;
            case GREEN:
                suitName = "Green";
                break;
            case YELLOW:
                suitName = "Yellow";
                break;
            case BLUE:
                suitName = "Blue";
                break;
        }
    }
}
