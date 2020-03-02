import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon2156 {
    static int N;
    static int []map;
    static int [][]dp;
    public static void main (String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1];
        dp = new int[N+1][3];


        for(int i=1; i<=N; i++){
            map[i] = Integer.parseInt(br.readLine());

            dp[i][0] = dp[i-1][0];
            if(dp[i][0] < dp[i-1][1]) dp[i][0] = dp[i-1][1];
            if(dp[i][0] < dp[i-1][2]) dp[i][0] = dp[i-1][2];

            dp[i][1] = dp[i-1][0] + map[i];
            if(dp[i][1] < dp[i-1][1]) dp[i][1] = dp[i-1][1];

            dp[i][2] = dp[i-1][1] + map[i];
        }

        int res = dp[N][0];
        if(res < dp[N][1]) res= dp[N][1];
        if(res < dp[N][2]) res= dp[N][2];

        System.out.println(res);
    }

}
