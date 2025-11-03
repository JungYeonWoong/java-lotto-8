package lotto.domain;

import lotto.Lotto;
import java.util.List;

public class LottoResult {

    // 각 로또의 일치 개수 계산 (getter 없이)
    public static int countMatchingNumbers(Lotto lotto, List<Integer> winningNumbers) {
        return lotto.countMatches(winningNumbers);
    }
}
