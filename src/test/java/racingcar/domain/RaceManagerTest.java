package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class RaceManagerTest {

    @DisplayName("참여 자동차가 2대 미만이면 예외 발생")
    @Test
    void validateNotEnoughCars() {
        List<Car> cars = List.of(new Car("pobi"));

        Assertions.assertThatThrownBy(() -> new RaceManager(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("경주에 참여하는 자동차는 2대 이상이어야 합니다.");
    }

    @DisplayName("자동차 이름이 중복되면 예외 발생")
    @Test
    void validateDuplicateNames() {
        List<Car> cars = List.of(new Car("pobi"), new Car("pobi"));

        Assertions.assertThatThrownBy(() -> new RaceManager(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름의 자동차가 존재합니다.");
    }

    @DisplayName("경주가 정상적으로 진행된다.")
    @Test
    void startRaceSuccess() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        List<Car> cars = List.of(pobi, woni);

        RaceManager manager = new RaceManager(cars);

        Assertions.assertThatCode(manager::startRace).doesNotThrowAnyException();
    }

    @DisplayName("최대 position을 가진 자동차가 우승자로 판별된다")
    @Test
    void findWinnerSuccess() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");

        pobi.move();
        List<Car> cars = List.of(pobi, woni);

        RaceManager manager = new RaceManager(cars);
        List<Car> winners = manager.findWinner();

        Assertions.assertThat(winners).containsExactly(pobi);
    }

    @DisplayName("우승자가 여러 명일 경우 모두 반환된다")
    @Test
    void findMultipleWinners() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");

        pobi.move();
        woni.move();

        List<Car> cars = List.of(pobi, woni);
        RaceManager manager = new RaceManager(cars);
        List<Car> winners = manager.findWinner();

        Assertions.assertThat(winners).containsExactlyInAnyOrder(pobi, woni);
    }
}
