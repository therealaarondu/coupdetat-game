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
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import static com.mygdx.game.Main.skin;

public class gameOptions implements Screen {
    private Stage gameOptionsStage;
    private Game gameOptionsGame;

    private OrthographicCamera camera;
    private Viewport viewport;

    public gameOptions(Game aGame) {
        gameOptionsGame = aGame;
        gameOptionsStage = new Stage(new ScreenViewport());
        float stageWidth = gameOptionsStage.getWidth();
        float stageHeight = gameOptionsStage.getHeight();

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
                gameOptionsGame.setScreen(new optionsScreen(gameOptionsGame));
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        gameOptionsStage.addActor(backButton);
        Skin skin = new Skin(Gdx.files.internal(("skin/flat-earth-ui.json")));

        //difficulty label
        Label difficultyLabel = new Label("Difficulty", skin);
        difficultyLabel.setAlignment(Align.center);
        difficultyLabel.setFontScale((float) 1.5);
        gameOptionsStage.addActor(difficultyLabel);
        //difficulty selectbox
        SelectBox difficulty = new SelectBox(skin);
        String[] resOptions = {"Easy", "Medium", "Hard"};
        difficulty.setItems(resOptions);
        difficulty.setAlignment(Align.center);
        difficulty.setSize(200, 50);
        difficulty.setPosition((float) (stageWidth / 2 - difficulty.getWidth() / 2), stageHeight / 2);
        gameOptionsStage.addActor(difficulty);

        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(true);
        gameOptionsStage.addActor(table);

        table.add(difficultyLabel).fillX().uniformX();
        table.row().pad(10, 0, 0, 0);
        table.add(difficulty).fillX().uniformX().width(200).height(50);


        camera = new OrthographicCamera();
        viewport = new FitViewport(stageWidth, stageHeight, camera);
    }


    @Override
    public void show() {
        Gdx.input.setInputProcessor(gameOptionsStage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(142 / 255f, 101 / 255f, 31 / 255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gameOptionsStage.act();
        gameOptionsStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        gameOptionsStage.getViewport().update(width, height, true);

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
        gameOptionsStage.dispose();
    }
}
