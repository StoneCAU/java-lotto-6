package lotto.controller;

import lotto.domain.Lottos;
import lotto.service.LottoService;

import java.util.ArrayList;
import java.util.List;

import static lotto.view.output.OutputView.PrintLottoNumbers;
import static lotto.view.output.OutputView.PrintNewLine;

public class LottoController {
    public static Lottos generateLottos(int purchaseCount) {
       List<List<Integer>> numbersList = new ArrayList<>();

        for (int i = 0; i < purchaseCount; i++) {
            List<Integer> numbers = LottoService.generateRandomNumbers();
            numbersList.add(numbers);
            PrintLottoNumbers(numbers);
        }

        PrintNewLine();

        return LottoService.convertToLottos(numbersList);
    }


}
