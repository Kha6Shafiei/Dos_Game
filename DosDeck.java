public class DosDeck extends CardStack {

    public void initCards() {
        addColorCards(1, 3);
        addColorCards(3, 3);
        addColorCards(4, 3);
        addColorCards(5, 3);
        addColorCards(6, 2);
        addColorCards(7, 2);
        addColorCards(8, 2);
        addColorCards(9, 2);
        addColorCards(10, 2);
        addWildColorCards(2);
        addWildDosCards(12);
        shuffle();
    }

    private void shuffle() {
        for (int i = 0; i < 5000; i++) {
            Card card = randomDeal();
            addCard(card);
        }
    }

    private void addWildDosCards(int number) {
        for (int i = 0; i < number; i++) {
            addCard(new DosWildCard());
        }
    }

    private void addWildColorCards(int number) {
        for (int i = 0; i < number; i++) {
            addCard(new DosColorWildCard(DosCard.BLUE));
            addCard(new DosColorWildCard(DosCard.GREEN));
            addCard(new DosColorWildCard(DosCard.RED));
            addCard(new DosColorWildCard(DosCard.YELLOW));
        }
    }

    private void addColorCards(int value, int number) {
        for (int i = 0; i < number; i++) {
            addCard(new DosNumberColorCard(value, DosCard.BLUE));
            addCard(new DosNumberColorCard(value, DosCard.GREEN));
            addCard(new DosNumberColorCard(value, DosCard.RED));
            addCard(new DosNumberColorCard(value, DosCard.YELLOW));
        }
    }
}
