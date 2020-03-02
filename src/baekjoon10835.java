import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon10835 {
    static int N;
    static int [][]dp ;
    static int []leftArr, rightArr;

    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp= new int[N][N];
        leftArr = new int[N];
        rightArr = new int[N];

        String p = br.readLine();
        StringTokenizer st = new StringTokenizer(p, " ");
        for(int i=0; i<N; i++) {
            leftArr[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(dp[i], -1);
        }
        p = br.readLine();
        st = new StringTokenizer(p, " ");
        for(int i=0; i<N; i++) rightArr[i]= Integer.parseInt(st.nextToken());

        System.out.println(proc(0,0));


    }

    public static int proc(int leftIndex,int rightIndex){
        if(leftIndex == N || rightIndex == N) return 0;
        if(dp[leftIndex][rightIndex]!=-1) return dp[leftIndex][rightIndex];

        if(leftArr[leftIndex] > rightArr[rightIndex]){
            dp[leftIndex][rightIndex] = rightArr[rightIndex] + proc(leftIndex, rightIndex+1);
        }

        else{
            int res1 = proc(leftIndex+1, rightIndex+1);
            int res2 = proc(leftIndex+1, rightIndex);

            if(res1>res2) dp[leftIndex][rightIndex] = proc(leftIndex+1, rightIndex+1);
            else dp[leftIndex][rightIndex] = proc(leftIndex+1, rightIndex);
        }

        return dp[leftIndex][rightIndex];
    }
}
