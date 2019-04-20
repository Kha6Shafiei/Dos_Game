public class DosColorWildCard extends DosCard {

    public DosColorWildCard(int suitValue) {
        super(WILD, suitValue);
    }

    @Override
    protected void setFaceName() {
        faceName = "WILD";
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
