public class DosMove implements Comparable<DosMove> {

    Integer score = Integer.MAX_VALUE;

    Card center;
    Card first;
    Card second;

    Integer numCards = 0;

    @Override
    public int compareTo(DosMove o) {
        int scoreCompare = score.compareTo(o.score);
        if (scoreCompare != 0) {
            return scoreCompare;
        }

        int numCardsCompare = o.numCards.compareTo(numCards);
        if (numCardsCompare != 0) {
            return numCardsCompare;
        }

        return hasWildCards().compareTo(o.hasWildCards());
    }

    private Integer hasWildCards() {
        if (center.getFace() <= 0 || first.getFace() <= 0 || (second != null && second.getFace() <= 0)) {
            return 1;
        }
        return 0;
    }
}
