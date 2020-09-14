import java.util.List;

public class BowlingGame {

    List<Frame> frames;

    BowlingGame(List<Frame> frames) {
        this.frames = frames;
    }

    public int calculateScoreOfTheRound(Frame frame) {
        final int NUMBER_OF_BOTTLES = 10;
        if (frame.getStatus() == Frame.SPARE) {
            int indexOfThisFrame = frames.indexOf(frame);
            return NUMBER_OF_BOTTLES + frames.get(indexOfThisFrame + 1).getNumbersOfKnockdownBottles().get(Frame.FIRST);
        }
        List<Integer> numbersOfKnockdownBottles = frame.getNumbersOfKnockdownBottles();
        return numbersOfKnockdownBottles.get(Frame.FIRST) + numbersOfKnockdownBottles.get(Frame.SECOND);
    }
}
