package tests;
import controller.Game;
import model.Answer;
import model.Ghost;
import model.Pacman;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class PacmanTest {

    @Test
    public void sum(){
        int c = 5;
        int d = 7;
        assertEquals(c+d,12);
    }

    @Test
    public void trueAnswerTest(){
        Answer testAnswer = new Answer("abc", true);
        assertTrue(testAnswer.isCorrect);
    }

    public int levelCheck(int score) {
        int level;
        switch ((int) score / 50) {
            case 0:
                level = 1;
                return level;
            case 1:
                level = 2;
                if (score == 50)
                    level = 1;
                return level;
            case 2:
                level = 3;
                return level;
            case 3:
                level = 4;
                return level;
            default:
                return -1;
        }
    }

    @Test
    public void pacmanLevelTest(){
        assertEquals(1 ,levelCheck(50));
        assertEquals(2 ,levelCheck(51));
        assertEquals(3 ,levelCheck(100));
        assertEquals(3 ,levelCheck(101));
        assertEquals(3 ,levelCheck(150));
        assertEquals(4 ,levelCheck(151));
        assertEquals(-1 ,levelCheck(400));
    }
}
