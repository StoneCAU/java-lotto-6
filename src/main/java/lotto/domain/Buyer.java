package lotto.domain;

import static lotto.global.config.LottoConfig.LOTTO_COST;

public class Buyer {
    private int purchaseCost;
    public int purchaseCount;

    private Buyer(int purchaseCost) {
        purchaseCount = getPurchaseCount(purchaseCost);

        this.purchaseCost = purchaseCost;
    }

    public static Buyer createBuyer(int purchaseCost) {
        return new Buyer(purchaseCost);
    }

    private int getPurchaseCount(int payment) {
        return payment / LOTTO_COST.getValue();
    }
}
