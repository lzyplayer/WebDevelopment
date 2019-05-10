package texas_poker;

import java.util.Arrays;

/**
 * Created by vickyLzy on 2019/5/11
 */
public class PokerSet {
    private char[] cards;

    private int[] nums;
    private char[] colors;
    private int star =1;
    private int specCardNum =0 ;
    private int addtionNum=0;

    public PokerSet(String cards) {
        this.cards = cards.replaceAll(" ","").toCharArray();
        int[] inNums = new int[5];
        char[] inColor = new char[5];
        //doNums
        for(int i=0;i<=9;i=i+2){
            char currLetter = this.cards[i];
            int currNum = 0;
            if ((int)currLetter>57){
                if (currLetter == 'T') currNum = 10;
                else if (currLetter == 'J') currNum =11;
                else if (currLetter == 'Q') currNum =12;
                else if (currLetter == 'K') currNum =13;
                else if (currLetter == 'A') currNum =14;
            }
            else currNum =(int)currLetter-48; //ASCII2int
            inNums[i/2]= currNum;
        }
        //doColor
        for(int i=1;i<=9;i=i+2){
            inColor[(i-1)/2] = this.cards[i];
        }
        this.nums = inNums;
        this.colors = inColor;
        this.dealer();
    }

    public  void dealer() {
        //statics
        int[] dataBoard = new int[15];
        for (int anum : nums) {
            dataBoard[anum]++;
        }
        //sort
        int[] judgingNums = nums.clone();
        Arrays.sort(judgingNums);
        //9
        if (colors[0] == colors[1] && colors[1] == colors[2] && colors[2] == colors[3] && colors[3] == colors[4]) {

            if (judgingNums[0] + 1 == judgingNums[1] && judgingNums[1] + 1 == judgingNums[2] && judgingNums[2] + 1 == judgingNums[3] && judgingNums[3] + 1 == judgingNums[4]) {
                star = 9;
                specCardNum = judgingNums[4];
                return;
            }
        }
        //8

        for (int i = 14; i >= 2; i--) {
            if (dataBoard[i] == 4) {
                star = 8;
                specCardNum = i;
                return;
            }
        }

        //7
        for (int i = 14; i >= 2; i--) {
            if (dataBoard[i] == 3) {
                for (int j = 14; j >= 2; j--) {
                    if (dataBoard[j] == 2) {
                        star = 7;
                        specCardNum = i;
                        return;
                    }
                }
            }
        }
        //6
        if (colors[0] == colors[1] && colors[1] == colors[2] && colors[2] == colors[3] && colors[3] == colors[4]) {
            star = 6;
            specCardNum = judgingNums[4];
            return;
        }
        //5
        if (judgingNums[0] + 1 == judgingNums[1] && judgingNums[1] + 1 == judgingNums[2] && judgingNums[2] + 1 == judgingNums[3] && judgingNums[3] + 1 == judgingNums[4]) {
            star = 5;
            specCardNum = judgingNums[4];
            return;
        }
        //4
        for (int i = 14; i >= 2; i--) {
            if (dataBoard[i] == 3) {
                star = 4;
                specCardNum = i;
                return;
            }
        }
        //3
        for (int i = 14; i >= 2; i--) {
            if (dataBoard[i] == 2) {
                for (int j = i - 1; j >= 2; j--) {
                    if (dataBoard[j] == 2) {
                        star = 3;
                        specCardNum = i;
                        addtionNum = j;
                        return;
                    }

                }
            }
        }
        //2
        for (int i = 14; i >= 2; i--) {
            if (dataBoard[i] == 2) {
                star = 2;
                specCardNum = i;
                return;
            }
        }
        //1
        specCardNum=judgingNums[4];
        return;
    }


    public char[] getCards() {
        return cards;
    }

    public int[] getNums() {
        return nums;
    }

    public char[] getColors() {
        return colors;
    }

    public int getStar() {
        return star;
    }

    public int getAddtionNum() {
        return addtionNum;
    }

    public int getSpecCardNum() {
        return specCardNum;
    }


}
