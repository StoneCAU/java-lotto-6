package lotto.global.handler;

import lotto.global.exception.LottoException;

import java.util.function.Supplier;

import static lotto.view.output.OutputView.PrintErrorMessage;

public class ExceptionHandler {
    public static <T> T execute(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (LottoException exception) {
                PrintErrorMessage(exception.getMessage());
            }
        }
    }

}
