import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon2980 {
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); int L = Integer.parseInt(st.nextToken());

        int delay = 0;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int D = Integer.parseInt(st.nextToken()); int R = Integer.parseInt(st.nextToken()); int G = Integer.parseInt(st.nextToken());
            D += delay;
            if(D % (R + G) < R) delay += R - (D % (R + G));
        }

        System.out.println(delay + L);
    }
}
