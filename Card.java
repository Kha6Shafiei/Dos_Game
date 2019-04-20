//********************************************************************
//  Card.java
//
//
//********************************************************************

public class Card {
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
    public final static int JACK = 11;
    public final static int QUEEN = 12;
    public final static int KING = 13;

    public final static int CLUBS = 1;
    public final static int DIAMONDS = 2;
    public final static int HEARTS = 3;
    public final static int SPADES = 4;

    private final static int NUM_FACES = 13;
    private final static int NUM_SUITS = 4;

    protected int face, suit;
    protected String faceName, suitName;

    //-----------------------------------------------------------------
    //  Creates a card of the specified suit and face value.
    //-----------------------------------------------------------------
    public Card(int faceValue, int suitValue) {
        face = faceValue;
        setFaceName();

        suit = suitValue;
        setSuitName();
    }

    //-----------------------------------------------------------------
    //  Sets the string representation of the face using its stored
    //  numeric value.
    //-----------------------------------------------------------------
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
            case JACK:
                faceName = "Jack";
                break;
            case QUEEN:
                faceName = "Queen";
                break;
            case KING:
                faceName = "King";
                break;
        }
    }

    //-----------------------------------------------------------------
    //  Sets the string representation of the suit using its stored
    //  numeric value.
    //-----------------------------------------------------------------
    protected void setSuitName() {
        switch (suit) {
            case CLUBS:
                suitName = "Clubs";
                break;
            case DIAMONDS:
                suitName = "Diamonds";
                break;
            case HEARTS:
                suitName = "Hearts";
                break;
            case SPADES:
                suitName = "Spades";
                break;
        }
    }

    //-----------------------------------------------------------------
    //  Returns the face (numeric value) of this card.
    //-----------------------------------------------------------------
    public int getFace() {
        return face;
    }

    //-----------------------------------------------------------------
    //  Returns the suit (numeric value) of this card.
    //-----------------------------------------------------------------
    public int getSuit() {
        return suit;
    }

    //-----------------------------------------------------------------
    //  Returns the face (string value) of this card.
    //-----------------------------------------------------------------
    public String getFaceName() {
        return faceName;
    }

    //-----------------------------------------------------------------
    //  Returns the suit (string value) of this card.
    //-----------------------------------------------------------------
    public String getSuitName() {
        return suitName;
    }

    //-----------------------------------------------------------------
    //  Returns the string representation of this card, including
    //  both face and suit.
    //-----------------------------------------------------------------
    public String toString() {
        return faceName + " of " + suitName;
    }
}
