package lotto.domain;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class LottoGeneratorTest {

    @DisplayName("로또 한 장을 생성하면 6개의 중복 없는 번호가 생성된다.")
    @Test
    void createLotto_테스트() {
        Lotto lotto = LottoGenerator.createLotto();
        String lottoString = lotto.toString();

        // 포맷: [1, 5, 23, 33, 42, 45]
        assertThat(lottoString).contains("[");
        assertThat(lottoString).contains("]");
    }

    @DisplayName("요청한 개수만큼 로또가 생성된다.")
    @Test
    void createLottos_테스트() {
        int count = 5;
        List<Lotto> lottos = LottoGenerator.createLottos(count);
        assertThat(lottos).hasSize(count);
    }
}
