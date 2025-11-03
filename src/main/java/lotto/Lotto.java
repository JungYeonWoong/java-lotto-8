package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        // 1. 6개 번호인지 확인
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        // 2. 중복 번호 확인
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }

        // 3. 1~45 범위 확인
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }

        // 4. 오름차순 정렬 여부 확인
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i) > numbers.get(i + 1)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 오름차순으로 정렬되어야 합니다.");
            }
        }
    }

    // 특정 숫자가 이 로또에 포함되어 있는지 확인
    public boolean contains(int number) {
        return numbers.contains(number);
    }

    // 당첨 번호 리스트와 비교해서 일치 개수 반환
    public int countMatches(List<Integer> winningNumbers) {
        int count = 0;
        for (int winningNumber : winningNumbers) {
            if (contains(winningNumber)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
