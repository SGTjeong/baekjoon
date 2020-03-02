import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon7453 {
    static int []AB, CD;
    static int N;
    static int prevPivot;

    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int []A = new int[N];
        int []B = new int[N];
        int []C = new int[N];
        int []D = new int[N];

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        AB = new int[N*N];
        CD = new int[N*N];

        int index = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                AB[index++] = A[i] + B[j];
            }
        }

        index = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                CD[index++] = C[i] + D[j];
            }
        }

        Arrays.sort(AB); Arrays.sort(CD);

        long res = 0;
        for(int i=0; i<N*N; i++){
            res += binarySearch(0, N*N, AB[i]*(-1));
        }

        System.out.println(res);
    }


    public static int binarySearch(int start, int end, int target){
        while(start < end){
            int mid =  (start + end)/2;
            if(target < CD[mid]) end = mid;
            else start = mid+1;
        }

        int upperBound = end;

        start = 0; end = N*N;
        while(start < end){
            int mid =  (start + end)/2;
            if(target <= CD[mid]) end = mid;
            else start = mid+1;
        }

        int lowerBound = end;

        return upperBound - lowerBound;
    }

}
