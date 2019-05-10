package fib;

import java.math.BigInteger;

public class Fibonaci {
    public static BigInteger of(int num) {
        if (num == 1 || num == 2)
            return new BigInteger("1");
        else {
            BigInteger a = new BigInteger("1");
            BigInteger b = a;
            BigInteger result = a;
            for (int i = 1; i <= num - 2; i++) {
                a = b;
                b = result;
                result = a.add(b);
            }
            return result;
        }
    }
}
