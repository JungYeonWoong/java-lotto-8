package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class RankTest {

    @DisplayName("일치 개수와 보너스 여부에 따라 올바른 Rank를 반환한다.")
    @Test
    void Rank_매핑_테스트() {
        assertThat(Rank.from(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.from(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.from(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.from(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.from(3, false)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.from(2, false)).isEqualTo(Rank.MISS);
    }

    @DisplayName("Rank의 상금과 설명이 올바르게 설정되어 있다.")
    @Test
    void Rank_속성_테스트() {
        assertThat(Rank.FIRST.getPrize()).isEqualTo(2_000_000_000);
        assertThat(Rank.SECOND.getDescription()).contains("보너스");
    }
}
