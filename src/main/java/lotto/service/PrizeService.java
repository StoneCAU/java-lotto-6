package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrizeService {
    public static List<Integer> parsingNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
