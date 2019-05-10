## 敏捷web开发作业项目 

3118311071 林之阳

目录

[TOC]

### Fibonacci sequence 

- JAVA   src/fib.Main.java  to start

- work on [github](https://github.com/lzyplayer/WebDevelopment)

- 运行结果：

  ```java
  ...
  Fibonacci.of(191) == 3691087032412706639440686994833808526209
  Fibonacci.of(192) == 5972304273877744135569338397692020533504
  Fibonacci.of(193) == 9663391306290450775010025392525829059713
  Fibonacci.of(194) == 15635695580168194910579363790217849593217
  Fibonacci.of(195) == 25299086886458645685589389182743678652930
  Fibonacci.of(196) == 40934782466626840596168752972961528246147
  Fibonacci.of(197) == 66233869353085486281758142155705206899077
  Fibonacci.of(198) == 107168651819712326877926895128666735145224
  Fibonacci.of(199) == 173402521172797813159685037284371942044301
  Fibonacci.of(200) == 280571172992510140037611932413038677189525
  ```

- fib.Fibonaci.java

  ```java
  import java.math.BigInteger;
  
  public class fib.Fibonaci {
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
  
  ```

- fib.Main.java

  ```java
  public class fib.Main {
  
      public static void main(String[] args) {
          System.out.println("Hello Fibonacci!");
          for (int i = 1; i <= 200; i++) {
              System.out.println("Fibonacci.of(" + i + ") == " + Fibonaci.of(i).toString());
          }
      }
  }
  
  ```


### Texas Poker

- `./texas_poker/Main` to run test ，通过wapper包裹以达到题目要求效果

- `./texas_poker/Judger.java-judgePoker`函数为判断主流程

- 每组poker评价位于PokerSet的构造函数中，在输入时即计算

  

