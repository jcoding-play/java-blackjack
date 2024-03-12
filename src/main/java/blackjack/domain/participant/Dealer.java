package blackjack.domain.participant;

import blackjack.domain.card.Card;
import blackjack.domain.card.CardDeck;
import blackjack.domain.card.CardShuffleStrategy;

public class Dealer extends Participant {
    private static final String DEFAULT_NAME = "딜러";
    private static final int DEALER_MIN_SCORE_POLICY = 17;

    private final CardDeck cardDeck;
    private final CardShuffleStrategy cardShuffleStrategy;

    public Dealer(CardDeck cardDeck, CardShuffleStrategy cardShuffleStrategy) {
        super(DEFAULT_NAME);
        this.cardDeck = cardDeck;
        this.cardShuffleStrategy = cardShuffleStrategy;
    }

    public Card pickCard() {
        return cardDeck.draw();
    }

    public void shuffleCards() {
        cardDeck.shuffle(cardShuffleStrategy);
    }

    public Card getFirstCardHand() {
        return super.getCardHand().get(0);
    }

    @Override
    public boolean canReceiveCard() {
        return calculateScore() < DEALER_MIN_SCORE_POLICY;
    }
}
