package lotto.view.output;

public class OutputView {
    public static void PrintStaticMessage(OutputMessage message) {
        System.out.println(message.getMessage());
    }

    public static void PrintDynamicMessage(String message) {
        System.out.println(message);
    }
}
