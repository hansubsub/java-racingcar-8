package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RoundTest {

    @DisplayName("시도 횟수가 숫자가 아닐 경우 예외 발생")
    @Test
    void roundNotNumberThrowsException() {
        Assertions.assertThatThrownBy(() -> new Round("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수로 숫자를 입력해주세요.");
    }

    @DisplayName("시도 횟수가 0 이하일 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    void roundNotPositiveThrowsException(String input) {
        Assertions.assertThatThrownBy(() -> new Round(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수로 양수를 입력해주세요.");
    }

    @DisplayName("정상 입력 시 Round 생성 성공")
    @Test
    void createRoundSuccess() {
        Round round = new Round("5");

        Assertions.assertThat(round.getTryCount()).isEqualTo(5);
    }
}
