package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateCheck(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void duplicateCheck(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에는 중복된 숫자가 포함될 수 없습니다.");
        }
    }

    // 오름차순 정렬 후 출력
    public void printLottoNumbers() {
        Collections.sort(numbers);
        System.out.println(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
