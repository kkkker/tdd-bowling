import java.util.List;

public class BowlingGame {

    List<Frame> frames;
    final int NUMBER_OF_FRAMES = 10;

    BowlingGame(List<Frame> frames) {
        this.frames = frames;
    }

    public List<Frame> getFrames() {
        return frames;
    }

    public void setFrames(List<Frame> frames) {
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

    public int calculateScoreOfTheLine() {
        if (!isGameOver()) {
            throw new GameNotOverException();
        }
        int sum = 0;
        for (int i = 0; i < NUMBER_OF_FRAMES; i++) {
            sum += calculateScoreOfTheRound(this.frames.get(i));
        }
        return sum;
    }

    private boolean isGameOver() {
        if (frames == null) {
            return false;
        }
        int sizeOfFrames = frames.size();
        if (sizeOfFrames < NUMBER_OF_FRAMES) {
            return false;
        }
        if (sizeOfFrames == NUMBER_OF_FRAMES && frames.get(sizeOfFrames - 1).getStatus() != Frame.NO_STRIKE_AND_SPARE) {
            return false;
        }
        return sizeOfFrames != NUMBER_OF_FRAMES + 1 || frames.get(sizeOfFrames - 1).getStatus() != Frame.STRIKE;
    }
}
