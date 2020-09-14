import java.util.ArrayList;
import java.util.List;

public class Frame {
    private List<Integer> numbersOfKnockdownBottles = new ArrayList<>();
    private int status;
    private static int STRIKE = 0;
    private static int SPARE = 1;
    private static int NO_STRIKE_AND_SPARE = 2;
    public static int FIRST = 0;
    public static int SECOND = 1;

    public Frame(int first, int second) {
        numbersOfKnockdownBottles.add(first);
        numbersOfKnockdownBottles.add(second);
        if (first == 10) {
            status = Frame.STRIKE;
        }else if (first + second == 10) {
            status = Frame.SPARE;
        } else {
            status = Frame.NO_STRIKE_AND_SPARE;
        }
    }

    public List<Integer> getNumbersOfKnockdownBottles() {
        return numbersOfKnockdownBottles;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
