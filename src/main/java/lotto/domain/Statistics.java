package lotto.domain;

import java.util.List;

public class Statistics {
    private static List<Integer> rank;
    private static float profitability;

    private Statistics(List<Integer> rank, float profitability) {
        this.rank = rank;
        this.profitability = profitability;
    }

    public static Statistics createStatistics(List<Integer> rank, float profitability) {
        return new Statistics(rank, profitability);
    }

    public static List<Integer> getRank() {
        return rank;
    }

    public static float getProfitability() {
        return profitability;
    }
}
