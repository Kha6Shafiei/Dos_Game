public abstract class DosCard extends Card {
    public final static int ONE = 1;
    public final static int TWO = 2;
    public final static int THREE = 3;
    public final static int FOUR = 4;
    public final static int FIVE = 5;
    public final static int SIX = 6;
    public final static int SEVEN = 7;
    public final static int EIGHT = 8;
    public final static int NINE = 9;
    public final static int TEN = 10;
    public final static int WILD = 0;


    public final static int NONE = 0;
    public final static int BLUE = 1;
    public final static int GREEN = 2;
    public final static int RED = 3;
    public final static int YELLOW = 4;

    protected DosCard(int faceValue, int suitValue) {
        super(faceValue, suitValue);
    }
}
