package texas_poker;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vickyLzy on 2019/5/11
 */
public class Judger {
    public static void judgeWapper(String a ,String b){
        PokerSet pokerSet1 = new PokerSet(a);
        PokerSet pokerSet2 = new PokerSet(b);
        PokerSet result = Judger.judgePoker(pokerSet1,pokerSet2);
        String winner;
        if (result ==null){
            System.out.println("Tie");
            return;
        }
        else if (result == pokerSet1) winner = "Black";
        else winner = "White";
        System.out.println(winner+" wins - "+winTyoe(result.getStar())+":"+winCard(result.getSpecCardNum()));
    }

    public static PokerSet judgePoker(PokerSet pSa ,PokerSet pSb){
        if (pSa.getStar()>pSb.getStar()) return pSa;
        else if ((pSa.getStar()<pSb.getStar())) return pSb;
        else {
            if (pSa.getSpecCardNum()>pSb.getSpecCardNum()) return pSa;
            else if ((pSa.getSpecCardNum()<pSb.getSpecCardNum())) return pSb;
            else {
                if (pSa.getAddtionNum()>pSb.getAddtionNum()) return pSa;
                else if ((pSa.getAddtionNum()<pSb.getAddtionNum())) return pSb;
                else if (pSa.getStar()<=3){
                    return hardJudgePoker(pSa,pSb);
                }
                else return null;
            }
        }
    }
    private static PokerSet hardJudgePoker(PokerSet pSa ,PokerSet pSb){
        int[] arrayA = pSa.getNums().clone();
        int[] arrayB = pSb.getNums().clone();
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        for (int i=4;i>=0;i--){
            if (arrayA[i]>arrayB[i]) return pSa;
            else if (arrayA[i]<arrayB[i]) return pSb;
        }
        return null;
    }
    private static String winTyoe(int num){
        Map winDict = new HashMap<Integer,String>();
        winDict.put(1,"High card");
        winDict.put(2,"Pair");
        winDict.put(3,"Two Pair");
        winDict.put(4,"Three of a Kind");
        winDict.put(5,"Straight");
        winDict.put(6,"Flush");
        winDict.put(7,"Full House");
        winDict.put(8,"Four of a kind");
        winDict.put(9,"Straight flush");
        return String.valueOf(winDict.get(num));


    }
    private static String winCard(int num){
        if (num<=10) return String.valueOf(num);
        Map winDict = new HashMap<Integer,String>();
        winDict.put(11,"Jack");
        winDict.put(12,"Queen");
        winDict.put(13,"King");
        winDict.put(14,"Ace");
        return String.valueOf(winDict.get(num));


    }
}
