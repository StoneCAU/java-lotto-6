package lotto.domain;

import java.util.List;

public class Prize {
    private List<Integer> numbers;
    private int bonusNumber;

    private Prize(List<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public static Prize createPrize(List<Integer> numbers, int bonusNumber) {
        return new Prize(numbers, bonusNumber);
    }
}
