import java.util.Scanner;

/**
 * 2021/10/1
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class HelloGoodbye {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(" ");
        System.out.println("Hello "+split[0]+" and "+split[1]+".");
    }
}
