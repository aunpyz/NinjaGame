package com.ninja.game.Stage;

import java.util.Stack;

/**
 * Created by ather on 9/12/2559.
 */
public class GameStageManager {
    private Stack<Stage> stages;
    public GameStageManager(){
        stages = new Stack<Stage>();
    }

    public void push(Stage stage){
        this.stages.push(stage);
    }

    public void pop(){
        this.stages.pop();
    }

    public void set(Stage stage){
        this.stages.pop();
        this.stages.push(stage);
    }

    public void update(float dt){
        this.stages.peek();
    }
}
