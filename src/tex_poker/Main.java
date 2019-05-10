package tex_poker;

/**
 * Created by vickyLzy on 2019/5/11
 */
public class Main {
    public static void main(String[] args) {
//        char a ='2';
//        System.out.println((int)a);
//        System.out.println(Integer.valueOf(a));
        PokerSet pokerSet1 = new PokerSet("2H 3D 5S 9C KD");
        PokerSet pokerSet2 = new PokerSet("2D 3H 5C 9S KH");
        PokerSet result = Judger.judgePoker(pokerSet1,pokerSet2);
        if (result ==null) System.out.println("Tie");
        else System.out.println("winner:"+String.valueOf(result.getCards())+" - "+result.getStar()+":"+result.getSpecCardNum());

    }
}
