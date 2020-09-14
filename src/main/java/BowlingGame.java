import java.util.List;

public class BowlingGame {

    List<Frame> frames;

    BowlingGame(List<Frame> frames) {
        this.frames = frames;
    }

    public int calculateScoreOfTheRound(Frame frame) {

        if (frame.getStatus() == Frame.NO_STRIKE_AND_SPARE) {
            return numberOfKnockdownBottlesIn(frame);
        }

        final int NUMBER_OF_BOTTLES = 10;
        int indexOfThisFrame = frames.indexOf(frame);
        if (frame.getStatus() == Frame.SPARE) {
            return NUMBER_OF_BOTTLES + frames.get(indexOfThisFrame + 1).getNumbersOfKnockdownBottles().get(Frame.FIRST);
        }

        if (frames.get(indexOfThisFrame + 1).getStatus() == Frame.STRIKE) {
            return NUMBER_OF_BOTTLES * 2 + frames.get(indexOfThisFrame + 2).getNumbersOfKnockdownBottles().get(Frame.FIRST);
        }
        return NUMBER_OF_BOTTLES + numberOfKnockdownBottlesIn(frames.get(indexOfThisFrame + 1));
    }

    private int numberOfKnockdownBottlesIn(Frame frame) {
        List<Integer> numbersOfKnockdownBottles = frame.getNumbersOfKnockdownBottles();
        return numbersOfKnockdownBottles.get(Frame.FIRST) + numbersOfKnockdownBottles.get(Frame.SECOND);
    }
}
