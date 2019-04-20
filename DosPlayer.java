public class DosPlayer extends Player {

    private final DosHand hand;

    public DosPlayer(String name) {
        super(name);

        this.hand = new DosHand();
    }

    public void addCard(Card card) {
        hand.addCard(card);
    }

    @Override
    public String toString() {
        String result = "\n" + getName() + ": Running total: " + getTotalPoints() + "\n\t" + "Hand: " + hand + "\n";
        return result;
    }

    public boolean hasMoreCards() {
        return hand.hasMoreCards();
    }

    public DosHand getHand() {
        return hand;
    }
}
