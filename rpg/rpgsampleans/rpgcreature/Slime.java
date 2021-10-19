package rpgcreature;

import java.util.Random;

/**
 * スライムクラス
 */
public class Slime extends Monster{
    private final static int MAX_HP = 12;
    private final static int DAMAGE_RANGE = 5;
    private final static String MONSTER_NAME = "スライム";
    private final static int MONEY = 2;   //【　課題 ５ 】 Level ☆☆☆
    private final static int DEFENCE = 0;    //【　課題 ６ 】 Level ☆☆☆☆

    /**
     * スライムクラスのコンストラクタ
     */
    public Slime(){
        super(MONSTER_NAME,MAX_HP,MONEY,DEFENCE);
    }

    /**
     * 攻撃メソッド
     * @param opponent：攻撃相手
     */
    @Override
    public void attack(Creature opponent) {
        
        Random r = new Random();
        int attack = r.nextInt(DAMAGE_RANGE);
        System.out.printf("%sの攻撃！\n",getName());
        
        //ダメージを計算・表示する
        damageProcess(attack,opponent);
        
    }
    
}
