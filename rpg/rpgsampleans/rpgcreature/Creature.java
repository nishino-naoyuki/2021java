package rpgcreature;

/**
 * 生物クラス
 * 勇者やモンスターの基本的な機能を持つクラス
 */
public abstract class Creature {
    private String name;
    protected int hp;
    protected int deffence;    //【　課題 ６ 】 Level ☆☆☆☆

    /**
     * コンストラクタ
     * @param name：名前
     * @param hp：最大HP
     * @param deffence：防御力
     */
    public Creature(String name,int hp,int deffence){
        this.name = name;
        this.hp = hp;
        this.deffence = deffence;
    }

    /**
     * 攻撃メソッド
     * @param opponent：攻撃相手
     */
    public abstract void attack(Creature opponent);

    /**
     * ダメージを受けるメソッド
     * @param damage：受けるダメージ数
     */
    public void damaged(int damage){
        hp -= damage;
        if( hp <0 ){
            hp = 0;
        }
    }

    /**
     * 生きているかを確認するメソッド
     * @return true:生きている false:死んでいる
     */
    public boolean isAlive(){
        return (hp>0);
    }

    /**
     * 名前を取得する
     * @return 取得した名前
     */
    public String getName(){
        return name;
    }

    /**
     * 現在のHPを取得する
     * @return 現在のHP
     */
    public int getHp(){
        return hp;
    }

    /**
     * ダメージを与えた際に表示するメッセージ
     * @param opponent ダメージを与えた相手
     * @param damage　与えたダメージ数
     */
    protected void displayMessage(Creature opponent,int damage){
        System.out.printf("%sは%sに%dのダメージを与えた\n",name,opponent.getName(),damage);
    }

    /**
     * 防御力を取得する
     * 【　課題 ６ 】 Level ☆☆☆☆
     * @return 防御力
     */
    public int getDeffence(){
        return deffence;
    }

    /**
     * 最終的なダメージ計算する
     * 【　課題 ６ 】 Level ☆☆☆☆
     * @param attack：攻撃力
     * @param opponent：相手のオブジェクト
     * @return 最終的なダメージ
     */
    private int calocDamage(int attack,Creature opponent){
        int damage = attack - opponent.getDeffence();

        if( damage < 0 ){
            damage = 0;
        }

        return damage;
    }

    /**
     * ダメージを計算し表示をする処理
     * @param attack：攻撃力（軽減前）
     * @param opponent：相手のオブジェクト
     */
    protected void damageProcess(int attack,Creature opponent){
        
        //最終的なダメージを計算する
        attack = calocDamage(attack,opponent);
        
        opponent.damaged(attack);
        
        displayMessage(opponent,attack);
    }
}
