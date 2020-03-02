import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon1764 {
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());

        boolean flag = false;

        for(int i=1; i<=N; i++){
            String s = new String(Integer.toString(i));
            M -= s.length();
            if(M<=0){
                System.out.println(s.charAt(s.length()-1+M));
                flag = true;
                break;
            }
        }

        if(!flag) System.out.println(-1);
    }


}
