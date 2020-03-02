import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class baekjoon1043 {
    static int N,M,K;
    static int cnt=0;
    static ArrayList<Integer> party[];
    static ArrayList<Integer> people[];
    static ArrayList<Integer> know;
    static boolean visit[];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()); K = Integer.parseInt(st.nextToken());

        party = new ArrayList[M+1];
        for(int i=0; i<M+1; i++) party[i] = new ArrayList<>();

        people = new ArrayList[N+1];
        for(int i=0; i<N+1; i++) people[i] = new ArrayList<>();

        know = new ArrayList<>();
        visit = new boolean[M+1];

        for(int i=0; i<K; i++)
            know.add(Integer.parseInt(st.nextToken()));

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int j=0; j<num; j++) {
                int val = Integer.parseInt(st.nextToken());
                party[i].add(val);
                people[val].add(i);
            }
        }


        bfs();

        System.out.println(cnt);

    }
    public static void bfs() {
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0; i<know.size(); i++) {
            for(int j=0; j<people[know.get(i)].size(); j++) {
                if(!visit[people[know.get(i)].get(j)]) {
                    visit[people[know.get(i)].get(j)] = true;
                    queue.add(people[know.get(i)].get(j));
                }
            }
        }

        while(!queue.isEmpty()) {
            int val = queue.poll();
            for(int i=0; i<party[val].size(); i++) {
                for(int j=0; j<people[party[val].get(i)].size(); j++) {
                    if(!visit[people[party[val].get(i)].get(j)]) {
                        visit[people[party[val].get(i)].get(j)] = true;
                        queue.add(people[party[val].get(i)].get(j));
                    }
                }
            }
        }

        for(int i=0; i<M; i++)
            if(!visit[i])
                cnt++;
    }
}