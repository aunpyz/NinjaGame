package com.ninja.game.Scean;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.ninja.game.GameMain;
import com.sun.prism.image.ViewPort;
import javafx.stage.Stage;

/**
 * Created by ather on 9/12/2559.
 */
public class PlayScean {
    private GameMain game;

    //Screen variable
    private OrthographicCamera gamecam;
    private ViewPort gameViewPort;
    private Stage stage;
    PlayScean(Stage stage){
        this.stage = stage;
    }
}
