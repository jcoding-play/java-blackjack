package blackjack.domain.card;

import blackjack.domain.Score;

import java.util.ArrayList;
import java.util.List;

public class CardHand {
    private static final int BLACKJACK_CARD_SIZE = 2;

    private final List<Card> cards;

    public CardHand() {
        this.cards = new ArrayList<>();
    }

    public void receiveCard(final Card card) {
        cards.add(card);
    }

    public Score sumAllScore() {
        final Score totalScore = calculateTotalScore();

        if (hasAce()) {
            return totalScore.addBonusScoreIfNotBust();
        }
        return totalScore;
    }

    private Score calculateTotalScore() {
        return cards.stream()
                .map(Card::getDenomination)
                .map(Denomination::getScore)
                .reduce(Score.initialScore(), Score::sum);
    }

    private boolean hasAce() {
        return cards.stream()
                .anyMatch(Card::isAce);
    }

    public boolean isBlackjack() {
        final int cardSize = cards.size();
        final Score score = sumAllScore();

        return cardSize == BLACKJACK_CARD_SIZE && score.equals(Score.getBlackjackScore());
    }

    public boolean isBust() {
        final Score score = sumAllScore();
        return score.isGreaterThan(Score.getBlackjackScore());
    }
}
