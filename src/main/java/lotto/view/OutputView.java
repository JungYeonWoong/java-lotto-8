package lotto.view;

import lotto.Lotto;
import java.util.List;

public class OutputView {

    public static void printPurchaseLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printGeneratedLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto); // ✅ lotto.toString() 자동 호출
        }
    }
}
