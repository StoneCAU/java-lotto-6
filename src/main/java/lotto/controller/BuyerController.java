package lotto.controller;

import lotto.domain.Buyer;
import lotto.view.input.InputView;

import static java.lang.String.format;
import static lotto.view.output.OutputMessage.ASK_PURCHASE_PRICE_MESSAGE;
import static lotto.view.output.OutputMessage.PURCHASE_INFORMATION_MESSAGE;
import static lotto.view.output.OutputView.*;

public class BuyerController {
    public static Buyer payment() {
        PrintStaticMessage(ASK_PURCHASE_PRICE_MESSAGE);

        int cost = Integer.parseInt(InputView.Input());
        return Buyer.createBuyer(cost);
    }
    public static int purchase(Buyer buyer) {
        int purchaseCount = buyer.purchaseCount;

        PrintNewLine();
        PrintDynamicMessage(format(PURCHASE_INFORMATION_MESSAGE.getMessage(), purchaseCount));

        return purchaseCount;
    }
}
