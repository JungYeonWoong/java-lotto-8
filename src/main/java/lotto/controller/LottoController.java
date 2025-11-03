package lotto.controller;

import lotto.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoResult;
import lotto.domain.Rank;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {

    public void run() {
        // 1. 구입 금액 입력 및 로또 개수 계산
        int purchaseMoney = InputView.inputPurchaseAmount();
        int lottoCount = calculateLottoCount(purchaseMoney);
        validateLottoCount(lottoCount);
        OutputView.printPurchaseLottoCount(lottoCount);

        // 2. 로또 발행 및 출력
        List<Lotto> purchasedLottos = LottoGenerator.createLottos(lottoCount);
        OutputView.printGeneratedLottos(purchasedLottos);

        // 3. 당첨 번호 및 보너스 번호 입력
        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber(winningNumbers);

        // 4. 당첨 결과 집계
        Map<Rank, Integer> results = LottoResult.aggregateResults(purchasedLottos, winningNumbers, bonusNumber);

        // 5. 당첨 통계 출력
        OutputView.printWinningStatistics(results);

        // 6. 총 당첨 금액 및 수익률 계산
        long totalPrize = LottoResult.calculateTotalPrize(results);
        double profitRate = LottoResult.calculateProfitRate(totalPrize, purchaseMoney);

        // 7. 수익률 출력
        OutputView.printProfitRate(profitRate);
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
