package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.RaceManager;
import racingcar.domain.Round;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RaceController {
    private final InputView inputView;
    private final OutputView outputView;

    public RaceController(){
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run(){
        List<Car> cars = inputView.inputCarNames();
        Round round = inputView.inputRoundCount();
        RaceManager raceManager = new RaceManager(cars);
        outputView.printResult();

        for (int i = 0; i < round.getTryCount(); i++) {
            raceManager.startRace();
            outputView.printRoundResult(cars);
        }

        List<Car> winners = raceManager.findWinner();
        outputView.printWinners(winners);
    }
}
