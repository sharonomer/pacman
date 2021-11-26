package tests;
import controller.Game;
import model.Answer;
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

    /*@Test
    public void pacmanLivesTest(){
        Pacman p = new Pacman(0,0, new Game);
        assertTrue(testAnswer.isCorrect);
    }*/
}
