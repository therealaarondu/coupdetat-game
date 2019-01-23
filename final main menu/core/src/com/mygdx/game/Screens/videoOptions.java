package com.mygdx.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import static com.mygdx.game.Main.skin;

public class videoOptions implements Screen {
    private Stage videoOptionsStage;
    private Game videoOptionsGame;

    private OrthographicCamera camera;
    private Viewport viewport;

    public videoOptions(Game aGame) {

        videoOptionsGame = aGame;
        videoOptionsStage = new Stage(new ScreenViewport());
        float stageWidth = videoOptionsStage.getWidth();
        float stageHeight = videoOptionsStage.getHeight();

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
                videoOptionsGame.setScreen(new optionsScreen(videoOptionsGame));
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        videoOptionsStage.addActor(backButton);

        Skin skin = new Skin(Gdx.files.internal(("skin/flat-earth-ui.json")));


        //fullscreen label
        Label fullscreenLabel = new Label("Fullscreen/Windowed", skin);
        fullscreenLabel.setAlignment(Align.center);
        fullscreenLabel.setFontScale((float) 1.5);
        videoOptionsStage.addActor(fullscreenLabel);

        //fullscreen selectbox
        SelectBox fullScreen = new SelectBox(skin);
        String screenOptions[] = {"Fullscreen", "Windowed"};
        fullScreen.setItems(screenOptions);
        fullScreen.setPosition(stageHeight / 2, stageHeight / 2);
        fullScreen.setAlignment(Align.center);
        fullScreen.setSize(200, 50);
        Graphics.DisplayMode currentMode = Gdx.graphics.getDisplayMode();

        //anti-aliasing label
        Label antiAliasingLabel = new Label("Anti-Aliasing", skin);
        antiAliasingLabel.setAlignment(Align.center);
        antiAliasingLabel.setFontScale((float) 1.5);
        videoOptionsStage.addActor(antiAliasingLabel);
        //anti-aliasing
        SelectBox antiAliasing = new SelectBox(skin);
        String[] aliasingOptions = {"Off", "Low - FXAA", "Medium - SMAA Low", "High - SMAA Medium", "Ultra - SMAA High"};
        antiAliasing.setItems(aliasingOptions);
        antiAliasing.setAlignment(Align.center);
        antiAliasing.setSize(200, 50);
        antiAliasing.setPosition((float) (stageWidth / 2 - antiAliasing.getWidth() / 2), (float) (stageHeight / 3));
        videoOptionsStage.addActor(antiAliasing);


        //apply button
        TextButton applyButton = new TextButton("Apply", skin);
        applyButton.setSize((float) (stageWidth / 14), (float) (stageHeight / 14));
        applyButton.setPosition(stageWidth / 2 - applyButton.getWidth() / 2, stageHeight / 6);
        applyButton.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if (fullScreen.getSelected().equals("Fullscreen")) {
                    Gdx.graphics.setFullscreenMode(currentMode);
                    System.out.println("fullscreen");

                } else {
                    Gdx.graphics.setWindowedMode(1280, 720);
                }
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                return true;
            }
        });
        videoOptionsStage.addActor(applyButton);


        videoOptionsStage.addActor(fullScreen);
        //vsync checkbox
        CheckBox vSync = new CheckBox("Vsync", skin);
        vSync.setPosition(stageHeight / 2, (float) (stageHeight / 1.5));
        videoOptionsStage.addActor(vSync);

        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(true);
        videoOptionsStage.addActor(table);

        table.add(fullscreenLabel).fillX().uniformX();
        table.row().pad(10, 0, 0, 0);
        table.add(fullScreen).fillX().uniformX().width(200).height(50);
        table.row().pad(10, 0, 0, 0);
        table.add(antiAliasingLabel).fillX().uniformX();
        table.row().pad(10, 0, 10, 0);
        table.add(antiAliasing).fillX().uniformX().width(200).height(50);
        table.row().pad(10, 0, 10, 0);
        table.add(vSync).fillX().uniformX().width(100).height(25);
        table.row().pad(10, 0, 0, 0);
        table.add(applyButton).fillX().uniformX();




        camera = new OrthographicCamera();
        viewport = new FitViewport(stageWidth, stageHeight, camera);


    }


    @Override
    public void show() {
        Gdx.input.setInputProcessor(videoOptionsStage);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(142 / 255f, 101 / 255f, 31 / 255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        videoOptionsStage.act();
        videoOptionsStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        videoOptionsStage.getViewport().update(width, height, true);
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
        videoOptionsStage.dispose();
    }
}
