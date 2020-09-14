import java.util.List;

public class BowlingGame {

    List<Frame> frames;

    BowlingGame(List<Frame> frames) {
        this.frames = frames;
    }

    public int calculateScoreOfTheRound(Frame frame) {
        List<Integer> numbersOfKnockdownBottles = frame.getNumbersOfKnockdownBottles();
        return numbersOfKnockdownBottles.get(Frame.FIRST) + numbersOfKnockdownBottles.get(Frame.SECOND);
    }
}
