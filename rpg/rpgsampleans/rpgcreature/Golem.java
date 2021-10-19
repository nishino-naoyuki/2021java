package rpgcreature;

import java.util.Random;

/**
 * ゴーレムクラス
 * 【課題 １ 】 Level ☆
 * 　モンスターを追加してみよう
 */
public class Golem extends Monster{
    private final static int MAX_HP = 100;
    private final static int CRITICAL_HIT_RATE = 5;
    private final static int CRITICAL_HIT_DAMAGE = 30;
    private final static int DAMAGE_OFFSET = 5;
    private final static int DAMAGE_RANGE = 6;
    private final static String MONSTER_NAME = "ゴーレム";
    private final static int MONEY = 100;   //【　課題 ５ 】 Level ☆☆☆
    private final static int DEFENCE = 5;    //【　課題 ６ 】 Level ☆☆☆☆

    public Golem() {
        super(MONSTER_NAME, MAX_HP,MONEY,DEFENCE);
    }

    @Override
    public void attack(Creature opponent) {
        Random r = new Random();
        int attack = 0;
        System.out.printf("%sの攻撃！\n",getName());

        //クリティカルヒットかのチェック
        if( r.nextInt(100) < CRITICAL_HIT_RATE ){
            //クリティカルヒット
            attack = CRITICAL_HIT_DAMAGE;
            System.out.printf("%sのクリティカルヒット！\n",getName());
        }else{
            attack = r.nextInt(DAMAGE_RANGE)+DAMAGE_OFFSET;
            
        }
        //ダメージを計算・表示する
        damageProcess(attack,opponent);
        
    }
    
}
