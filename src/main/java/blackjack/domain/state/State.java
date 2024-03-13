package blackjack.domain.state;

import blackjack.domain.card.Card;

public interface State {

    State draw(Card card);

    int calculateScore();
}
