package lotto;

import java.util.ArrayList;
import java.util.List;

/**
 * 로또 추첨 장치
 * 추첨된 로또 당첨 현황 + 당첨 통계 발표
 */
public class LotteryDevice {
    private ArrayList<Lotto> purchasedLottoTickets;
    private ArrayList<Integer> winningNumbers;
    private List<LottoPrize> prizes = new ArrayList<>();
    private int plusNumber;

    public LotteryDevice(ArrayList<Lotto> purchasedLottoTickets,
                         ArrayList<Integer> winningNumbers,
                         int plusNumber) {
        this.purchasedLottoTickets = purchasedLottoTickets;
        this.winningNumbers = winningNumbers;
        this.plusNumber = plusNumber;
    }


    public void calcPrize() {
        for (Lotto lotto : purchasedLottoTickets) {
            drawPrize(lotto);
        }
    }

    // 상품 선별
    public void drawPrize(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        int matchCount = 0;
        boolean isBonusMatch = numbers.contains(plusNumber);
        for (Integer number : numbers) {
            matchCount = checkNumberMatch(number,matchCount);
        }
        selectPrize(matchCount,isBonusMatch);
    }

    public int checkNumberMatch(int number,int count) {
        for (int winningNumber : winningNumbers) {
            count += plusMatchPoint(number, winningNumber);
        }
        return count;
    }

    public int plusMatchPoint(int number, int winningNumber) {
        if (number == winningNumber) {
            return 1;
        }
        return 0;
    }


    // 조건에 맞춰 상품 선별
    public void selectPrize(int matchCount, boolean isBonusMatch) {
        if (matchCount == 6) {
            prizes.add(LottoPrize.FIRST);
        }
        if (matchCount == 5 && isBonusMatch) {
            prizes.add(LottoPrize.SECOND);
        }
        if (matchCount == 5 && !isBonusMatch) {
            prizes.add(LottoPrize.THIRD);
        }
        if (matchCount == 4) {
            prizes.add(LottoPrize.FOURTH);
        }
        if (matchCount == 3) {
            prizes.add(LottoPrize.FIFTH);
        }
    }


}
