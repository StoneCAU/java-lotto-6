package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.Lottos;
import lotto.domain.Prize;

public class MainController {
    public static void start() {
        Buyer buyer = BuyerController.requestCost();

        Lottos lottos = LottoController.generateLottos(buyer.purchaseCount);

        Prize prize = PrizeController.pickWinningNumber();

        StatisticsController.getStatistics(lottos, prize, buyer);
    }
}
