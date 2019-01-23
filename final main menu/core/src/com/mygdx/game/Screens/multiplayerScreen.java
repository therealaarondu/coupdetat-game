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
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import static com.mygdx.game.Main.skin;

public class multiplayerScreen implements Screen {


    private Stage multiplayerStage;
    private Game multiplayerGame;

    private OrthographicCamera camera;
    private Viewport viewport;

    public multiplayerScreen(Game aGame) {
        multiplayerGame = aGame;
        multiplayerStage = new Stage(new ScreenViewport());

        float stageWidth = multiplayerStage.getWidth();
        float stageHeight = multiplayerStage.getHeight();

        //back button
        ImageButton backButton = new ImageButton(skin);
        backButton.setSize((float) (stageWidth/10), (float) (stageHeight/10));
        backButton.getStyle().imageUp = new TextureRegionDrawable((new TextureRegion(new Texture("icons/back.png"))));
        backButton.getStyle().imageOver = new TextureRegionDrawable((new TextureRegion(new Texture("icons/back-hover.png"))));
        backButton.getStyle().imageDown = new TextureRegionDrawable((new TextureRegion(new Texture("icons/back-pressed.png"))));
        backButton.setPosition(0, stageHeight- backButton.getHeight());
        backButton.addListener(new InputListener(){
            @Override

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                multiplayerGame.setScreen(new titleScreen(multiplayerGame));
            }

            @Override

            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;

            }


        });
        multiplayerStage.addActor(backButton);





        camera = new OrthographicCamera();
        viewport = new FitViewport(stageWidth, stageHeight, camera);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(multiplayerStage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(142 / 255f, 101 / 255f, 31 / 255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        multiplayerStage.act();
        multiplayerStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        multiplayerStage.getViewport().update(width, height, false);

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
        multiplayerStage.dispose();
    }
}
