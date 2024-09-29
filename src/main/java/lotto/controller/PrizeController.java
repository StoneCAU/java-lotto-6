package lotto.controller;

import lotto.domain.Prize;
import lotto.global.handler.ExceptionHandler;
import lotto.service.PrizeService;
import lotto.view.input.InputView;

import java.util.List;

import static lotto.view.output.OutputMessage.ASK_BONUS_NUMBER_MESSAGE;
import static lotto.view.output.OutputMessage.ASK_WINNING_NUMBER_MESSAGE;
import static lotto.view.output.OutputView.PrintNewLine;
import static lotto.view.output.OutputView.PrintStaticMessage;

public class PrizeController {
    public static Prize pickWinningNumber() {
        return ExceptionHandler.execute(PrizeController::setWinningNumber);
    }

    private static Prize setWinningNumber() {
        List<Integer> numbers;

        PrintStaticMessage(ASK_WINNING_NUMBER_MESSAGE);
        numbers = PrizeService.parsingNumbers(InputView.Input());

        PrintNewLine();

        return ExceptionHandler.execute(() -> setBonusNumber(numbers));
    }

    private static Prize setBonusNumber(List<Integer> numbers) {
        String input;
        int bonusNumber;

        PrintStaticMessage(ASK_BONUS_NUMBER_MESSAGE);

        input = InputView.Input();
        bonusNumber = PrizeService.validateBonusNumber(numbers, input);

        return Prize.createPrize(numbers, bonusNumber);
    }
}
