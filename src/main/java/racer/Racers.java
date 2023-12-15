package racer;

import java.util.ArrayList;
import java.util.List;

public class Racers {

    List<Racer> racers;
    List<String> racerNames;
    
    public Racers(String racersText) {
        racerNames = new ArrayList<String>();
        racers = new ArrayList<Racer>();
        String[] eachRacersText = racersText.split(",");
        for (String eachRacer : eachRacersText) {
            Racer racer = new Racer(eachRacer);
            validateEachRacer(eachRacer);
            racerNames.add(eachRacer);
            racers.add(racer);
        }
    }
    
    private void validateEachRacer(String racerName) throws IllegalArgumentException {
        if (racerNames.contains(racerName)) {
            throw new IllegalArgumentException("[ERROR] 참가자에 중복된 이름이 있으면 안됩니다.");
        }
    }
    
    public List<Racer> getRacers() {
        return this.racers;
    }
}
