package lotto.controller;

import lotto.Lotto;
import lotto.domain.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;
import java.util.List;

public class LottoController {

    public void run() {
        int purchaseMoney = InputView.inputPurchaseAmount();
        int lottoCount = calculateLottoCount(purchaseMoney);
        validateLottoCount(lottoCount);
        OutputView.printPurchaseLottoCount(lottoCount);

        List<Lotto> purchasedLottos = LottoGenerator.createLottos(lottoCount);
    }

    private int calculateLottoCount(int purchaseMoney) {
        return purchaseMoney / 1000;
    }

    private void validateLottoCount(int lottoCount) {
        if (lottoCount <= 0) {
            throw new IllegalArgumentException("[ERROR] 최소 1장 이상의 로또를 구매해야 합니다.");
        }
    }
}
