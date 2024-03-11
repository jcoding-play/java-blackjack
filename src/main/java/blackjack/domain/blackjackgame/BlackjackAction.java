package blackjack.domain.blackjackgame;

import java.util.Arrays;

public enum BlackjackAction {
    HIT("y"),
    STAY("n");

    private static final BlackjackAction[] VALUES = values();
    private final String expression;

    BlackjackAction(String expression) {
        this.expression = expression;
    }

    public static BlackjackAction from(String expression) {
        return Arrays.stream(VALUES)
                .filter(action -> action.isMatchExpression(expression))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 입력 값입니다."));
    }

    private boolean isMatchExpression(String expression) {
        return this.expression.equals(expression);
    }

    public boolean isHit() {
        return this == HIT;
    }

    public String getExpression() {
        return this.expression;
    }
}
