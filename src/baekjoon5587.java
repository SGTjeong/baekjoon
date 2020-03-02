import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon5587 {
    static int arr[];
    static int N;
    static int aCnt, bCnt;
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        aCnt = N; bCnt = N;

        arr = new int[2*N + 1];
        for(int i=0; i<N; i++) arr[Integer.parseInt(br.readLine())] = 1;
        int curNum = 0;

        while(true){
            curNum = aPut(curNum);
            //System.out.println(curNum + " a ");
            if(aCnt==0) break;
            if(curNum < 0) curNum = 0;
            curNum = bPut(curNum);
            //System.out.println(curNum + " b ");
            if(bCnt==0) break;
            if(curNum < 0) curNum = 0;
        }



        System.out.println(bCnt+ "\n" + aCnt);
    }

    static int aPut(int curNum){
        for(int i=1; i<=2*N; i++)
            if(arr[i]==1 && i > curNum){
                arr[i] = -1;
                aCnt--;
                return i;
            }
        return -1;
    }

    static int bPut(int curNum){
        for(int i=1; i<=2*N; i++)
            if(arr[i]==0 && i > curNum){
                arr[i] = -1;
                bCnt--;
                return i;
            }
        return -1;
    }
}

//1 6 7 9 10
//2 3 4 5 8