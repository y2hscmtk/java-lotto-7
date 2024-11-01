package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;

public class LotteMachine {
    private static final Integer START_INCLUSIVE = 1;
    private static final Integer END_INCLUSIVE = 45;
    private static final Integer LOTTO_SIZE = 6;
    private final ArrayList<Lotto> purchasedLottoTickets = new ArrayList<>();
    public void run() {
        buyLotto();
        printLottoNumbers();
    }

    public void buyLotto() {
        int purchaseAmount = getPurchaseAmount();
        int purchaseQuantity = getPurchaseQuantity(purchaseAmount);
        // 로또 구입
        for (int i = 0; i < purchaseQuantity; i++) {
            purchasedLottoTickets.add(new Lotto(Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, LOTTO_SIZE)));
        }
    }

    public void printLottoNumbers() {
        System.out.println();
        System.out.println(purchasedLottoTickets.size() + "개를 구매했습니다.");
        for (Lotto lotto : purchasedLottoTickets) {
            lotto.printLottoNumbers();
        }
        System.out.println();
    }

    public int getPurchaseQuantity(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    public int getPurchaseAmount() {
        String input;
        do {
            System.out.println("구입금액을 입력해 주세요.");
            input = Console.readLine();
        } while (!isValidPurchaseAmount(input)); // 올바른 값을 입력받을 때 까지 반복
        return Integer.parseInt(input);
    }

    // 입력값이 올바른 구매 금액인지 검증
    public boolean isValidPurchaseAmount(String input) {
        try {
            int amount = integerConversion(input);
            validatePurchaseAmount(amount);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Integer integerConversion(String inputData) {
        try {
            return Integer.parseInt(inputData);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 값 입니다. 정수를 입력 해주세요.");
        }
    }

    // 올바른 구매 금액인지 확인
    // 양수값인지, 1000이상 정수인지 확인
    public void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액이 음수입니다. 양수 값을 입력 해주세요");
        }
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액의 단위가 올바르지 않습니다.1000원 단위로 입력해주세요.");
        }
    }
}
