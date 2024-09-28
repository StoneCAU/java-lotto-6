package lotto.view.output;

public enum OutputMessage {
    ASK_PURCHASE_PRICE_MESSAGE("구입금액을 입력해 주세요."),
    PURCHASE_INFORMATION_MESSAGE("%d개를 구매했습니다."),
    ASK_WINNING_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    ASK_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS_MESSAGE("당첨 통계\n---"),
    WINNING_STATISTICS_DETAILS_MESSAGE("%d개 일치%s - %d개"),
    PROFITABILITY_MESSAGE("총 수익률은 %.1f%%입니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
