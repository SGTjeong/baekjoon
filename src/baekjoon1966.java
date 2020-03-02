import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class baekjoon1966 {
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testcase = Integer.parseInt(br.readLine());
        while(testcase>0){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());

            Deque<Work> deque = new LinkedList<>();

            int numWeight[] = new int[10];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                int weight = Integer.parseInt(st.nextToken());
                numWeight[weight]++;
                deque.addLast(new Work(i,weight));
            }

            int cnt = 1;
            while(!deque.isEmpty()){
                Work work = deque.pollFirst();
                boolean flag = false;
                for(int i=work.weight+1; i<=9; i++) {
                    if(numWeight[i]>0) flag = true;
                }

                if(flag) deque.addLast(work);
                else{
                    if(work.index == M){
                        System.out.println(cnt);
                        break;
                    }
                    numWeight[work.weight]--;
                    cnt++;
                }
            }

            testcase--;
        }
    }

    static class Work{
        int index, weight;
        public Work(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }
    }
}
