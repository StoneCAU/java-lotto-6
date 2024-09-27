package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.Lottos;

public class MainController {
    public static void start() {
        Buyer buyer = BuyerController.payment();
        int purchaseCount = BuyerController.purchase(buyer);
        Lottos lottos = LottoController.generateLottos(purchaseCount);
    }
}
