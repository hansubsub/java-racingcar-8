package racingcar.domain;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Race {
    private static final int MOVE_CONDITION = 4;
    private final List<Car> cars;

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
        int randomValue = Randoms.pickNumberInRange(0, 9);
        return randomValue >= MOVE_CONDITION;
    }
}
