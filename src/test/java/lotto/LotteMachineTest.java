package lotto;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;

class LotteMachineTest {

    @Test
    void 로또_구매_금액이_정수가_아니면_예외가_발생_한다() {
        assertThatThrownBy(() -> new LotteMachine().integerConversion("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_구매_금액이_1000원_단위의_양수가_아니면_예외가_발생한다() {
        assertThatThrownBy(()-> new LotteMachine().validatePurchaseAmount(0))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()-> new LotteMachine().validatePurchaseAmount(-1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()-> new LotteMachine().validatePurchaseAmount(1001))
                .isInstanceOf(IllegalArgumentException.class);
    }

}