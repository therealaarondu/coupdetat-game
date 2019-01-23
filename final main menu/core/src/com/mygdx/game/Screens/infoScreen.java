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
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import static com.mygdx.game.Main.skin;

public class infoScreen implements Screen {
    private Stage infoScreenStage;
    private Game infoScreenGame;

    private OrthographicCamera camera;
    private Viewport viewport;

    public infoScreen(Game aGame) {
        infoScreenGame = aGame;
        infoScreenStage = new Stage(new ScreenViewport());

        Skin skin = new Skin(Gdx.files.internal(("skin/flat-earth-ui.json")));

        float stageWidth = infoScreenStage.getWidth();
        float stageHeight = infoScreenStage.getHeight();

        //back button
        ImageButton backButton = new ImageButton(skin);
        backButton.setSize((float) (stageWidth / 10), (float) (stageHeight / 10));
        backButton.getStyle().imageUp = new TextureRegionDrawable((new TextureRegion(new Texture("icons/back.png"))));
        backButton.getStyle().imageOver = new TextureRegionDrawable((new TextureRegion(new Texture("icons/back-hover.png"))));
        backButton.getStyle().imageDown = new TextureRegionDrawable((new TextureRegion(new Texture("icons/back-pressed.png"))));
        backButton.setPosition(0, stageHeight - backButton.getHeight());
        backButton.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                infoScreenGame.setScreen(new titleScreen(infoScreenGame));
            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        infoScreenStage.addActor(backButton);

        //info text
        TextArea infoText = new TextArea("Thank for trying out our game! This game was made by Aaron Du, " +
                "Kevin Ma, David Jiang and Daniel Abdi", skin);
        infoText.setAlignment(Align.center);
        infoText.setScale(2, 2);
        infoText.setSize((float) (stageWidth / 10), (float) (stageHeight / 10));
        infoText.setPosition(stageWidth/2 - infoText.getWidth()/2, stageHeight/2);
        infoScreenStage.addActor(infoText);




        camera = new OrthographicCamera();
        viewport = new FitViewport(stageWidth, stageHeight, camera);


    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(infoScreenStage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(142 / 255f, 101 / 255f, 31 / 255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        infoScreenStage.act();
        infoScreenStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        infoScreenStage.getViewport().update(width, height, false);
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
        infoScreenStage.dispose();
    }
}
