

import java.util.Scanner;

public class Game{
    private final int SHIP_NUM = 3;
    private final int MAP_SIZE = 5;
    private Ship[] ships = new Ship[SHIP_NUM];
    private Map map = new Map();

    //コンストラクタ
    public Game(){
        for(int i = 0; i < SHIP_NUM; i++ ){
            ships[i] = new Ship();
        }
    }

    /**
     * 初期化処理
     */
    public void init(){      
        map.init(MAP_SIZE);
        for(int i = 0; i < SHIP_NUM; i++ ){
            do{
                ships[i].init(MAP_SIZE);
            }while(!map.deployShip(ships[i]));            
        }
    }

    /**
     * メイン処理
     */
    public void execute(){
        int attackX;
        int attackY;

        Scanner scanner = new Scanner(System.in);
        int turn = 1;

        title();
        //全て船が沈むまでループ
        while(!isAllSink()){
            System.out.println("---------[ターン"+turn+"]---------");
            displaySituation();
            System.out.println("爆弾のX座標を入力してください(1-"+MAP_SIZE+")");
            attackX = scanner.nextInt();
            System.out.println("爆弾のY座標を入力してください(1-"+MAP_SIZE+")");
            attackY = scanner.nextInt();
            
            for(int i = 0; i < SHIP_NUM; i++ ){
                int result = ships[i].check(attackX-1, attackY-1);
                //結果によって動きを変える
                doByResult(ships[i],i+1,result);
            }
            turn++;
        }
        System.out.println("全て撃沈！おめでとう");

        scanner.close();
    }

    //タイトル表示
    private void title(){
        System.out.println("***************************");
        System.out.println("       　戦艦ゲーム　　　　　");
        System.out.println("***************************");
    }

    /**
     * 全て沈んだかのチェック
     * @return true（全て沈んだ）/false（まだ残っている）
     */
    private boolean isAllSink(){
        boolean allSink = true; //全て撃沈
        for(int i = 0; i < SHIP_NUM; i++ ){
            if( ships[i].isAlive() ){
                allSink = false;
                break;
            }
        }

        return allSink;
    }
    
    /**
     * 状況を表示する
     */
    private void displaySituation(){
        for(int i = 0; i < SHIP_NUM; i++ ){
            if( ships[i].isAlive() ){
                System.out.println("船"+(i+1)+"：生きてる");
            }else{
                System.out.println("船"+(i+1)+"：撃沈済み");
            }
        }
    }

    /**
     * 爆弾が落ちたリアクションのしょり
     * 
     * @param ship 対象となる船
     * @param no 船の番号
     * @param result 爆弾が落ちが結果
     */
    private void doByResult(Ship ship,int no,int result){
        if( result == Ship.NO_HIT){
            System.out.println("船"+no+":はずれ！");
        }else if( result == Ship.NEAR){
            System.out.println("船"+no+":波高し！");
        }else if( result == Ship.HIT){
            System.out.println("船"+no+":爆弾が当たった！しかし船はまだ沈まない！船は移動します");
            moveShip(ship);
        }else{
            System.out.println("船"+no+":爆弾が当たった！撃沈しました！");
            map.clear(ship.getPosX(), ship.getPosY());
        }
    }

    /**
     * 船を動かす
     * @param ship 動かす対象の船
     */
    private void moveShip(Ship ship){

        //一旦今の場所をクリアする
        map.clear(ship.getPosX(), ship.getPosY());
        do{
            ship.move(MAP_SIZE);
        }while(!map.deployShip(ship)); 
    }
}