package blackjack.domain.participant;

import blackjack.domain.card.Card;
import blackjack.domain.card.CardDeck;
import blackjack.domain.card.Denomination;
import blackjack.domain.card.Emblem;
import org.junit.jupiter.api.Test;

import static blackjack.fixture.CardFixture.전체_카드;
import static blackjack.fixture.CardFixture.카드;
import static org.assertj.core.api.Assertions.assertThat;

class DealerTest {
    @Test
    void 카드_덱에서_카드를_뽑는다() {
        CardDeck cardDeck = new CardDeck(전체_카드());
        Dealer dealer = new Dealer(cardDeck, cards -> {
        });

        Card card = dealer.pickCard();

        assertThat(card).isEqualTo(new Card(Denomination.KING, Emblem.DIAMOND));
    }

    @Test
    void 점수의_합이_17보다_작으면_카드를_더_받아야_한다() {
        CardDeck cardDeck = new CardDeck(전체_카드());
        Dealer dealer = new Dealer(cardDeck, cards -> {
        });

        dealer.add(카드(Denomination.TEN));
        dealer.add(카드(Denomination.SIX));

        boolean result = dealer.isNecessaryMoreCard();
        assertThat(result).isTrue();
    }

    @Test
    void 점수의_합이_17이상이면_카드를_더_받을_수_없다() {
        CardDeck cardDeck = new CardDeck(전체_카드());
        Dealer dealer = new Dealer(cardDeck, cards -> {
        });

        dealer.add(카드(Denomination.NINE));
        dealer.add(카드(Denomination.EIGHT));

        boolean result = dealer.isNecessaryMoreCard();
        assertThat(result).isFalse();
    }
}
