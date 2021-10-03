import java.util.Scanner;

/**
 * 2021/10/1
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class Random {
    private static java.util.Random random;    // pseudo-random number generator
    private static long seed;        // pseudo-random number generator seed

    // static initializer
    static {
        // this is how the seed was set in Java 1.4
        seed = System.currentTimeMillis();
        random = new java.util.Random(seed);
    }
    public static void main(String[] args) {
//        String s = StdIn.readString();
//        System.out.println(s);
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(" ");
        for (int i = 0; i < split.length; i++) {

        }
//        StdRandom.
//        System.out.println(StdRandom.bernoulli());


    }
}
