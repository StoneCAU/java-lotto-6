package lotto.global.config;

public enum PrizeConfig {
    FIRST_WINNING_PRIZE(1, 6,2000000000),
    SECOND_WINNING_PRIZE(2,5,30000000),
    THIRD_WINNING_PRIZE(3,5,1500000),
    FOURTH_WINNING_PRIZE(4,4,50000),
    FIFTH_WINNING_PRIZE(5,3,5000),
    NON_WINNING(-1,-1,0);

    private final int price;
    private final int rank;
    private final int count;

    public static int getPriceByRank(int rank) {
        for (PrizeConfig prizeConfig : PrizeConfig.values()) {
            if (prizeConfig.rank == rank) {
                return prizeConfig.price;
            }
        }
        return -1;
    }

    public static int getCountByRank(int rank) {
        for (PrizeConfig prizeConfig : PrizeConfig.values()) {
            if (prizeConfig.rank == rank) {
                return prizeConfig.count;
            }
        }
        return -1;
    }

    PrizeConfig(int rank, int count, int price) {
        this.rank = rank;
        this.count = count;
        this.price = price;
    }
}
