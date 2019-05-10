package tex_poker;

import java.util.Arrays;

/**
 * Created by vickyLzy on 2019/5/11
 */
public class Judger {
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
}
