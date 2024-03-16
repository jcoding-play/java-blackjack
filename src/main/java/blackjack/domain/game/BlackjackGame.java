package blackjack.domain.game;

import blackjack.domain.card.Card;
import blackjack.domain.participant.Dealer;
import blackjack.domain.participant.Player;
import blackjack.domain.participant.Players;
import blackjack.utils.Constants;

public class BlackjackGame {
    private final Dealer dealer;
    private final Players players;

    public BlackjackGame(final Dealer dealer, final Players players) {
        this.dealer = dealer;
        this.players = players;
    }

    public void start() {
        dealer.shuffleCards();

        dealInitialCards();
    }

    private void dealInitialCards() {
        for (int i = 0; i < Constants.INITIAL_CARD_COUNT; i++) {
            dealCardToDealer();
            dealCardToPlayers();
        }
    }

    public void dealCardToDealer() {
        dealer.receiveCard(pickCard());
    }

    private void dealCardToPlayers() {
        players.receiveCardFrom(dealer);
    }

    public void dealCardTo(final Player player) {
        player.receiveCard(pickCard());
    }

    private Card pickCard() {
        return dealer.pickCard();
    }

    public GameResult compareDealerAndPlayers() {
        final GameResult gameResult = new GameResult();

        for (int playerIndex = 0; playerIndex < players.count(); playerIndex++) {
            final Player player = players.findPlayerByIndex(playerIndex);
            gameResult.compare(player, dealer);
        }

        return gameResult;
    }
}
