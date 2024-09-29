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
        PrintStaticMessage(ASK_WINNING_NUMBER_MESSAGE);
        List<Integer> numbers = PrizeService.parsingNumbers(InputView.Input());

        int bonusNumber = setBonusNumber();

        PrintNewLine();

        return Prize.createPrize(numbers, bonusNumber);
    }

    private static int setBonusNumber() {
        String input;

        PrintNewLine();
        PrintStaticMessage(ASK_BONUS_NUMBER_MESSAGE);

        input = InputView.Input();
        return Integer.parseInt(InputView.Input());
    }
}
