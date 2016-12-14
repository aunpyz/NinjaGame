package com.ninja.game.Sprite;

import com.ninja.game.State.EElements;

/**
 * Created by ather on 14/12/2559.
 * ใช้สำหรับการคำนวนดาเมจเพิ่มเติมในการชนะธาตุ
 */
public class ElementSystem {
    EElements player;
    EElements enemy;

    double playerDMG;
    double enemyDMG;

    public ElementSystem(EElements player, EElements enemy){
        this.player = player;
        this.enemy = enemy;
    }

    public double whowin(){
        if (player == player.FIRE && enemy == enemy.WATER ){
            playerDMG = 2;
            enemyDMG = 1;
            return 1;

        }else if(player == player.WATER && enemy == enemy.FIRE){
            playerDMG = 1;
            enemyDMG = 2;
            return 2;

        }else if(player == player.WOOD && enemy == enemy.WATER){
            playerDMG = 2;
            enemyDMG = 1;
            return 1;

        }else if(player == player.WATER && enemy == enemy.WOOD){
            playerDMG = 1;
            enemyDMG = 2;
            return 2;

        }else if(player == player.FIRE && enemy == enemy.WOOD){
            playerDMG = 2;
            enemyDMG = 1;
            return 1;

        }else if(player == player.WOOD && enemy == enemy.FIRE){
            playerDMG = 1;
            enemyDMG = 2;
            return 2;

        }else {
            playerDMG = 1;
            enemyDMG = 1;
            return 0;

        }
    }

    public double getDamge(){
        double who = this.whowin();
        if(who == 1){
            return getPlayerDMG();
        }else if (who == 2){
            return getEnemyDMG();
        }else{
            return 1;
        }
    }

    public double getPlayerDMG(){
        return playerDMG;
    }

    public double getEnemyDMG() {
        return enemyDMG;
    }
}
