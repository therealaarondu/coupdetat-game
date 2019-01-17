package com.mygdx.game;
//add animated background

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.Screens.titleScreen;

public class Main extends Game {

    static public Skin skin;
    public Game game;
    public SpriteBatch batch;

    @Override
    public void create() {
        skin = new Skin(Gdx.files.internal(("skin/flat-earth-ui.json")));
        batch = new SpriteBatch();
        this.setScreen(new titleScreen(this));
    }

    public void resize(int width, int height){
        super.resize(width, height);
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
    }

}
