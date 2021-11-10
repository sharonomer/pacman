package controller;

import misc.*;
import model.*;
import view.PacWindow;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Game extends JPanel {


    public Timer redrawTimer;
    public ActionListener redrawAL;

    public int[][] map;
    public Image[] mapSegments;

    public Image foodImage;
    public Image[] pfoodImage;

    public Image goImage;
    public Image vicImage;

    public Pacman pacman;
    public ArrayList<Food> foods;
    public ArrayList<Food> eatenFoods;
    public ArrayList<PowerUpFood> pufoods;
    public ArrayList<Ghost> ghosts;
    public ArrayList<TeleportTunnel> teleports;

    public boolean isCustom = false;
    public boolean isGameOver = false;
    public boolean isWin = false;
    public boolean drawScore = false;
    public boolean clearScore = false;
    public int scoreToAdd = 0;

    public int level = 1;
    public int score;
    public JLabel scoreboard;

    public LoopPlayer siren;
    public boolean mustReactivateSiren = false;
    public LoopPlayer pac6;

    public Point ghostBase;

    public int m_x;
    public int m_y;

//    public MapData md_backup;
    public PacWindow windowParent;

    public Game(JLabel scoreboard, MapData md, PacWindow pw) {
        this.scoreboard = scoreboard;
        this.setDoubleBuffered(true);
//        md_backup = md;
        windowParent = pw;

        m_x = md.getX();
        m_y = md.getY();
        this.map = md.getMap();

        this.isCustom = md.isCustom();
        this.ghostBase = md.getGhostBasePosition();

        //loadMap();

        pacman = new Pacman(md.getPacmanPosition().x, md.getPacmanPosition().y, this);
        addKeyListener(pacman);

        foods = new ArrayList<>();
        eatenFoods = new ArrayList<>();
        pufoods = new ArrayList<>();
        ghosts = new ArrayList<>();
        teleports = new ArrayList<>();

        //TODO : read food from mapData (Map 1)

        if (!isCustom) {
            for (int i = 0; i < m_x; i++) {
                for (int j = 0; j < m_y; j++) {
                    if (map[i][j] == 0)
                        foods.add(new Food(i, j));
                }
            }
        } else {
            foods = md.getFoodPositions();
        }

        pufoods = md.getPufoodPositions();

        /*
        * Creation of ghosts.
        * */
        ghosts = new ArrayList<>();
        for (GhostData gd : md.getGhostsData()) {
            switch (gd.getType()) {
                case RED:
                    ghosts.add(new RedGhost(gd.getX(), gd.getY(), this));
                    break;
                case PINK:
                    ghosts.add(new PinkGhost(gd.getX(), gd.getY(), this));
                    break;
                case CYAN:
                    ghosts.add(new CyanGhost(gd.getX(), gd.getY(), this));
                    break;
            }
        }

        teleports = md.getTeleports();

        setLayout(null);
        setSize(20 * m_x, 20 * m_y);
        setBackground(Color.black);

        mapSegments = new Image[28];
        mapSegments[0] = null;
        for (int ms = 1; ms < 28; ms++) {
            try {
                mapSegments[ms] = ImageIO.read(this.getClass().getResource("/resources/images/map segments/" + ms + ".png"));
            } catch (Exception e) {
            }
        }

        pfoodImage = new Image[5];
        for (int ms = 0; ms < 5; ms++) {
            try {
                pfoodImage[ms] = ImageIO.read(this.getClass().getResource("/resources/images/food/" + ms + ".png"));
            } catch (Exception e) {
            }
        }
        try {
            foodImage = ImageIO.read(this.getClass().getResource("/resources/images/food.png"));
            goImage = ImageIO.read(this.getClass().getResource("/resources/images/gameover.png"));
            vicImage = ImageIO.read(this.getClass().getResource("/resources/images/victory.png"));
            //pfoodImage = ImageIO.read(this.getClass().getResource("/images/pfood.png"));
        } catch (Exception e) {
        }


        redrawAL = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //Draw Board
                repaint();
            }
        };
        redrawTimer = new Timer(16, redrawAL);
        redrawTimer.start();

        //SoundPlayer.play("pacman_start.wav");
        siren = new LoopPlayer("siren.wav");
        pac6 = new LoopPlayer("pac6.wav");
        siren.start();
    }

    /*
    * Checks if the pacman's rectangle collides with any of the ghosts' rectangles.
    * */
    public void collisionTest() {
        Rectangle pr = new Rectangle(pacman.pixelPosition.x + 13, pacman.pixelPosition.y + 13, 2, 2);
        Ghost ghostToRemove = null;
        for (Ghost g : ghosts) {
            Rectangle gr = new Rectangle(g.pixelPosition.x, g.pixelPosition.y, 28, 28);

            if (pr.intersects(gr)) {
                if (!g.isDead()) {
                    if (!g.isWeak()) {
                        //Game Over
                        siren.stop();
                        SoundPlayer.play("pacman_lose.wav");
                        pacman.moveTimer.stop();
                        pacman.animTimer.stop();
                        g.moveTimer.stop();
                        isGameOver = true;
                        scoreboard.setText("    Press R to try again !");
                        //scoreboard.setForeground(Color.red);
                        break;
                    } else {
                        //Eat Ghost
                        SoundPlayer.play("pacman_eatghost.wav");
                        //getGraphics().setFont(new Font("Arial",Font.BOLD,20));
                        drawScore = true;
                        scoreToAdd++;
                        if (ghostBase != null)
                            g.die();
                        else
                            ghostToRemove = g;
                    }
                }
            }
        }

        if (ghostToRemove != null) {
            ghosts.remove(ghostToRemove);
        }
    }

    /*
    * Checks the current game's level.
    * */
    public void levelCheck() {
        switch ((int) score / 50) {
            case 0:
                level = 1;
                break;
            case 1:
                level = 2;
                break;
            case 2:
                level = 3;
                break;
            case 3:
                level = 4;
                break;
            default:
                break;
        }
    }

    /*
    * Updates the game screen.
    * */
    public void update() {
        Food foodToEat = null;
        //Check food eat
        for (Food f : foods) {
            if (pacman.logicalPosition.x == f.position.x && pacman.logicalPosition.y == f.position.y && !f.isEaten()) {
                f.setEaten(true);
                f.setEatenTime(System.currentTimeMillis());
                foodToEat = f;
            }
        }
        if (foodToEat != null) {
            SoundPlayer.play("pacman_eat.wav");
            eatenFoods.add(foodToEat);
            foods.remove(foodToEat);
            score++;
            levelCheck();
            scoreboard.setText("    Score : " + score + "    Level : " + level);

        }
        ArrayList<Food> remainingFoodsToRespawn = new ArrayList<Food>();
        for (Food f : eatenFoods) {
            long nowMillis = System.currentTimeMillis();
            if ((int) ((nowMillis - f.getEatenTime()) / 1000) >= 30) {
                foods.add(new Food((int) f.getPosition().getX(), (int) f.getPosition().getY()));
            } else {
                remainingFoodsToRespawn.add(f);
            }
        }
        eatenFoods = remainingFoodsToRespawn;


        PowerUpFood puFoodToEat = null;
        //Check pu food eat
        for (PowerUpFood puf : pufoods) {
            if (pacman.logicalPosition.x == puf.position.x && pacman.logicalPosition.y == puf.position.y)
                puFoodToEat = puf;
        }
        if (puFoodToEat != null) {
            //SoundPlayer.play("pacman_eat.wav");
            switch (puFoodToEat.type) {
                case 0:
                    //PACMAN 6
                    pufoods.remove(puFoodToEat);
                    siren.stop();
                    mustReactivateSiren = true;
                    pac6.start();
                    for (Ghost g : ghosts) {
                        g.weaken();
                    }
                    scoreToAdd = 0;
                    break;
                default:
                    SoundPlayer.play("pacman_eatfruit.wav");
                    pufoods.remove(puFoodToEat);
                    scoreToAdd = 1;
                    drawScore = true;
            }
        }

        //Check Ghost Undie
        for (Ghost g : ghosts) {
            if (g.isDead() && g.logicalPosition.x == ghostBase.x && g.logicalPosition.y == ghostBase.y) {
                g.undie();
            }
        }

        //Check Teleport
        for (TeleportTunnel tp : teleports) {
            if (pacman.logicalPosition.x == tp.getFrom().x && pacman.logicalPosition.y == tp.getFrom().y && pacman.activeMove == tp.getReqMove()) {
                System.out.println("TELEPORT!");
                pacman.logicalPosition = tp.getTo();
                pacman.pixelPosition.x = pacman.logicalPosition.x * 28;
                pacman.pixelPosition.y = pacman.logicalPosition.y * 28;
            }
        }

        //Check isSiren
        boolean isSiren = true;
        for (Ghost g : ghosts) {
            if (g.isWeak()) {
                isSiren = false;
                break;
            }
        }
        if (isSiren) {
            pac6.stop();
            if (mustReactivateSiren) {
                mustReactivateSiren = false;
                siren.start();
            }

        }


    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Draw Walls
        g.setColor(Color.blue);
        for (int i = 0; i < m_x; i++) {
            for (int j = 0; j < m_y; j++) {
                if (map[i][j] > 0) {
                    //g.drawImage(10+i*28,10+j*28,28,28);
                    g.drawImage(mapSegments[map[i][j]], 10 + i * 28, 10 + j * 28, null);
                }
            }
        }

        //Draw Food
        g.setColor(new Color(204, 122, 122));
        for (Food f : foods) {
            //g.fillOval(f.position.x*28+22,f.position.y*28+22,4,4);
            g.drawImage(foodImage, 10 + f.position.x * 28, 10 + f.position.y * 28, null);
        }

        //Draw PowerUpFoods
        g.setColor(new Color(204, 174, 168));
        for (PowerUpFood f : pufoods) {
            g.drawImage(pfoodImage[f.type], 10 + f.position.x * 28, 10 + f.position.y * 28, null);
        }

        //Draw Pacman
        switch (pacman.activeMove) {
            case NONE:
            case RIGHT:
                g.drawImage(pacman.getPacmanImage(), 10 + pacman.pixelPosition.x, 10 + pacman.pixelPosition.y, null);
                break;
            case LEFT:
                g.drawImage(ImageHelper.flipHor(pacman.getPacmanImage()), 10 + pacman.pixelPosition.x, 10 + pacman.pixelPosition.y, null);
                break;
            case DOWN:
                g.drawImage(ImageHelper.rotate90(pacman.getPacmanImage()), 10 + pacman.pixelPosition.x, 10 + pacman.pixelPosition.y, null);
                break;
            case UP:
                g.drawImage(ImageHelper.flipVer(ImageHelper.rotate90(pacman.getPacmanImage())), 10 + pacman.pixelPosition.x, 10 + pacman.pixelPosition.y, null);
                break;
        }

        //Draw Ghosts
        for (Ghost gh : ghosts) {
            g.drawImage(gh.getGhostImage(), 10 + gh.pixelPosition.x, 10 + gh.pixelPosition.y, null);
        }

        if (clearScore) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            drawScore = false;
            clearScore = false;
        }

        if (drawScore) {
            g.setFont(new Font("Arial", Font.BOLD, 15));
            g.setColor(Color.yellow);
            Integer s = scoreToAdd * 100;
            g.drawString(s.toString(), pacman.pixelPosition.x + 13, pacman.pixelPosition.y + 50);
            score += s;
            levelCheck();
            scoreboard.setText("    Score : " + score + "    Level : " + level);
            clearScore = true;

        }

        if (isGameOver && score < 200) {
            g.drawImage(goImage, this.getSize().width / 2 - 315, this.getSize().height / 2 - 75, null);
        }

        if (isWin) {
            g.drawImage(vicImage, this.getSize().width / 2 - 315, this.getSize().height / 2 - 75, null);
        }


    }


    /*
    * Processes collisions, game-overs and win condition.
    * */
    @Override
    public void processEvent(AWTEvent ae) {
        if (ae.getID() == Messages.UPDATE) {
            update();
            if (score >= 200) {
                siren.stop();
                pac6.stop();
                SoundPlayer.play("pacman_intermission.wav");
                isWin = true;
                isGameOver = true;
                pacman.moveTimer.stop();
                for (Ghost g : ghosts) {
                    g.moveTimer.stop();
                }
                scoreboard.setText("    Press R to try again !");
            }
        } else if (ae.getID() == Messages.COLTEST) {
            if (!isGameOver) {
                collisionTest();

            }
        } else if (ae.getID() == Messages.RESET) {
            if (isGameOver)
                restart();
        } else {
            super.processEvent(ae);
        }
    }

    /*
    * Restarts the game.
    * */
    public void restart() {

        siren.stop();

        new PacWindow();
        windowParent.dispose();
    }


}