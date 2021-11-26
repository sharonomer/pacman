package tests;

import model.*;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class PacmanTest {

    @Test
    public void trueAnswerTest() {
        Answer testAnswer = new Answer("abc", true);
        assertTrue(testAnswer.isCorrect());
    }

    @Test
    public void pacmanLevelTest() {
        assertEquals(1, levelCheck(0));
        assertEquals(1, levelCheck(50));
        assertEquals(2, levelCheck(51));
        assertEquals(2, levelCheck(100));
        assertEquals(3, levelCheck(101));
        assertEquals(3, levelCheck(150));
        assertEquals(4, levelCheck(151));
        assertEquals(4, levelCheck(200));
        assertEquals(4, levelCheck(201));
        assertEquals(4, levelCheck(400));
    }

    @Test
    public void testGameOver() {
        String result = collisionTest(false, 1);
        assertEquals("true,0", result);
    }

    @Test
    public void testLifeLoss() {
        String result = collisionTest(false, 2);
        assertEquals("false,1", result);
    }

    @Test
    public void testDeadGhostCollision() {
        String result = collisionTest(true, 3);
        assertEquals("false,3", result);
    }

    public int levelCheck(int score) {
        int level;
        switch ((int) (score - 1) / 50) {
            case 0:
                level = 1;
                return level;
            case 1:
                level = 2;
                return level;
            case 2:
                level = 3;
                return level;
            case 3:
                level = 4;
                return level;
            default:
                return 4;
        }
    }

    public String collisionTest(boolean ghostDead, int life) {
        boolean isGameOver = false;
        Rectangle pr = new Rectangle(1, 1, 50, 50);
        ArrayList<Ghost> ghosts = new ArrayList<Ghost>();
        ghosts.add(new Ghost(1, 1));
        for (Ghost g : ghosts) {
            Rectangle gr = new Rectangle(g.pixelPosition.x, g.pixelPosition.y, 28, 28);
            if (ghostDead)
                g.die();
            if (pr.intersects(gr)) {
                if (!g.isDead()) {
                    if (life == 0) {
                        //Game Over
                        isGameOver = true;
                        break;
                    } else {
                        life--;
                        if (life == 0)
                            isGameOver = true;
                    }
                }
            }
        }
        return isGameOver + "," + life;
    }

    public static class Ghost {
        protected boolean isDead = false;

        public boolean isDead() {
            return isDead;
        }

        public Point pixelPosition;

        public Ghost(int x, int y) {

            pixelPosition = new Point(x,y);
        }

        public void die(){
            isDead = true;
        }
    }
}
