package lotto.view;

import lotto.Lotto;
import lotto.domain.Rank;
import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printPurchaseLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printGeneratedLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto); // lotto.toString() 자동 호출
        }
    }

    // 당첨 통계 출력
    public static void printWinningStatistics(Map<Rank, Integer> results) {

        System.out.printf("%s - %d개%n", Rank.FIFTH.getDescription(), results.getOrDefault(Rank.FIFTH, 0));
        System.out.printf("%s - %d개%n", Rank.FOURTH.getDescription(), results.getOrDefault(Rank.FOURTH, 0));
        System.out.printf("%s - %d개%n", Rank.THIRD.getDescription(), results.getOrDefault(Rank.THIRD, 0));
        System.out.printf("%s - %d개%n", Rank.SECOND.getDescription(), results.getOrDefault(Rank.SECOND, 0));
        System.out.printf("%s - %d개%n", Rank.FIRST.getDescription(), results.getOrDefault(Rank.FIRST, 0));
    }
    
    // 수익률 출력
    public static void printProfitRate(double profitRate) {
        double roundedRate = Math.round(profitRate * 10) / 10.0; // 소수점 둘째 자리
        System.out.printf("총 수익률은 %.1f%%입니다.%n", roundedRate);
    }
}
