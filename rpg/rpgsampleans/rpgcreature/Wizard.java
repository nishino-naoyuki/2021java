package rpgcreature;

import java.util.Random;

/**
 * 魔法使いクラス
 */
public class Wizard extends Monster{
    private final static int MAX_HP = 30;

    private final static int MAGIC_DAMAGE_OFFSET = 5;
    private final static int MAGIC_DAMAGE_RANGE = 10;
    private final static int DAMAGE_OFFSET = 1;
    private final static int DAMAGE_RANGE = 5;
    private final static int USE_MAGIC_RATE = 70;
    private final static int MONEY = 20;   //【　課題 ５ 】 Level ☆☆☆
    private final static int DEFENCE = 2;    //【　課題 ６ 】 Level ☆☆☆☆

    private final static String MONSTER_NAME = "魔法使い";
    
    /**
     * 魔法使いのコンストラクタ
     */
    public Wizard(){
        super(MONSTER_NAME,MAX_HP,MONEY,DEFENCE);
    }

    /**
     * 攻撃メソッド
     * @param opponent：攻撃相手
     */
    @Override
    public void attack(Creature opponent) {
        
        Random r = new Random();
        int attack = 0;
        if( r.nextInt(100) < USE_MAGIC_RATE){
            System.out.printf("%sは魔法を唱えた！\n",getName());
            attack = r.nextInt(MAGIC_DAMAGE_RANGE)+MAGIC_DAMAGE_OFFSET;
        }else{
            System.out.printf("%sの攻撃！\n",getName());
            attack = r.nextInt(DAMAGE_RANGE)+DAMAGE_OFFSET;
        }
        //ダメージを計算・表示する
        damageProcess(attack,opponent);
        
    }
}
