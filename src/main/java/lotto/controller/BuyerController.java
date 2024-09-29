package lotto.controller;

import lotto.domain.Buyer;
import lotto.global.exception.LottoException;
import lotto.global.handler.ExceptionHandler;
import lotto.view.input.InputView;

import static java.lang.String.format;
import static lotto.global.config.LottoConfig.LOTTO_COST;
import static lotto.global.exception.ErrorMessage.COST_ERROR_MESSAGE;
import static lotto.global.exception.ErrorMessage.NON_DIGIT_COST_MESSAGE;
import static lotto.view.output.OutputMessage.ASK_PURCHASE_PRICE_MESSAGE;
import static lotto.view.output.OutputMessage.PURCHASE_INFORMATION_MESSAGE;
import static lotto.view.output.OutputView.*;

public class BuyerController {
    public static Buyer requestCost() {
        return ExceptionHandler.execute(BuyerController::purchase);
    }

    private static Buyer purchase() {
        PrintStaticMessage(ASK_PURCHASE_PRICE_MESSAGE);

        String input = InputView.Input();
        int cost;

        if(!isDigit(input)) throw new LottoException(NON_DIGIT_COST_MESSAGE);

        cost = Integer.parseInt(input);

        if (!isValidCost(cost)) throw new LottoException(COST_ERROR_MESSAGE);

        PrintNewLine();
        PrintDynamicMessage(format(PURCHASE_INFORMATION_MESSAGE.getMessage(), cost / LOTTO_COST.getValue()));

        return Buyer.createBuyer(cost);
    }

    private static boolean isValidCost(int cost) {
        return cost % LOTTO_COST.getValue() == 0;
    }

    private static boolean isDigit(String input) {
        return input.matches("[0-9]*");
    }

}
