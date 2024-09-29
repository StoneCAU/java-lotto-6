package lotto.service;

import lotto.global.exception.LottoException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.global.config.LottoConfig.NUMBER_OF_PICKS;
import static lotto.global.exception.ErrorMessage.*;

public class PrizeService {
    public static List<Integer> parsingNumbers(String input) {
        if (isContainedEmpty(input)) throw new LottoException(EMPTY_CONTAINS_ERROR_MESSAGE);
        if (isContainedLetter(input)) throw new LottoException(NON_DIGIT_ERROR_MESSAGE);
        if (!isValidDelimiter(input)) throw new LottoException(INVALID_DELIMITER_MESSAGE);

        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .map(num -> {
                    if(!isValidNumber(num)) throw new LottoException(INVALID_WINNING_NUMBER_MESSAGE);
                    return num;
                })
                .collect(Collectors.toList());

        if (!isValidPicks(numbers.size())) throw new LottoException(INVALID_PICK_NUMBER_MESSAGE);
        if (isDuplicated(numbers)) throw new LottoException(DUPLICATED_MESSAGE);

        return numbers;
    }

    private static boolean isContainedEmpty(String input) {
        return input.contains(" ");
    }

    private static boolean isContainedLetter(String input) {
        return input.matches(".*[a-zA-Z]+.*");
    }

    private static boolean isValidDelimiter(String input) {
        return input.matches("^[0-9]+(,[0-9]+)*$");
    }

    private static boolean isValidNumber(int number) {
        return number >= 1 && number <= 45;
    }

    private static boolean isValidPicks(int picks) {
        return picks == NUMBER_OF_PICKS.getValue();
    }

    private static boolean isDuplicated(List<Integer> numbers) {
        return numbers.stream().distinct().count() != NUMBER_OF_PICKS.getValue();
    }

}
