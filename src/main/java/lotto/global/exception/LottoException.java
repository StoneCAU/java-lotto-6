package lotto.global.exception;

public class LottoException extends IllegalArgumentException {
    private static final String PREFIX = "[ERROR]";

    public LottoException(ErrorMessage message) {
         super(String.format("%s %s", PREFIX, message.getMessage()));
    }
}
