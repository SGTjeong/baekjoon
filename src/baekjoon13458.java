import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon13458 {
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long []map = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) map[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken()); int C = Integer.parseInt(st.nextToken());

        long sum = N;
        for(int i=0; i<N; i++){
            map[i] -= B;
            if(map[i]<=0) continue;
            if(map[i]%C==0) sum+=map[i]/C;
            else sum += (map[i]/C) + 1;
        }

        System.out.println(sum);
    }
}
