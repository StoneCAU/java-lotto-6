package lotto.view.output;

import java.util.List;

public class OutputView {
    public static void PrintStaticMessage(OutputMessage message) {
        System.out.println(message.getMessage());
    }

    public static void PrintDynamicMessage(String message) {
        System.out.println(message);
    }

    public static void PrintNewLine() {
        System.out.println();
    }

    public static void PrintLottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public static void PrintStatisticsMessage(List<String> messages) {
        for(String message : messages) {
            System.out.println(message);
        }
    }

    public static void PrintErrorMessage(String message) {
        System.out.println(message);
        PrintNewLine();
    }

}
