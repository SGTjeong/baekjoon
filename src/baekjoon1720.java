import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon1720 {
    static char[]s1, s2;
    static int [][][]dp;

    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []line=br.readLine().split(" ");
        dp = new int[21][21][21];
        int a,b,c;

        while(!(line[0].equals("-1")&&line[1].equals("-1")&&line[2].equals("-1"))){
            a=Integer.parseInt(line[0]); b=Integer.parseInt(line[1]); c= Integer.parseInt(line[2]);
            System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, w(a,b,c));
            line=br.readLine().split(" ");
        }
    }

    public static int w(int a, int b, int c){
        if(a<=0 || b<=0 || c<=0) return 1;
        if(a>20 || b>20 || c>20) return w(20,20,20);
        if(dp[a][b][c]!=0) return dp[a][b][c];
        if(a<b && b<c) dp[a][b][c] = w(a,b,c-1) + w(a,b-1,c-1) -w(a, b-1, c);
        else dp[a][b][c]=w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1,b-1,c-1);
        return dp[a][b][c];
    }
}
