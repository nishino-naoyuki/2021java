package rpgcreature;

import java.util.Random;

/**
 * メタルスライムクラス
 */
public class MetalSlime extends Monster{
    //★★★課題回答★★★
    //private final static int ESCAPE_RATE = 400;
    private final static int ESCAPE_RATE = 40;
    private final static int MAX_HP = 12;
    private final static String MONSTER_NAME = "メタルスライム";
    private final static int MONEY = 10;   //【　課題 ５ 】 Level ☆☆☆
    private final static int DEFENCE = 10;    //【　課題 ６ 】 Level ☆☆☆☆
    
    /**
     * メタルスライムのコンストラクタ
     */
    public MetalSlime(){
        super(MONSTER_NAME,MAX_HP,MONEY,DEFENCE);
    }

    /**
     * 攻撃メソッド
     * @param opponent：攻撃相手
     */
    @Override
    public void attack(Creature opponent) {
        
        Random r = new Random();
        if( r.nextInt(100) < ESCAPE_RATE ){
            System.out.printf("%sは逃げ出した！\n",getName());
            escapeFlag = true;
        }else{
            int attack = r.nextInt(5);
            System.out.printf("%sの攻撃！\n",getName());
            
            //ダメージを計算・表示する
            damageProcess(attack,opponent);
        }
    }
}
