import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon1509 {
    public static void main() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        char []seq=br.readLine().toCharArray();
        char []devil=br.readLine().toCharArray();
        char []angel=br.readLine().toCharArray();

        final int DEVIL=0;
        final int ANGEL=1;

        int [][][]dp=new int[seq.length][devil.length][2];


        for(int cur=0; cur<devil.length; cur++) {
            for (int progress = seq.length - 2; progress >= 0; progress--) {
                if (dp[progress][cur - 1][ANGEL] != 0) {
                    if (devil[cur] == seq[progress + 1]) dp[progress + 1][cur][DEVIL] += dp[progress][cur - 1][ANGEL];
                }

                if (dp[progress][cur - 1][DEVIL] != 0) {
                    if (angel[cur] == seq[progress + 1]) dp[progress + 1][cur][ANGEL] += dp[progress][cur - 1][DEVIL];
                }
            }
        }

        int cnt=0;
        for(int i=0; i<devil.length; i++){
            cnt+=dp[seq.length-1][i][ANGEL];
            cnt+=dp[seq.length-1][i][DEVIL];
        }

        System.out.println(cnt);
    }
}
