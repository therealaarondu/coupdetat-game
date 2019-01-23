package com.mygdx.game;
//add animated background

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Screens.*;

import javax.xml.soap.Text;

public class Main extends Game {
    private Stage mainStage;
    private Table mainTable;
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
