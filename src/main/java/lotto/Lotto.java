package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    //  특정 숫자가 이 로또에 포함되어 있는지 확인
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
