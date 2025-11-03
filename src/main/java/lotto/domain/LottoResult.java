package lotto.domain;

import lotto.Lotto;
import java.util.List;

public class LottoResult {

    public static int countMatchingNumbers(Lotto lotto, List<Integer> winningNumbers) {
        return lotto.countMatches(winningNumbers);
    }

    // getter 없이 보너스 번호 일치 여부 확인
    public static boolean hasBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.contains(bonusNumber);
    }

    // 등수 계산 로직
    public static int determineRank(int matchCount, boolean hasBonus) {
        if (matchCount == 6) return 1;
        if (matchCount == 5 && hasBonus) return 2;
        if (matchCount == 5) return 3;
        if (matchCount == 4) return 4;
        if (matchCount == 3) return 5;
        return 0; // 낙첨
    }
}
