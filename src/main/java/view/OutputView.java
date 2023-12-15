package view;

import java.util.List;
import racer.Racer;

public class OutputView {
    
    public static void resultInitialMessage() {
        System.out.println("\n실행결과");
    }
    
    public static void printRacerAdvance(Racer racer) {
        StringBuilder sb = new StringBuilder();
        sb.append(racer.getName());
        sb.append(" : ");
        int i = 0;
        for (i = 0;i < racer.getAdvance(); i++) {
            sb.append("-");
        }
        System.out.println(sb.toString());
    }
    
    public static void printWinners(List<String> winnerNames) {
        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자 : ");
        sb.append(String.join(", ", winnerNames));
        System.out.println(sb.toString());
    }
}
