import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BowlingGameTest {

    @Test
    void should_return_the_score_of_the_line_when_game_over() {
        //Given
        List<Frame> frames = new ArrayList<>();
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
        BowlingGame bowlingGame= new BowlingGame(frames);
        //When
        int result = bowlingGame.calculateScoreOfTheLine();
        //Then
        assertEquals(208, result);
    }

    @Test
    void should_return_300_when_every_frame_is_strike() {
        //Given
        List<Frame> frames = new ArrayList<>();
        frames.add(new Frame(10 , 0));
        frames.add(new Frame(10 , 0));
        frames.add(new Frame(10 , 0));
        frames.add(new Frame(10 , 0));
        frames.add(new Frame(10 , 0));
        frames.add(new Frame(10 , 0));
        frames.add(new Frame(10 , 0));
        frames.add(new Frame(10 , 0));
        frames.add(new Frame(10 , 0));
        frames.add(new Frame(10 , 0));
        frames.add(new Frame(10 , 0));
        frames.add(new Frame(10 , 0));
        BowlingGame bowlingGame= new BowlingGame(frames);
        //When
        int result = bowlingGame.calculateScoreOfTheLine();
        //Then
        assertEquals(300, result);
    }

    @Test
    void should_return_zero_when_every_frame_is_zero() {
        //Given
        List<Frame> frames = new ArrayList<>();
        frames.add(new Frame(0 , 0));
        frames.add(new Frame(0 , 0));
        frames.add(new Frame(0 , 0));
        frames.add(new Frame(0 , 0));
        frames.add(new Frame(0 , 0));
        frames.add(new Frame(0 , 0));
        frames.add(new Frame(0 , 0));
        frames.add(new Frame(0 , 0));
        frames.add(new Frame(0 , 0));
        frames.add(new Frame(0 , 0));
        frames.add(new Frame(0 , 0));
        frames.add(new Frame(0 , 0));
        BowlingGame bowlingGame= new BowlingGame(frames);
        //When
        int result = bowlingGame.calculateScoreOfTheLine();
        //Then
        assertEquals(0, result);
    }

    @Test
    void should_throw_game_not_over_exception_when_game_not_over() {
        assertThrows(GameNotOverException.class, () -> {
            List<Frame> frames = new ArrayList<>();
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
            BowlingGame notOverBowlingGame = new BowlingGame(frames);
            notOverBowlingGame.calculateScoreOfTheLine();
        });
    }
}
