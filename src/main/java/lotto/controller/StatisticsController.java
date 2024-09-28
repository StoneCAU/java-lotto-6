package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.Lottos;
import lotto.domain.Prize;
import lotto.domain.Statistics;
import lotto.service.StatisticsService;

import java.util.List;

import static lotto.view.output.OutputMessage.WINNING_STATISTICS_MESSAGE;
import static lotto.view.output.OutputView.PrintStaticMessage;
import static lotto.view.output.OutputView.PrintStatisticsMessage;

public class StatisticsController {
    public static void getStatistics(Lottos lottos, Prize prize, Buyer buyer) {
        PrintStaticMessage(WINNING_STATISTICS_MESSAGE);

        Statistics statistics = StatisticsService.computeStatistics(lottos, prize, buyer);

        List<String> result = StatisticsService.createStatisticsString(statistics);

        PrintStatisticsMessage(result);
    }
}
