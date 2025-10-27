package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @DisplayName("자동차 생성 성공")
    @Test
    void createCarSuccess() {
        // given
        String name = "pobi";
        // when
        Car car = new Car(name);
        // then
        Assertions.assertThat(car.getName()).isEqualTo("pobi");
        Assertions.assertThat(car.getPosition()).isZero();
    }

    @DisplayName("자동차 이름이 5자를 초과하면 예외 발생")
    @Test
    void nameTooLongThrowsException() {
        Assertions.assertThatThrownBy(() -> new Car("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하여야 합니다.");
    }

    @DisplayName("자동차 이름에 공백이 포함되면 예외 발생")
    @Test
    void nameContainsSpaceThrowsException() {
        Assertions.assertThatThrownBy(() -> new Car("po bi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름에 공백을 포함할 수 없습니다.");
    }

    @DisplayName("자동차 이름이 빈 값이면 예외 발생")
    @Test
    void nameEmptyThrowsException() {
        Assertions.assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름으로 빈 값을 입력할 수 없습니다.");
    }

    @DisplayName("자동차 전진: position 1 증가")
    @Test
    void carMovesForward() {
        Car car = new Car("pobi");

        car.move();

        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }
}
