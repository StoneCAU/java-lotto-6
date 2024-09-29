package lotto.global.exception;

import static java.lang.String.format;
import static lotto.global.config.LottoConfig.*;

public enum ErrorMessage {
    COST_ERROR_MESSAGE(format("구입 금액은 로또 1장 가격(%d)으로 나누어 떨어져야합니다.", LOTTO_COST.getValue())),
    NON_DIGIT_COST_MESSAGE("구입 금액은 숫자만 입력할 수 있습니다."),

    INVALID_WINNING_NUMBER_MESSAGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NON_DIGIT_ERROR_MESSAGE("로또 번호는 숫자만 입력할 수 있습니다."),

    INVALID_DELIMITER_MESSAGE("당첨 번호는 '',''로 구분되어 입력되어야 합니다."),
    DELIMITER_ERROR_MESSAGE("구분자('','')는 숫자 사이에 여러번 입력할 수 없습니다."),
    INVALID_PICK_NUMBER_MESSAGE(format("%d개의 숫자만 입력할 수 있습니다.", NUMBER_OF_PICKS.getValue())),
    DUPLICATED_MESSAGE("중복된 당첨 번호는 입력할 수 없습니다."),

    DUPLICATED_BONUS_NUMBER_MESSAGE("당첨 번호와 중복되는 보너스 번호는 입력할 수 없습니다."),
    INVALID_PICK_BONUS_MESSAGE(format("보너스 번호는 %d개만 입력할 수 있습니다.", NUMBER_OF_BONUS.getValue()));

    public String getMessage() {
        return message;
    }

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }
}
