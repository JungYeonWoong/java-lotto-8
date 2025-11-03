package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputRetryHandler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    // 상수 정의
    private static final int LOTTO_PRICE_UNIT = 1000;
    private static final int MIN_PURCHASE_AMOUNT = 1;
    private static final int WINNING_NUMBERS_SIZE = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    // 구입 금액 입력
    public static int inputPurchaseAmount() {
        return InputRetryHandler.executeWithRetry(() -> {
            System.out.println("구입금액을 입력해 주세요.");
            String input = Console.readLine();
            int amount = parseInt(input, "[ERROR] 구입 금액은 숫자여야 합니다.");
            validatePurchaseAmount(amount);
            return amount;
        });
    }

    private static void validatePurchaseAmount(int amount) {
        if (amount < MIN_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0보다 커야 합니다.");
        }
        if (amount % LOTTO_PRICE_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
    }

    // 당첨 번호 입력
    public static List<Integer> inputWinningNumbers() {
        return InputRetryHandler.executeWithRetry(() -> {
            System.out.println("당첨 번호를 입력해 주세요.");
            String input = Console.readLine();

            List<Integer> numbers = Arrays.stream(input.split(","))
                    .map(s -> parseInt(s, "[ERROR] 당첨 번호는 숫자여야 합니다."))
                    .collect(Collectors.toList());
            // 개수 검증
            validateWinningNumbersCount(numbers);
            // 범위 검증
            validateWinningNumbersRange(numbers);
            // 중복 검증
            validateWinningNumbersDuplicate(numbers);
            return numbers;
        });
    }

    private static void validateWinningNumbersCount(List<Integer> numbers) {
        if (numbers.size() != WINNING_NUMBERS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }

    private static void validateWinningNumbersRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private static void validateWinningNumbersDuplicate(List<Integer> numbers) {
        long distinctCount = numbers.stream().distinct().count();
        if (distinctCount != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.");
        }
    }

    public static int inputBonusNumber(List<Integer> winningNumbers) {
        return InputRetryHandler.executeWithRetry(() -> {
            System.out.println("보너스 번호를 입력해 주세요.");
            String input = Console.readLine();

            int bonusNumber = parseInt(input, "[ERROR] 보너스 번호는 숫자여야 합니다.");
            // 범위 검증
            validateBonusNumberRange(bonusNumber);
            // 중복 검증
            validateBonusNumberDuplicate(bonusNumber, winningNumbers);
            return bonusNumber;
        });
    }

    private static void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < LOTTO_MIN_NUMBER || bonusNumber > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static void validateBonusNumberDuplicate(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private static int parseInt(String input, String errorMessage) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
