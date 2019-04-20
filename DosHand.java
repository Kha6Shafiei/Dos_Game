import java.util.ArrayList;

public class DosHand extends DosDeck {

    public ArrayList<DosMove> getDoubleNumberMatches(Card center) {
        ArrayList<DosMove> doubleMoves = new ArrayList<>();
        for (int i = 0; i < getSize(); i++) {
            for (int k = i + 1; k < getSize(); k++) {
                Card fCard = getCard(i);
                Card sCard = getCard(k);

                DosMove dosMove = new DosMove();
                dosMove.center = center;
                dosMove.first = fCard;
                dosMove.second = sCard;
                dosMove.numCards = 2;

                if (CardHelper.matchesNumber(center, fCard, sCard)) {
                    dosMove.score = 2;
                    if (CardHelper.matchesColor(center, fCard, sCard)) {
                        dosMove.score = 0;
                    }
                    doubleMoves.add(dosMove);
                }
            }
        }
        return doubleMoves;
    }

    public ArrayList<DosMove> getSingleNumberMatches(Card center) {
        ArrayList<DosMove> singleMoves = new ArrayList<>();
        for (int i = 0; i < getSize(); i++) {
            Card card = getCard(i);
            DosMove dosMove = new DosMove();
            dosMove.center = center;
            dosMove.first = card;
            dosMove.numCards = 1;

            if (CardHelper.matchesNumber(center, card)) {
                dosMove.score = 3;
                if (CardHelper.matchesColor(center, card)) {
                    dosMove.score = 1;
                }
                singleMoves.add(dosMove);
            }
        }
        return singleMoves;
    }
}
