package racingcar.domain;

public class Car {
    private static final String ERROR_CAR_NAME_TOO_LONG = "자동차 이름은 5자 이하여야 합니다.";
    private static final String ERROR_CAR_NAME_NO_SPACE = "자동차 이름에 공백을 포함할 수 없습니다.";
    private static final String ERROR_CAR_NAME_NO_EMPTY = "자동차 이름으로 빈 값을 입력할 수 없습니다.";

    private final String name;
    private int position = 0;

    public Car(String carName){
        validate(carName);
        this.name = carName;
    }

    public void move(){
        position +=1;
    }

    private void validate(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_NO_EMPTY);
        }
        if (carName.contains(" ")) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_NO_SPACE);
        }
        if (carName.length() > 5) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_TOO_LONG);
        }
    }

    public String getName(){
        return name;
    }
    public int getPosition(){
        return position;
    }
}
