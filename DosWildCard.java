public class DosWildCard extends DosCard {

    public DosWildCard() {
        super(WILD, NONE);
    }

    @Override
    protected void setFaceName() {
        faceName = "Two";
    }

    @Override
    protected void setSuitName() {
        suitName = "Wild";
    }
}
