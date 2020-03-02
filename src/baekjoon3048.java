import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon3048 {
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());

        char seq[] = new char[N+M]; char res[] = new char[N+M];

        String line = br.readLine(); for(int i=0; i<N; i++) seq[i] = line.charAt(N-1-i);
        line = br.readLine(); for(int i=0; i<M; i++) seq[N+i] = line.charAt(i);

        int T = Integer.parseInt(br.readLine());
        int []arr = new int[N+M];

        for(int i=0; i<N; i++){
            arr[i] = T + 2*i - N + 1;
            arr[i] = T-(N-1-i) >= 0 ? T-(N-1-i) : 0;
            if(arr[i] < i) res[i] = res[i];
            arr[i] = arr[i]+i <= M+i ? arr[i]+i : M+i;
        }

        for(int i=0; i<M; i++){
            arr[i+N] = 2 * i + N - T;
            if(arr[i+N] < i)res[i] = seq[i+N];
            else if(arr[i+N] >= i+N) res[i+N] = seq[i+N];
        }

        for(int i=0; i<N+M; i++) res[arr[i]] = seq[i];
        for(int i=0; i<N+M; i++) System.out.print(res[i]);
    }
}
