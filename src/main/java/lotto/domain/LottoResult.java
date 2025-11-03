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
}
