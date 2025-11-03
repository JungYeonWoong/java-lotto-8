package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 아니면 예외가 발생한다.")
    @Test
    void 로또_번호_개수_검증() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("6개");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호_중복_검증() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }

    @DisplayName("로또 번호가 1~45 범위를 벗어나면 예외가 발생한다.")
    @Test
    void 로또_번호_범위_검증() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1부터 45");
    }

    @DisplayName("로또 번호가 오름차순이 아니면 예외가 발생한다.")
    @Test
    void 로또_번호_정렬_검증() {
        assertThatThrownBy(() -> new Lotto(List.of(10, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("오름차순");
    }

    @DisplayName("로또 번호가 정상일 때 예외가 발생하지 않는다.")
    @Test
    void 로또_번호_정상_입력() {
        assertThatCode(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)))
                .doesNotThrowAnyException();
    }

    @DisplayName("로또가 특정 숫자를 포함하는지 확인한다.")
    @Test
    void contains_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.contains(3)).isTrue();
        assertThat(lotto.contains(10)).isFalse();
    }

    @DisplayName("로또와 당첨 번호를 비교해 일치 개수를 계산한다.")
    @Test
    void countMatches_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winning = List.of(2, 4, 6, 8, 10, 12);
        assertThat(lotto.countMatches(winning)).isEqualTo(3);
    }
}
