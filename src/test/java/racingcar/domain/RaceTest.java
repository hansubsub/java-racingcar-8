package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class RaceTest {
    @DisplayName("레이스 생성 성공")
    @Test
    void createRaceSuccess() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        List<Car> cars = List.of(pobi, woni);

        Assertions.assertThatCode(() -> new Race(cars))
                .doesNotThrowAnyException();
    }

}

