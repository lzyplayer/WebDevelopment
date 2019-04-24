public class Main {

    public static void main(String[] args) {
        System.out.println("Hello Fibonacci!");
        for (int i = 1; i <= 200; i++) {
            System.out.println("Fibonacci.of(" + i + ") == " + Fibonaci.of(i).toString());
        }
    }
}
