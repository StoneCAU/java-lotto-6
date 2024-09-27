package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.global.config.LottoConfig.*;

public class LottoService {
    public static List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM.getValue(), MAX_LOTTO_NUM.getValue(), NUMBER_OF_PICKS.getValue());
    }

    public static Lottos convertToLottos(List<List<Integer>> randomNumbersList) {
        List<Lotto> lottoList = convertToLottoList(randomNumbersList);
        return Lottos.createLottos(lottoList);
    }

    private static List<Lotto> convertToLottoList(List<List<Integer>> randomNumbersList) {
        return randomNumbersList.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

}
