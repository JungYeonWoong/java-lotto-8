package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        try {
            int amount = Integer.parseInt(input.trim());
            validatePurchaseAmount(amount);
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
    }

    private static void validatePurchaseAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0보다 커야 합니다.");
        }
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
    }

    private static int parseWinningNumber(String value) {
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자만 입력할 수 있습니다.");
        }
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();

        List<String> splitNumbers = Arrays.asList(input.split(","));

        // 문자열 → 정수 변환 시 parseWinningNumber 사용
        return splitNumbers.stream()
                .map(InputView::parseWinningNumber)
                .collect(Collectors.toList());
    }

}
