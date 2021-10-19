package rpgcreature;

import java.util.Random;

/**
 * 勇者クラス
 */
public class Braver extends Creature{
    private final static int MAX_HP = 100;
    private final static int RECOVERY_POINT = 20;
    private final static int CRITICAL_HIT_RATE = 10;
    private final static int CRITICAL_HIT_DAMAGE = 50;
    private final static int DAMAGE_OFFSET = 1;
    private final static int DAMAGE_RANGE = 10;
    private final static int DEFENCE = 2;    //【　課題 ６ 】 Level ☆☆☆☆

    /**
     * 勇者クラスのコンストラクタ
     */
    public Braver(String name){
        super(name,MAX_HP,DEFENCE);
    }
    
    /**
     * 攻撃メソッド
     * @param opponent：攻撃相手
     */
    @Override
    public void attack(Creature opponent){
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

    /**
     * HP回復処理
     */
    public void recovery(){
        System.out.printf("%sはHPを回復した！\n",getName());
        hp += RECOVERY_POINT;
        if( hp > MAX_HP ){
            hp = MAX_HP;
        }
    }
}
