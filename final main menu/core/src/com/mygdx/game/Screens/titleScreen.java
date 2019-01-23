package com.mygdx.game.Screens;

//use tables for everything

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.Game.*;
import com.mygdx.game.Screens.*;
import com.mygdx.game.Main;


import javax.xml.soap.Text;

import static com.mygdx.game.Main.skin;

public class titleScreen implements Screen {

    private Stage titleStage;
    final Game titleGame;

    private OrthographicCamera camera;
    private Viewport viewport;
    public SpriteBatch batch;
    public Texture background;

    public static final int DEFAULT_SPEED = 80;
    public static final int ACCELERATION = 50;
    public static final int GOAL_REACH_ACCELERATION = 200;
    float y1, y2;
    int speed;//In pixels / second
    int goalSpeed;
    float imageScale;
    boolean speedFixed;


    public titleScreen(Game aGame) {
        batch = new SpriteBatch();


        titleGame = aGame;
        titleStage = new Stage(new ScreenViewport());
        float stageWidth = titleStage.getWidth();
        float stageHeight = titleStage.getHeight();
        System.out.println(stageWidth);
        System.out.println(stageHeight);


        Texture test = new Texture("newtitle2.png");
        Image test1 = new Image(test);
        test1.setPosition(stageWidth / 2 - test1.getWidth() / 2, (float) (stageHeight / 1.3));
        titleStage.addActor(test1);

        background = new Texture("background.jpg");
        y1 = 0;
        y2 = background.getHeight();
        speed = 0;
        goalSpeed = DEFAULT_SPEED;
        imageScale = Gdx.graphics.getHeight() / background.getHeight();
        speedFixed = true;


        //play Button
        TextButton playButton = new TextButton("Play Flying Sword", skin);
        playButton.setSize((float) (stageWidth / 6), (float) (stageHeight / 6));
        //playButton.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture("icons/play.png")));
        //playButton.getStyle().imageOver = new TextureRegionDrawable((new TextureRegion(new Texture("icons/play-hover.png"))));
        //playButton.getStyle().imageDown = new TextureRegionDrawable((new TextureRegion(new Texture("icons/play-pressed.png"))));
        //  playButton.setPosition(stageWidth / 2 - playButton.getWidth() / 2, stageHeight / 2);


        playButton.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        titleStage.addActor(playButton);

        //play Button
        TextButton playMahjong = new TextButton("Play Mahjong", skin);
        playMahjong.setSize((float) (stageWidth / 6), (float) (stageHeight / 6));
        //playButton.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture("icons/play.png")));
        //playButton.getStyle().imageOver = new TextureRegionDrawable((new TextureRegion(new Texture("icons/play-hover.png"))));
        //playButton.getStyle().imageDown = new TextureRegionDrawable((new TextureRegion(new Texture("icons/play-pressed.png"))));
        //  playButton.setPosition(stageWidth / 2 - playButton.getWidth() / 2, stageHeight / 2);

        playMahjong.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                titleGame.setScreen(new playScreen(titleGame));
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        titleStage.addActor(playMahjong);


        //multiplayerButton
        TextButton multiplayerButton = new TextButton("Multiplayer", skin);
        multiplayerButton.setSize((float) (stageWidth / 6), (float) (stageHeight / 6));
        //  multiplayerButton.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture("icons/multiplayer.png")));
        // multiplayerButton.getStyle().imageOver = new TextureRegionDrawable(new TextureRegion(new Texture("icons/multiplayer-hover.png")));
        // multiplayerButton.getStyle().imageDown = new TextureRegionDrawable(new TextureRegion(new Texture("icons/multiplayer-pressed.png")));
        // multiplayerButton.setPosition(stageWidth / 2 - multiplayerButton.getWidth() / 2, (stageHeight / 2 - playButton.getHeight()));
        multiplayerButton.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                titleGame.setScreen(new multiplayerScreen(titleGame));
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        titleStage.addActor(multiplayerButton);


        //options button
   /*     TextButton optionsButton = new TextButton("Options", skin);
        optionsButton.setSize((float) (stageWidth / 10), (float) (stageHeight / 10));
        // optionsButton.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture("icons/options.png")));
        //optionsButton.getStyle().imageOver = new TextureRegionDrawable(new TextureRegion(new Texture("icons/options-hover.png")));
        //optionsButton.getStyle().imageDown = new TextureRegionDrawable(new TextureRegion(new Texture("icons/options-pressed.png")));
        // optionsButton.setPosition(stageWidth / 2 - optionsButton.getWidth() / 2, (stageHeight / 2 - (playButton.getHeight()) * 2));
        optionsButton.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                titleGame.setScreen(new optionsScreen(titleGame));
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        titleStage.addActor(optionsButton);
    */
     /*   //info button
        TextButton infoButton = new TextButton("?", skin);
        infoButton.setSize((float) (stageWidth / 10), (float) (stageHeight / 10));
        infoButton.setPosition(0, 0);
        infoButton.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                titleGame.setScreen(new infoScreen(titleGame));
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        titleStage.addActor(infoButton);
        */

        //exit button
        TextButton exitButton = new TextButton("Exit", skin);
        exitButton.setSize((float) (stageWidth / 10), (float) (stageHeight / 10));
        exitButton.setPosition(stageWidth - exitButton.getWidth(), 0);
        exitButton.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.exit();
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        titleStage.addActor(exitButton);

        Table table = new Table();
        table.setFillParent(true);
        //  table.setDebug(true);
        titleStage.addActor(table);

        table.add(playButton).fillX().uniformX().width(stageWidth / 6).height(stageHeight / 6);
        table.row().pad(10, 0, 10, 0);
        table.add(playMahjong).fillX().uniformX().width(stageWidth / 6).height(stageHeight / 6);
        table.row();
        table.add(multiplayerButton).fillX().uniformX().width(stageWidth / 6).height(stageHeight / 6);
        table.row();
        //  table.add(optionsButton).fillX().uniformX().width(stageWidth / 6).height(stageHeight / 6);


        camera = new OrthographicCamera();
        viewport = new FitViewport(stageWidth, stageHeight, camera);


    }


    @Override
    public void show() {
        Gdx.input.setInputProcessor(titleStage);
    }

    @Override
    public void render(float delta) {
        //Speed adjustment to reach goal
        if (speed < goalSpeed) {
            speed += GOAL_REACH_ACCELERATION * delta;
            if (speed > goalSpeed)
                speed = goalSpeed;
        } else if (speed > goalSpeed) {
            speed -= GOAL_REACH_ACCELERATION * delta;
            if (speed < goalSpeed)
                speed = goalSpeed;
        }
        if (!speedFixed)
            speed += ACCELERATION * delta;
        y1 -= speed * delta;
        y2 -= speed * delta;
        //if image reached the bottom of screen and is not visible, put it back on top
        if (y1 + background.getHeight() * imageScale <= 0)
            y1 = y2 + background.getHeight() * imageScale;
        if (y2 + background.getHeight() * imageScale <= 0)
            y2 = y1 + background.getHeight() * imageScale;
        Gdx.gl.glClearColor(142 / 255f, 101 / 255f, 31 / 255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(background, 0, y1, Gdx.graphics.getWidth(), background.getHeight() * 2);
        batch.draw(background, 0, y2, Gdx.graphics.getWidth(), background.getHeight() * 2);
        batch.end();


        titleStage.act();
        titleStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        titleStage.getViewport().update(width, height, true);

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        titleStage.dispose();
        batch.dispose();
    }
}
