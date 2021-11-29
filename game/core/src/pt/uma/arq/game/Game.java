package pt.uma.arq.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.entities.*;

import java.util.ArrayList;


public class Game extends ApplicationAdapter {
    private SpriteBatch batch;
    private BackgroundManagement backgroundManagement;
    private BitmapFont font;
    private ArrayList<BlockExample> blockList;
    private Board board;
    private PlayerPaddle paddle;
    private Ball ball;


    @Override
    public void create() {
        Gdx.graphics.setWindowedMode(1280, 720);
        batch = new SpriteBatch();

        backgroundManagement = new BackgroundManagement(batch);
        font = new BitmapFont(Gdx.files.internal("gamefont.fnt"),
                Gdx.files.internal("gamefont.png"), false);

        board = new Board(batch);
        board.create();
        paddle = new PlayerPaddle(batch);
        paddle.create();
        ball = new Ball(batch);
        ball.create();


    }

    @Override
    public void render() {

        // Render
        batch.begin();
        backgroundManagement.render();

        //detetar teclas
        paddle.manageUserInput();
        ball.ballMovement(paddle);
        board.checkCollisions(ball);

        //desenhar
        board.render();
        paddle.render();
        ball.render();

        batch.end();



    }

    @Override
    public void dispose() {
        batch.dispose();
    }

}