package racingcar.domain;

import java.util.List;
import java.util.Random;

public class Race {
    private static final int MOVE_CONDITION = 4;
    private final List<Car> cars;
    private final Random random = new Random();

    public Race(List<Car> cars ) {
        this.cars = cars;
    }

    public void start() {
        moveAllCars();
    }

    public void moveAllCars(){
        for(Car car:cars){
            if(isMovable()){
                car.move();
            }
        }
    }

    public boolean isMovable(){
        int randomValue = random.nextInt(10);
        return randomValue >= MOVE_CONDITION;
    }
}
