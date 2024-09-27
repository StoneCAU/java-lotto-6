package lotto.controller;

import lotto.domain.Buyer;

public class MainController {
    public static void start() {
        Buyer buyer = BuyerController.payment();
    }
}
