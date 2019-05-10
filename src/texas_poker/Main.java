package texas_poker;

/**
 * Created by vickyLzy on 2019/5/11
 */
public class Main {
    public static void main(String[] args) {

        Judger.judgeWapper("2H 3D 3S KC KD","2C 2H 1S KC KH");
        Judger.judgeWapper("2H 3D 5S 9C KD","2C 3H 4S 8C AH");
        Judger.judgeWapper("2H 4S 4C 2D 4H","2S 8S AS QS 3S");
        Judger.judgeWapper("2H 3D 5S 9C KD","2C 3H 4S 8C 4H");
        Judger.judgeWapper("2H 3D 4S 5C 6D","2C 3H 4S 8C 4H");


    }
}
