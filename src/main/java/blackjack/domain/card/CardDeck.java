package blackjack.domain.card;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {
    private final List<Card> cardDeck;

    public CardDeck(List<Card> cards) {
        this.cardDeck = new ArrayList<>(cards);
    }

    public void shuffle(CardShuffleStrategy cardShuffleStrategy) {
        cardShuffleStrategy.shuffle(cardDeck);
    }

    public Card draw() {
        if (cardDeck.isEmpty()) {
            throw new IllegalArgumentException("카드덱의 카드를 모두 소진했습니다.");
        }
        return cardDeck.remove(cardDeck.size() - 1);
    }
}
