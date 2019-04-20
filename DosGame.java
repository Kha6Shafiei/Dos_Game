import java.util.*;

public class DosGame {

    private Scanner input = new Scanner(System.in);
    private DosDeck deck = new DosDeck();
    private CardStack centerRow = new CardStack();
    private CardStack discardPile = new CardStack();

    private DosPlayer[] players;

    private void play() {
        int currentPlayer = 0;
        initialize();
        while (!isGameOver()) {
            DosPlayer player = players[currentPlayer];
            System.out.println("-------------------------------------------");
            System.out.println(player.getName() + "'s turn.");
            System.out.println("Cards:" + player.getHand());
            System.out.println("Center:" + centerRow);
            System.out.println();

            Set<DosMove> moves = getMoves(player);
            if (moves.size() > 0) {
                printMoves(moves);
                DosMove selectedMove = selectMove(player, moves);
                processMove(player, selectedMove);
            } else {
                System.out.println("No moves.");
                System.out.println("Picking a card and adding a random card to the center row");
                if (deck.hasMoreCards()) {
                    player.addCard(deck.deal());
                }
                if (player.hasMoreCards()) {
                    centerRow.addCard(player.getHand().randomDeal());
                }
            }

            System.out.println("Move over.");
            System.out.println("Points.");
            for (int i = 0; i < players.length; i++) {
                System.out.println(players[i].getName() + ": " + players[i].getPoints());
            }
            System.out.println("-------------------------------------------");
            currentPlayer = (currentPlayer + 1) % players.length;
        }

        Player winner = players[0];
        if (deck.hasMoreCards()) {
            if (!players[0].hasMoreCards()) {
                winner = players[0];
            }
            if (!players[1].hasMoreCards()) {
                winner = players[0];
            }
            if (!players[2].hasMoreCards()) {
                winner = players[0];
            }

        } else {
            if (players[1].getTotalPoints() > winner.getTotalPoints()) {
                winner = players[1];
            }
            if (players[2].getTotalPoints() > winner.getTotalPoints()) {
                winner = players[1];
            }
        }

        System.out.println("The winner is: " + winner.getName());
    }

    private void processMove(DosPlayer player, DosMove move) {
        if (move.score == 0) {
            System.out.println("Double Number Match with Color !!!");
            System.out.println(player.getName() + " gets a bonus point.");
            player.setPoints(1);

            for (int i = 0; i < players.length; i++) {
                if (player != players[i]) {
                    System.out.println(players[i].getName() + " gets an extra card.");
                    if (deck.hasMoreCards()) {
                        players[i].addCard(deck.deal());
                    }
                }
            }
        } else if (move.score == 1) {
            System.out.println("Single Number Match with Color !!!");
            System.out.println(player.getName() + " gets a bonus point.");
            player.setPoints(1);

        } else if (move.score == 2) {
            player.setPoints(0);
            System.out.println("Double Number Match!!!");
        } else {
            player.setPoints(0);
            System.out.println("Single Number Match!!!");
        }

        System.out.print("Cards played: ");
        System.out.print("[" + move.first + "]");
        discardPile.addCard(move.first);
        player.getHand().removeCard(move.first);

        if (move.second != null) {
            System.out.print(", [" + move.second + "]");
            discardPile.addCard(move.second);
            player.getHand().removeCard(move.second);
        }
        System.out.println();

        System.out.print("Center card played: ");
        System.out.println("[" + move.center + "]");
        discardPile.addCard(move.center);
        centerRow.removeCard(move.center);

        System.out.println("Center: " + centerRow);


        if (centerRow.getSize() < 2) {
            System.out.println("Center has less than 2 cards, replenishing.");
            if (deck.hasMoreCards()) {
                centerRow.addCard(deck.deal());
            }
            System.out.println("Center: " + centerRow);
        }

        if (player.getPoints() > 0) {
            System.out.println("Adding cards to center for bonus points.");
            for (int i = 0; i < player.getPoints(); i++) {
                if (player.getHand().hasMoreCards()) {
                    Card random = player.getHand().randomDeal();
                    if (random != null) {
                        centerRow.addCard(random);
                    }
                }
            }
            System.out.println("Center: " + centerRow);
        }
        System.out.println();
    }

    private DosMove selectMove(DosPlayer player, Set<DosMove> moves) {
        int sel = -1;
        ArrayList<DosMove> movesList = new ArrayList<>(moves);
        while (true) {
            System.out.println("Enter the move you want to choose: (1-" + moves.size() + ")");
            sel = input.nextInt();
            if (sel < 1 || sel > moves.size()) {
                System.out.println("Invalid input");
                continue;
            }

            return movesList.get(sel - 1);
        }
    }

    private void printMoves(Set<DosMove> moves) {
        int i = 1;
        for (DosMove move : moves) {
            System.out.print(i);
            System.out.print(". ");

            if (move.score <= 1) {
                System.out.print("[BONUS] ");
            }

            if (move.numCards == 2) {
                System.out.print("[" + move.first + "], ");
                System.out.print("[" + move.second + "] ");
            } else {
                System.out.print("[" + move.first + "] ");
            }

            System.out.print(" ->  matches [" + move.center + "]");
            System.out.println();
            i++;
        }
    }

    private Set<DosMove> getMoves(DosPlayer player) {
        if (!centerRow.hasMoreCards()) {
            return Collections.emptySet();
        }

        TreeSet<DosMove> moves = new TreeSet<>();
        for (int j = 0; j < centerRow.getSize(); j++) {
            Card center = centerRow.getCard(j);
            moves.addAll(player.getHand().getSingleNumberMatches(center));
            moves.addAll(player.getHand().getDoubleNumberMatches(center));
        }
        return moves;
    }

    private boolean isGameOver() {
        for (int i = 0; i < players.length; i++) {
            if (!players[i].hasMoreCards()) {
                return true;
            }
        }
        return !deck.hasMoreCards();
    }

    private void initialize() {
        deck.initCards();
        System.out.println("The generated deck is: ");
        System.out.println(deck);

        players = new DosPlayer[3];
        for (int i = 0; i < players.length; i++) {
            System.out.println("Enter the name of the player " + (i + 1) + ": ");
            String name = input.nextLine();
            players[i] = new DosPlayer(name);
        }

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < players.length; j++) {
                players[j].addCard(deck.deal());
            }
        }
        centerRow.addCard(deck.deal());
        centerRow.addCard(deck.deal());

        displayDeck();

        System.out.println();
        System.out.println("The player details are: ");
        for (int i = 0; i < players.length; i++) {
            System.out.println(players[i]);
            System.out.println();
        }

        displayCenterRow();
        displayDiscardPile();
    }

    private void displayDeck() {
        System.out.println();
        System.out.println("The deck after card distribution is: ");
        System.out.println(deck);
    }

    private void displayDiscardPile() {
        System.out.println();
        System.out.println("The discard pile: ");
        System.out.println(discardPile);
    }

    private void displayCenterRow() {
        System.out.println();
        System.out.println("The center row cards: ");
        System.out.println(centerRow);
    }

    public static void main(String[] args) {
        DosGame dosGame = new DosGame();
        dosGame.play();
    }
}
