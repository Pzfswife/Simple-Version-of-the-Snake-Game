import java.util.*;

public class h {
    static int n, m, k;
    static int[] a;
    static int[] b;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();
        k = s.nextInt();

        a = new int[n]; // 初始化数组 a
        b = new int[m]; // 初始化数组 b

        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = s.nextInt();
        }
        int g = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int h = 0; // 重置 h 为 0
                h += Math.min(a[i], b[j]);
                if (h <= k)
                    g++;
            }
        }
        System.out.println(g);
    }
}
