package racingcar.domain;

import java.util.List;

public class RaceManager {
    private static final String ERROR_NOT_ENOUGH_CARS = "경주에 참여하는 자동차는 2대 이상이어야 합니다.";
    private static final String ERROR_DUPLICATED_CAR_NAME = "중복된 이름의 자동차가 존재합니다.";
    private final List<Car> cars;

    private final Race race;

    public RaceManager(List<Car> cars, Round round){
        validateCars(cars);
        this.cars = cars;
        this.race = new Race(cars, round);
    }

    private void validateCars(List<Car> cars) {
        if (cars.size() < 2) {
            throw new IllegalArgumentException(ERROR_NOT_ENOUGH_CARS);
        }

        long distinctCount = cars.stream()
                .map(Car::getName)
                .distinct()
                .count();

        if (distinctCount != cars.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATED_CAR_NAME);
        }
    }

    public void startRace() {
            race.start();
        }

    public List<Car> findWinner() {
        int maxPosition = getMaxPosition();

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
