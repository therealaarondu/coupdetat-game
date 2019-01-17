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
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import static com.mygdx.game.Main.skin;

public class optionsScreen implements Screen {

    private Stage optionsStage;
    private Game optionsGame;
    private OrthographicCamera camera;
    private Viewport viewport;

    public optionsScreen(Game aGame) {
        optionsGame = aGame;
        optionsStage = new Stage(new ScreenViewport());
        float stageWidth = optionsStage.getWidth();
        float stageHeight = optionsStage.getHeight();

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
                optionsGame.setScreen(new titleScreen(optionsGame));
            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        optionsStage.addActor(backButton);

        //video settings options
        TextButton videoOptionsButton = new TextButton("Video Settings", skin);
        videoOptionsButton.setSize((float) (stageWidth / 6), (float) (stageHeight / 6));

        // videoOptionsButton.setPosition(stageWidth / 2 - videoOptionsButton.getWidth() / 2, (float) (stageHeight / 1.5));
        videoOptionsButton.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                optionsGame.setScreen(new videoOptions(optionsGame));
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        optionsStage.addActor(videoOptionsButton);

        //sound settings
        TextButton soundOptionsButton = new TextButton("Sound Settings", skin);
        soundOptionsButton.setSize((float) (stageWidth / 6), (float) (stageHeight / 6));

        //soundOptionsButton.setPosition(stageWidth / 2 - videoOptionsButton.getWidth() / 2, (float) (stageHeight / 1.5 - videoOptionsButton.getHeight()));
        soundOptionsButton.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                optionsGame.setScreen(new soundOptions(optionsGame));
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        optionsStage.addActor(soundOptionsButton);

        //controls
        TextButton controlsOptionsButton = new TextButton("Controls", skin);
        controlsOptionsButton.setSize((float) (stageWidth / 6), (float) (stageHeight / 6));
        //  controlsOptionsButton.setPosition(stageWidth / 2 - videoOptionsButton.getWidth() / 2, (float) (stageHeight / 1.5 - (videoOptionsButton.getHeight() * 2)));
        controlsOptionsButton.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                optionsGame.setScreen(new controlsOptions(optionsGame));
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        optionsStage.addActor(controlsOptionsButton);

        //game settings
        TextButton gameSettingsButton = new TextButton("Game Settings", skin);
        gameSettingsButton.setSize((float) (stageWidth / 6), (float) (stageHeight / 6));

        // gameSettingsButton.setPosition(stageWidth / 2 - videoOptionsButton.getWidth() / 2, (float) (stageHeight / 1.5 - (videoOptionsButton.getHeight() * 3)));
        gameSettingsButton.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                optionsGame.setScreen(new gameOptions(optionsGame));
            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });

        Table table = new Table(skin);
        table.setFillParent(true);
        table.setDebug(true);

        table.add(videoOptionsButton).fillX().uniformX().width(stageWidth / 6).height(stageHeight / 6);
        table.row().padBottom(10).padTop(10);
        table.add(soundOptionsButton).fillX().uniformX().width(stageWidth / 6).height(stageHeight / 6);
        table.row().padBottom(10);
        table.add(controlsOptionsButton).fillX().uniformX().width(stageWidth / 6).height(stageHeight / 6);
        table.row().padBottom(10);
        table.add(gameSettingsButton).fillX().uniformX().width(stageWidth / 6).height(stageHeight / 6);
        optionsStage.addActor(table);

        camera = new OrthographicCamera();
        viewport = new FitViewport(stageWidth, stageHeight, camera);

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(optionsStage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(142 / 255f, 101 / 255f, 31 / 255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        optionsStage.act();
        optionsStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        optionsStage.getViewport().update(width, height, true);
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
        optionsStage.dispose();
    }
}
