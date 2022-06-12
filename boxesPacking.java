import java.util.HashMap;
import java.util.Scanner;

public class BoxesPacking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = sc.nextInt();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int in = sc.nextInt();
            hm.put(in, hm.getOrDefault(in, 0) + 1);
            max = Math.max(max, hm.get(in));
        }
        System.out.println(max);
        sc.close();
    }
}
