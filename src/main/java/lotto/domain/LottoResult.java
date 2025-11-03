package lotto.domain;

import lotto.Lotto;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    public static int countMatchingNumbers(Lotto lotto, List<Integer> winningNumbers) {
        return lotto.countMatches(winningNumbers);
    }

    public static boolean hasBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.contains(bonusNumber);
    }

    public static int determineRank(int matchCount, boolean hasBonus) {
        if (matchCount == 6) return 1;
        if (matchCount == 5 && hasBonus) return 2;
        if (matchCount == 5) return 3;
        if (matchCount == 4) return 4;
        if (matchCount == 3) return 5;
        return 0;
    }

    // 모든 로또의 등수 집계
    public static Map<Integer, Integer> aggregateResults(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<Integer, Integer> resultCount = new HashMap<>();

        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatches(winningNumbers);
            boolean hasBonus = lotto.contains(bonusNumber);
            int rank = determineRank(matchCount, hasBonus);

            resultCount.put(rank, resultCount.getOrDefault(rank, 0) + 1);
        }

        return resultCount;
    }
}
