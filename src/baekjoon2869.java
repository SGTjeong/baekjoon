import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon2869 {
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken()); int B = Integer.parseInt(st.nextToken()); int V = Integer.parseInt(st.nextToken());

        int res = (V - B -1) / (A-B) + 1;

        System.out.println(res);

    }
}
