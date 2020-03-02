import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class baekjoon17822{
    static final int CLOCK_WISE = 0;
    static final int COUNTER_CLOCK_WISE = 1;

    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken()); int T = Integer.parseInt(st.nextToken());
        int [][]map = new int[N+1][M+1];
        boolean [][]adj;

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int trial=0; trial<T; trial++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); int d = Integer.parseInt(st.nextToken()); int k = Integer.parseInt(st.nextToken());
            adj = new boolean[N+1][M+1];

            for(int i=1; i<=N; i++){
                if(i%x!=0) continue;
                Deque<Integer> deque = new LinkedList<>();
                for(int j=1; j<=M; j++) deque.addLast(map[i][j]);

                for(int rotate=0; rotate<k; rotate++) {
                    if (d == CLOCK_WISE) {
                        int num = deque.pollLast();
                        deque.addFirst(num);
                    } else {
                        int num = deque.pollFirst();
                        deque.addLast(num);
                    }
                }
                for(int j=1; j<=M; j++) map[i][j] = deque.pollFirst();
            }

            boolean changed = false;

            for(int i=1; i<=N; i++){
                for(int j=1; j<=M-1; j++){
                    if(map[i][j]==map[i][j+1]&&map[i][j]!=0) {
                        changed = true;
                        adj[i][j] = true;
                        adj[i][j+1] = true;
                    }
                }
                if(map[i][1]==map[i][M]&&map[i][1]!=0){
                    changed = true;
                    adj[i][1] = true;
                    adj[i][M] = true;
                }
            }

            for(int i=1; i<=M; i++){
                for(int j=1; j<=N-1; j++){
                    if(map[j][i]==map[j+1][i]&&map[j][i]!=0) {
                        changed = true;
                        adj[j][i] = true;
                        adj[j+1][i] = true;
                    }
                }
            }

            if(changed) {
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= M; j++) {
                        if (adj[i][j]) map[i][j] = 0;
                    }
                }
            }


            else{
                double sum = 0;
                int cnt = 0;
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= M; j++) {
                        if(map[i][j]!=0){
                            sum += map[i][j];
                            cnt++;
                        }
                    }
                }
                double average = sum/cnt;

                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= M; j++) {
                        if(map[i][j]==0) continue;
                        if((double)map[i][j]>average) map[i][j]--;
                        else if((double)map[i][j]<average) map[i][j]++;
                    }
                }
            }

        }

        int sum = 0;
        for(int i=1; i<=N; i++)
            for(int j=1; j<=M; j++){
                sum += map[i][j];
            }

        System.out.println(sum);
    }

}
