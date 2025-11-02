package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator {

    public static List<Integer> generateLottoNumbers() {
        // 1 ~ 45 사이의 서로 다른 6개 숫자 생성
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
