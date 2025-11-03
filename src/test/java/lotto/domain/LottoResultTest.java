package lotto.domain;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.*;

class LottoResultTest {

    @DisplayName("로또 당첨 결과를 올바르게 집계한다.")
    @Test
    void aggregateResults_테스트() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 6개 일치 → 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7))  // 5개 + 보너스 → 2등
        );
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Map<Rank, Integer> result = LottoResult.aggregateResults(lottos, winningNumbers, bonusNumber);

        assertThat(result.get(Rank.FIRST)).isEqualTo(1);
        assertThat(result.get(Rank.SECOND)).isEqualTo(1);
    }

    @DisplayName("총 당첨 금액을 올바르게 계산한다.")
    @Test
    void calculateTotalPrize_테스트() {
        Map<Rank, Integer> results = Map.of(
                Rank.FIRST, 1,
                Rank.THIRD, 2,
                Rank.FOURTH, 1
        );
        long totalPrize = LottoResult.calculateTotalPrize(results);
        assertThat(totalPrize).isEqualTo(2_000_000_000L + 2 * 1_500_000L + 50_000L);
    }

    @DisplayName("수익률을 소수점 둘째 자리에서 반올림하여 소수점 첫째 자리까지 계산한다.")
    @Test
    void calculateProfitRate_테스트() {
        double rate = LottoResult.calculateProfitRate(5_000L, 8_000L);
        assertThat(rate).isEqualTo(160.0);

        rate = LottoResult.calculateProfitRate(5_000L, 3_127L);
        assertThat(rate).isEqualTo(62.5);

        rate = LottoResult.calculateProfitRate(5_000L, 3_128L);
        assertThat(rate).isEqualTo(62.6);
    }


    @DisplayName("구입 금액이 0 이하이면 예외가 발생한다.")
    @Test
    void calculateProfitRate_예외_테스트() {
        assertThatThrownBy(() -> LottoResult.calculateProfitRate(1000, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
