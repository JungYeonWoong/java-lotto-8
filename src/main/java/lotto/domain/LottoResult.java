package lotto.domain;

import lotto.Lotto;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    public static Map<Rank, Integer> aggregateResults(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<Rank, Integer> resultCount = new EnumMap<>(Rank.class);

        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatches(winningNumbers);
            boolean hasBonus = lotto.contains(bonusNumber);
            Rank rank = Rank.valueOf(matchCount, hasBonus);

            resultCount.put(rank, resultCount.getOrDefault(rank, 0) + 1);
        }

        return resultCount;
    }
    // 총 당첨 금액 계산
    public static long calculateTotalPrize(Map<Rank, Integer> results) {
        long totalPrize = 0L;

        for (Rank rank : Rank.values()) {
            totalPrize += (long) rank.getPrize() * results.getOrDefault(rank, 0);
        }

        return totalPrize;
    }

    public static double calculateProfitRate(long totalPrize, int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0보다 커야 합니다.");
        }

        double rate = (double) totalPrize / purchaseAmount * 100;
        return rate;
    }
}
