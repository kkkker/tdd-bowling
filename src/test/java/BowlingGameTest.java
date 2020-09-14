import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void should_return_ten_plus_the_number_of_first_knockdown_bottles_of_next_frame_when_spare() {
        //Given
        Frame frameWithSpare = frames.get(1);
        //When
        int result = bowlingGame.calculateScoreOfTheRound(frameWithSpare);
        //Then
        assertEquals(13, result);
    }

    @Test
    void should_return_twenty_plus_the_number_of_first_knockdown_bottles_of_the_second_next_frame_when_double_strike() {
        //Given
        Frame frameWithDoubleStrike = frames.get(3);
        //When
        int result = bowlingGame.calculateScoreOfTheRound(frameWithDoubleStrike);
        //Then
        assertEquals(26, result);
    }

    @Test
    void should_return_ten_plus_the_number_of_next_knockdown_bottles_when_only_one_strike() {
        //Given
        Frame frameWithOneStrikeSpare = frames.get(0);
        //When
        int result = bowlingGame.calculateScoreOfTheRound(frameWithOneStrikeSpare);
        //Then
        assertEquals(20, result);
    }

    @Test
    void should_return_ten_plus_the_score_of_the_line_when_game_over() {
        //Given
        //When
        int result = bowlingGame.calculateScoreOfTheLine();
        //Then
        assertEquals(208, result);
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
