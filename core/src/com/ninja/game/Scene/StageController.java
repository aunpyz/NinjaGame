package com.ninja.game.Scene;

/**
 * Created by Aunpyz on 12/14/2016.
 */
public class StageController implements Element {
    private ELEMENT stageElement;

    public StageController()
    {
        stageElement = ELEMENT.WATER;
    }

    @Override
    public void setElement() {
        switch (stageElement)
        {
            case WATER:
                stageElement = ELEMENT.WOOD;
                break;
            case WOOD:
                stageElement = ELEMENT.FIRE;
                break;
            case FIRE:
                stageElement = ELEMENT.WATER;
                break;
        }
    }

    @Override
    public ELEMENT getElement() {
        return stageElement;
    }

    @Override
    public String getStringElement() {
        switch (stageElement)
        {
            case WATER:
                return "Lake";
            case FIRE:
                return "Fire";
            case WOOD:
                return "Forest";
        }
        return null;
    }
}
