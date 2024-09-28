package lotto.service;

import lotto.domain.*;
import lotto.global.config.PrizeConfig;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;
import static lotto.global.config.LottoConfig.NUMBER_OF_WINNER;
import static lotto.view.output.OutputMessage.PROFITABILITY_MESSAGE;
import static lotto.view.output.OutputMessage.WINNING_STATISTICS_DETAILS_MESSAGE;

public class StatisticsService {
    public static List<String> createStatisticsString(Statistics statistics) {
        List<String> result = new ArrayList<>();
        List<Integer> rank = statistics.getRank();
        float profitability = statistics.getProfitability();

        for(int i=NUMBER_OF_WINNER.getValue();i>=1;i--) {
            int matchCount = PrizeConfig.getCountByRank(i);
            int winningCount = getWinningCount(rank, i);
            String price = convertMoneyFormat(i);
            String message = format(WINNING_STATISTICS_DETAILS_MESSAGE.getMessage(), matchCount, price, winningCount);
            result.add(message);
        }

        String profitabilityMessage = format(PROFITABILITY_MESSAGE.getMessage(), profitability);
        result.add(profitabilityMessage);

        return result;
    }

    public static Statistics computeStatistics(Lottos lottos, Prize prize, Buyer buyer) {
        List<Integer> rank = new ArrayList<>();
        float profitability;

        List<Lotto> lottoList = lottos.getLottos();

        for (Lotto lotto : lottoList) {

            List<Integer> numbers = lotto.getNumbers();

            int count = countMatches(numbers, prize);
            boolean bonus = isBonusNumberMatched(numbers, prize);
            rank.add(findRank(count, bonus));
        }

        profitability = calculateProfitability(buyer, rank);

        return Statistics.createStatistics(rank, profitability);
    }

    private static String convertMoneyFormat(int rank) {
        int price = PrizeConfig.getPriceByRank(rank);
        String str = String.format("%,d", price);

        if(rank == 2) return String.format(", 보너스 볼 일치 (%s원)", str);
        return String.format(" (%s원)", str);
    }

    private static int getWinningCount(List<Integer> rankList, int rank) {
        return (int) rankList.stream()
                .filter(num -> num == rank)
                .count();
    }

    private static float calculateProfitability(Buyer buyer, List<Integer> rank) {
        int purchaseCost = buyer.getPurchaseCost();
        int totalProfit = getTotalProfit(rank);

        float profitability = (float) totalProfit / purchaseCost * 100;

        return profitability;
    }

    private static int getTotalProfit(List<Integer> rank) {
        return rank.stream().mapToInt(i -> PrizeConfig.getPriceByRank(i)).sum();
    }

    private static int findRank(int count, boolean bonus) {
        if (count == 6) return 1;
        if (count == 5 && bonus) return 2;
        if (count == 5) return 3;
        if (count == 4) return 4;
        if (count == 3) return 5;
        return -1;
    }

    private static int countMatches(List<Integer> numbers, Prize prize) {
        List<Integer> winningNumbers = prize.getNumbers();

        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private static boolean isBonusNumberMatched(List<Integer> numbers, Prize prize) {
        int bonusNumber = prize.getBonusNumber();

        return numbers.stream()
                .anyMatch(number -> number == bonusNumber);
    }
}
