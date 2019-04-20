public class CardHelper {

    public static boolean matchesNumber(Card center, Card card) {
        if (card.getFace() <= 0) {
            return true;
        }

        if (center.getFace() <= 0) {
            return true;
        }

        return card.getFace() == center.getFace();
    }

    public static boolean matchesColor(Card center, Card card) {
        if (card.getSuit() <= 0 || center.getSuit() <= 0) {
            return true;
        }
        return card.getSuit() == center.getSuit();
    }

    public static boolean matchesNumber(Card center, Card firstCard, Card secondCard) {
        int centerFace = center.getFace();
        int firstFace = firstCard.getFace();
        int secondFace = secondCard.getFace();

        if (centerFace <= 0) {
            return (firstFace + secondFace) <= 10;
        }

        if (firstFace <= 0) {
            return (centerFace - secondFace) <= 10;
        }

        if (secondFace <= 0) {
            return (centerFace - firstFace) <= 10;
        }

        return centerFace == (firstFace + secondFace);
    }

    public static boolean matchesColor(Card center, Card firstCard, Card secondCard) {
        int centerSuit = center.getSuit();
        int firstSuit = firstCard.getSuit();
        int secondSuit = secondCard.getSuit();

        if (centerSuit <= 0) {
            return firstSuit <= 0 || secondSuit <= 0 || firstSuit == secondSuit;
        }

        if (firstSuit <= 0) {
            return secondSuit <= 0 || secondSuit == centerSuit;
        }

        if (secondSuit <= 0) {
            return firstSuit == centerSuit;
        }

        return firstSuit == centerSuit && secondSuit == centerSuit;
    }
}
