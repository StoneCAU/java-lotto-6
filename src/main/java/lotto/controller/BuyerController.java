package lotto.controller;

import lotto.domain.Buyer;
import lotto.view.input.InputView;

import static lotto.view.output.OutputMessage.ASK_PURCHASE_PRICE_MESSAGE;
import static lotto.view.output.OutputView.PrintStaticMessage;

public class BuyerController {
    public static Buyer payment() {
        PrintStaticMessage(ASK_PURCHASE_PRICE_MESSAGE);

        int cost = Integer.getInteger(InputView.Input());
        return Buyer.createBuyer(cost);
    }
}
