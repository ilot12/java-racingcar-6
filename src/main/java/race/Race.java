package race;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import racer.Racer;
import racer.Racers;
import view.InputView;
import view.OutputView;

public class Race {
    
    Racers racers;
    int advanceTries;
    List<Racer> winners;
    
    public Race() {
        racers = new Racers(InputView.readRacers());
        winners = new ArrayList<Racer>();
        String advanceTriesText = InputView.readTries();
        advanceTries = validateAdvanceTriesText(advanceTriesText);
        
        OutputView.resultInitialMessage();
        int i = 0;
        for (i = 0; i < advanceTries; i++) {
            racersAdvanceTryOnce();
        }
        
        findWinners();
        OutputView.printWinners(getWinnerNames(winners));
    }
    
    private int validateAdvanceTriesText(String advanceTriesText) throws IllegalArgumentException {
        if (!advanceTriesText.matches("[-0-9]+")) {
            throw new IllegalArgumentException("[ERROR] 전진 시도 횟수는 수를 입력해야 합니다,");
        }
        int advanceTries = Integer.parseInt(advanceTriesText);
        if (advanceTries <= 0) {
            throw new IllegalArgumentException("[ERROR] 입력한 수는 자연수여야 합니다.");
        }
        if (advanceTries > 100) {
            throw new IllegalArgumentException("[ERROR] 입력한 수가 너무 큽니다. 100이하로 입력해주세요.");
        }
        return advanceTries;
    }
    
    private void racersAdvanceTryOnce() {
        for (Racer racer : racers.getRacers()) {
            if (advanceSuccess()) {
                racer.increaseAdvance();
            }
            OutputView.printRacerAdvance(racer);
        }
        System.out.println();
    }
    
    private boolean advanceSuccess() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            return true;
        }
        return false;
    }
    
    private void findWinners() {
        int maxAdvance = 0;
        
        for (Racer racer : racers.getRacers()) {
            if (racer.getAdvance() > maxAdvance) {
                maxAdvance = racer.getAdvance();
            }
        }
        
        for (Racer racer : racers.getRacers()) {
            if (racer.getAdvance() == maxAdvance) {
                winners.add(racer);
            }
        }
    }
    
    private List<String> getWinnerNames(List<Racer> winners) {
        List<String> winnerNames = new ArrayList<String>();
        for (Racer racer : winners) {
            winnerNames.add(racer.getName());
        }
        return winnerNames;
    }
}
