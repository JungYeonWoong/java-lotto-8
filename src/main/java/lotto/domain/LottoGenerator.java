package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    // 로또 한 장(6개 번호) 생성
    public static Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    // 구입 개수만큼 로또 생성
    public static List<Lotto> createLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(createLotto());
        }
        return lottos;
    }
}
