package lotto.global.config;

public enum LottoConfig {
    LOTTO_COST(1000),

    MIN_LOTTO_NUM(1),
    MAX_LOTTO_NUM(45),

    NUMBER_OF_PICKS(6),
    NUMBER_OF_BONUS(1);

    private final int value;

    LottoConfig(int value) {
        this.value = value;
    }

}
