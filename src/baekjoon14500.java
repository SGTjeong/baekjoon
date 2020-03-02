import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon14500 {
    static int N,M;
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String p = br.readLine();
        StringTokenizer st = new StringTokenizer(p, " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+6][M+6];


        for (int i = 3; i<N+3; i++) {
            p = br.readLine();
            st = new StringTokenizer(p, " ");
            for (int j = 3; j<M+3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        int sum;
        for(int i=3; i< N+3; i++)
            for(int j=3; j< M+3; j++) {
                sum = arr[i][j+3];
                if(arr[i+1][j+1]>sum) sum = arr[i+1][j+1];
                if(arr[i-1][j+1]>sum) sum = arr[i-1][j+1];
                if(arr[i+1][j+2]>sum) sum = arr[i+1][j+2];
                if(arr[i-1][j+2]>sum) sum = arr[i-1][j+2];
                sum += arr[i][j] + arr[i][j+1] + arr[i][j+2];
                if(max<sum) max = sum;

                sum = arr[i][j+1];
                if(arr[i][j-1]>sum) sum = arr[i][j-1];
                if(arr[i+2][j+1]>sum) sum =  arr[i+2][j+1];
                if(arr[i+2][j-1]>sum) sum = arr[i+2][j-1];
                if(arr[i+1][j+1]>sum) sum = arr[i+1][j+1];
                if(arr[i+1][j-1]>sum) sum = arr[i+1][j-1];
                if(arr[i+3][j]>sum) sum = arr[i+3][j];
                sum += arr[i][j] + arr[i+1][j] + arr[i+2][j];
                if(max<sum) max = sum;

                sum = arr[i+1][j+1] + arr[i+1][j+2];
                if(arr[i-1][j+1] + arr[i-1][j+2]>sum) sum =  arr[i-1][j+1] + arr[i-1][j+2];
                if(arr[i+1][j+1] + arr[i+2][j+1]>sum) sum = arr[i+1][j+1] + arr[i+2][j+1];
                sum += arr[i][j] + arr[i][j+1];
                if(max<sum) max = sum;


                sum = arr[i][j+1] + arr[i+1][j+1];
                if(arr[i+1][j+1] + arr[i+1][j+2]>sum) sum = arr[i+1][j+1] + arr[i+1][j+2];
                if(arr[i][j+1] + arr[i][j+2]>sum) sum = arr[i][j+1] + arr[i][j+2];
                if(arr[i+1][j+1] + arr[i+2][j+1]>sum) sum = arr[i+1][j+1] + arr[i+2][j+1];
                if(arr[i+1][j-1] + arr[i+2][j-1]>sum) sum = arr[i+1][j-1] + arr[i+2][j-1];
                sum += arr[i][j] + arr[i+1][j];
                if(max<sum) max = sum;

            }

        System.out.println(max);
    }

}
