package lotto.domain;

import static lotto.global.config.LottoConfig.LOTTO_COST;

public class Buyer {
    private int purchaseCost;
    public int purchaseCount;

    private Buyer(int purchaseCost) {
        getPurchaseCount();

        this.purchaseCost = purchaseCost;
    }

    public static Buyer createBuyer(int purchaseCost) {
        return new Buyer(purchaseCost);
    }

    private int getPurchaseCount() {
        return purchaseCost / LOTTO_COST.getValue();
    }
}
