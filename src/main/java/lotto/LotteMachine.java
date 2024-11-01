package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LotteMachine {

    public void run() {
        int purchaseAmount = getPurchaseAmount();
    }

    public int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = integerConversion(Console.readLine());
        validatePurchaseAmount(purchaseAmount);
        return purchaseAmount;
    }

    public Integer integerConversion(String inputData) {
        try {
            return Integer.parseInt(inputData);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 값 입니다. 정수를 입력 해주세요.");
        }
    }

    // 올바른 구매 금액인지 확인
    // 양수값인지, 1000이상 정수인지 확인
    public void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액이 음수입니다. 양수 값을 입력 해주세요");
        }
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액의 단위가 올바르지 않습니다.1000원 단위로 입력해주세요.");
        }
    }
}
