package com.mygdx.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import static com.mygdx.game.Main.skin;

public class soundOptions implements Screen {
    private Stage soundOptionsStage;
    private Game soundOptionsGame;
    final Slider soundSlider;
    Label soundSliderValue;
    String soundValue;
    private OrthographicCamera camera;
    private Viewport viewport;

    public soundOptions(Game aGame) {

        soundOptionsGame = aGame;
        soundOptionsStage = new Stage(new ScreenViewport());
        float stageWidth = soundOptionsStage.getWidth();
        float stageHeight = soundOptionsStage.getHeight();

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
                soundOptionsGame.setScreen(new optionsScreen(soundOptionsGame));
            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        soundOptionsStage.addActor(backButton);
        Skin skin = new Skin(Gdx.files.internal(("skin/flat-earth-ui.json")));

        //sound slider label
        Label soundSliderLabel = new Label("Sound", skin);
        soundSliderLabel.setAlignment(Align.center);
        soundSliderLabel.setFontScale((float) 1.5);
        soundOptionsStage.addActor(soundSliderLabel);

        //sound slider
        soundSlider = new Slider(0, 100, 5, false, skin);
        soundSlider.setSize(100, 30);
        //soundSlider.setPosition(stageWidth/2 - soundSlider.getWidth()/2, stageHeight/2);
        //sound slider value
        soundSliderValue = new Label("0", skin); //add in command to get current sound
        soundSliderValue.setAlignment(Align.center);
        soundSliderValue.setFontScale((float) 1.5);
        soundOptionsStage.addActor(soundSliderValue);
        soundOptionsStage.addActor(soundSlider);

        soundSlider.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                int intSoundValue = (int) soundSlider.getValue();
                soundValue = Integer.toString(intSoundValue);
                soundSliderValue.setText(soundValue);
            }
        });

        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(true);
        soundOptionsStage.addActor(table);

        table.add(soundSliderLabel).fillX().uniformX();
        table.row().pad(10, 0, 0, 0);
        table.add(soundSlider).fillX().uniformX().width(400).height(50);
        table.add(soundSliderValue).padLeft(10);

        camera = new OrthographicCamera();
        viewport = new FitViewport(stageWidth, stageHeight, camera);

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(soundOptionsStage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(142 / 255f, 101 / 255f, 31 / 255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        soundOptionsStage.act();
        soundOptionsStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        soundOptionsStage.getViewport().update(width, height, true);
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
        soundOptionsStage.dispose();
    }
}
