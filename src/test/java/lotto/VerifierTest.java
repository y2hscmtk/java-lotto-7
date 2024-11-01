package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class VerifierTest {

    @Test
    void 로또_구매_금액이_정수가_아니면_예외가_발생_한다() {
        assertThatThrownBy(() -> new Verifier().integerConversion("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_구매_금액이_1000원_단위의_양수가_아니면_예외가_발생한다() {
        assertThatThrownBy(()-> new Verifier().validatePurchaseAmount(0))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()-> new Verifier().validatePurchaseAmount(-1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()-> new Verifier().validatePurchaseAmount(1001))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호가_1에서_45사이의_값이_아니라면_예외가_발생_한다() {
        List<Integer> checkNumbers = Arrays.asList(-1,0,46);
        for (Integer checkNumber : checkNumbers) {
            assertThatThrownBy(()-> new Verifier().lottoNumberRangeCheck(checkNumber))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

}