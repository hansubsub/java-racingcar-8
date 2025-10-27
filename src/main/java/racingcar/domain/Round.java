package racingcar.domain;

public class Round {
    public static final String ERROR_NOT_NUMBER = "시도할 횟수로 숫자를 입력해주세요.";
    public static final String ERROR_NOT_POSITIVE_NUMBER = "시도할 횟수로 양수를 입력해주세요.";

    private final int tryCount;

    public Round(String tryCount){
        int count = toInt(tryCount);
        validatePositive(count);
        this.tryCount = count;
    }


    private int toInt(String tryCount) {
        try {
            return Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_NUMBER);
        }
    }

    private void validatePositive(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException(ERROR_NOT_POSITIVE_NUMBER);
        }
    }

    public int getTryCount() {
        return tryCount;
    }

}

