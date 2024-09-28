package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.Lottos;
import lotto.domain.Prize;

public class MainController {
    public static void start() {
        Buyer buyer = BuyerController.payment();
        int purchaseCount = BuyerController.purchase(buyer);

        Lottos lottos = LottoController.generateLottos(purchaseCount);

        Prize prize = PrizeController.setWinningNumber();

    }
}
