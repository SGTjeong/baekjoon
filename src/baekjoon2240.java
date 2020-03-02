import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon2240 {
    static int T, W;
    static int []arr;
    static int [][]dp;
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line[] = br.readLine().split(" ");
        T = Integer.parseInt(line[0]); W = Integer.parseInt(line[1]);
        arr = new int[1001];

        int prev = -1;
        int cnt = 0;
        int index = 0;
        boolean startOne = false;

        for(int i=0; i<T; i++){
            int num = Integer.parseInt(br.readLine());
            if(i==0){
                if(num==1) startOne = true;
            }
            if(prev!=num) {
                arr[index++] = cnt;
                prev = num;
                cnt = 1;
            }
            else {
                cnt++;
            }
        }

        arr[index] = cnt;
        T = index + 1;

        dp = new int[T][W+1];

        if(startOne) System.out.println(dp(1, W));

        else {
            int res1 = dp(1, W - 1);
            dp= new int[T][W+1];
            int res2 = dp(2, W);
            System.out.println(Math.max(res1, res2));
        }
    }

    public static int dp(int index, int cnt){
        if(index>=T) return 0;
        if(dp[index][cnt]!=0) return dp[index][cnt];

        if(cnt>0) dp[index][cnt] = arr[index] + Math.max(dp(index+2, cnt), dp(index+1, cnt-1));
        else dp[index][cnt] = arr[index] + dp(index+2, cnt);

        return dp[index][cnt];
    }
}
