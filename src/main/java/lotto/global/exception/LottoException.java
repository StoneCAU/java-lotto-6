package lotto.global.exception;

public class LottoException extends IllegalArgumentException {
    private static final String PREFIX = "[ERROR]";

    public LottoException(String message) {
         super(String.format("%s %s", PREFIX, message));
    }
}
