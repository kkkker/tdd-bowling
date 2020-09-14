import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingGameTest {
    private static List<Frame> frames = new ArrayList<>();
    private static BowlingGame bowlingGame;
    static {
        frames.add(new Frame(10 , 0));
        frames.add(new Frame(6 , 4));
        frames.add(new Frame(3 , 2));
        frames.add(new Frame(10 , 0));
        frames.add(new Frame(10 , 0));
        frames.add(new Frame(6 , 1));
        frames.add(new Frame(10 , 0));
        frames.add(new Frame(10 , 0));
        frames.add(new Frame(10 , 0));
        frames.add(new Frame(10 , 0));
        frames.add(new Frame(10 , 0));
        frames.add(new Frame(10 , 0));
        bowlingGame= new BowlingGame(frames);
    }

    @Test
    void should_return_number_of_knockdown_bottles_when_no_strike_and_spare() {
        //Given
        Frame frameWithNoStrikeAndSpare = frames.get(2);
        //When
        int result = bowlingGame.calculateScoreOfTheRound(frameWithNoStrikeAndSpare);
        //Then
        assertEquals(5, result);
    }
}
