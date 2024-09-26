package lotto.global.config;

public enum PrizeConfig {
    NUMBER_OF_WINNER(5),

    FIRST_WINNING_PRIZE(2000000000),
    SECOND_WINNING_PRIZE(30000000),
    THIRD_WINNING_PRIZE(1500000),
    FOURTH_WINNING_PRIZE(50000),
    FIFTH_WINNING_PRIZE(5000);

    private final int value;

    PrizeConfig(int value) {
        this.value = value;
    }
}
