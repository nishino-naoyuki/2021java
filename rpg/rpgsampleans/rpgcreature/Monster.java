package rpgcreature;

/**
 * モンスターのスーパークラス
 */
public abstract class Monster extends Creature{
    protected boolean escapeFlag = false;
    protected int money = 0;    //【　課題 ５ 】 Level ☆☆☆

    /**
     * モンスタークラスのコンストラクタ
     * @param name　名前
     * @param hp　モンスターの体力
     */
    public Monster(String name,int hp,int money,int speed){
        super(name,hp,speed);
        this.money = money;
    }

    /**
     * 〇〇が現れたを表示するメソッド
     */
    public void displayAppearanceMsg(){
        System.out.printf("%sが現れた！\n",getName());
    }

    /**
     * すでに逃げているかのチェック
     * @return true:逃げている　false：まだ逃げていない
     */
    public boolean isEscaped(){
        return escapeFlag;
    }

    /**
     * モンスターが居るかどうかのチェックメソッド
     * モンスターが居ない＝「モンスターが死んでいる」もしくは「すでに逃げている」
     * @return true:居る false：居ない
     */
    public boolean isThere(){
        return (hp > 0 && !escapeFlag);
    }

    /**
     * マネーを取得する
     * 【　課題 ５ 】 Level ☆☆☆
     * 
     * @return マネーを取得する
     */
    public int getMoney(){

        if( !isAlive() ){
            return money;
        }

        return 0;
    }
}
