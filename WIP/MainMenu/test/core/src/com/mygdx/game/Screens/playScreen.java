package com.mygdx.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import static com.mygdx.game.Main.skin;

public class playScreen implements Screen {
    private Stage playStage;
    private Game playGame;


    private OrthographicCamera camera;
    private Viewport viewport;

    public playScreen(Game aGame) {

        playGame = aGame;
        playStage = new Stage((new ScreenViewport()));

        float stageWidth = playStage.getWidth();
        float stageHeight = playStage.getHeight();
        //new game button
        TextButton newGame = new TextButton("New Game", skin);
        newGame.setSize(stageWidth / 6, stageHeight / 6);
        newGame.setPosition(stageWidth / 2 - newGame.getWidth() / 2, stageHeight / 2);
        playStage.addActor(newGame);


        //back button
        ImageButton backButton = new ImageButton(skin);
        backButton.setSize((float) (stageWidth/10), (float) (stageHeight/10));
        System.out.println(backButton.getWidth() + " " + backButton.getHeight());
        backButton.getStyle().imageUp = new TextureRegionDrawable((new TextureRegion(new Texture("icons/back.png"))));
        backButton.getStyle().imageOver = new TextureRegionDrawable((new TextureRegion(new Texture("icons/back-hover.png"))));
        backButton.getStyle().imageDown = new TextureRegionDrawable((new TextureRegion(new Texture("icons/back-pressed.png"))));
        backButton.setPosition(0, stageHeight- backButton.getHeight());
        backButton.addListener(new InputListener(){
            @Override

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                playGame.setScreen(new titleScreen(playGame));
            }

            @Override

            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;

            }


        });
        playStage.addActor(backButton);





        camera = new OrthographicCamera();
        viewport = new FitViewport(stageWidth, stageHeight, camera);


    }

    @Override
    public void show() {
        Gdx.app.log("MainScreen", "show");
        Gdx.input.setInputProcessor(playStage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(142 / 255f, 101 / 255f, 31 / 255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        playStage.act();
        playStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        playStage.getViewport().update(width, height, false);

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
        playStage.dispose();
    }
}
