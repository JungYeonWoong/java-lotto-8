package lotto.util;

import java.util.function.Supplier;

public class InputRetryHandler {

    public static <T> T executeWithRetry(Supplier<T> supplier) {
        while (true) {
            T result = tryGet(supplier);
            if (result != null) return result;
        }
    }

    private static <T> T tryGet(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(e.getMessage());
            return null; // 실패 시 null 반환 → while 반복
        }
    }
}