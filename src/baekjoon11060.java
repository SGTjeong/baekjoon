import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon11060 {
    static int N;
    static int []map;
    static int []dp;
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        map = new int[N];
        dp = new int[N];

        for(int i=0; i<N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
            dp[i] = Integer.MIN_VALUE;
        }
        dp[N-1] = 0;

        System.out.println(dp(0));
    }

    public static int dp(int index){
        if(index >= N) return -1;
        if(dp[index] != Integer.MIN_VALUE) return dp[index];
        if(map[index] == 0) return -1;

        int min = Integer.MAX_VALUE;

        for(int i=1; i<=map[index]; i++){
            int cnt = dp(index+i);
            if(cnt == -1) continue;;
            if(min > cnt) min = cnt;
        }

        if(min == Integer.MAX_VALUE) dp[index] = -1;
        else dp[index] = min + 1;

        return dp[index];
    }
}
