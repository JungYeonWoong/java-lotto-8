package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class LottoGenerator {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    // 생성자 private → 객체 생성 방지 (유틸 클래스 원칙)
    private LottoGenerator() {
        throw new IllegalStateException("Utility class");
    }

    public static Lotto createLotto() {
        List<Integer> numbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE)
        );
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    public static List<Lotto> createLottos(int lottoCount) {
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> createLotto())
                .collect(Collectors.toList());
    }
}
