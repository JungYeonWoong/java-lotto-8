package lotto.controller;

import lotto.view.InputView;

public class LottoController {

    public void run() {
        int purchaseMoney = InputView.inputPurchaseAmount();
        int lottoCount = calculateLottoCount(purchaseMoney);
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    private int calculateLottoCount(int purchaseMoney) {
        return purchaseMoney / 1000;
    }
}
