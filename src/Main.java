import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.next().toCharArray();
        StringBuilder ans = new StringBuilder();
        int i;
        //计数器cnt记录一个字符有几个
        int cnt = 1;
        for (i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                cnt++;
                continue;
            }
            if (cnt == 1)
                ans.append(arr[i]);
            else
                ans.append(arr[i]).append(cnt);
            //将计数器重置
            cnt = 1;
        }
        //for循环里没有将最后一个字符加入
        if (cnt == 1)
            ans.append(arr[i]);
        else
            ans.append(arr[i]).append(cnt);

        //判断语句
        if (ans.length() < arr.length)
            System.out.println(ans);
        else
            System.out.println("NO");
    }
}