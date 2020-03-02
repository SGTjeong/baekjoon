import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon1939{
    static ArrayList<Edge>[] map;
    static boolean []visited;
    static PriorityQueue<Node> pq;
    static int N, M, start, end;

    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        map = new ArrayList[N+1];
        visited = new boolean[N+1];
        pq = new PriorityQueue<>();

        for(int i=1; i<=N; i++) map[i] = new ArrayList<>();

        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int x =Integer.parseInt(st.nextToken()); int y =Integer.parseInt(st.nextToken()); int weight = Integer.parseInt(st.nextToken());
            map[x].add(new Edge(y,weight)); map[y].add(new Edge(x, weight));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken()); end = Integer.parseInt(st.nextToken());

        dijkstra();
    }

    static void dijkstra(){
        pq.add(new Node(start, Integer.MAX_VALUE));

        while(!pq.isEmpty()){
            Node loc = pq.poll();
            if(loc.index == end){
                System.out.println(loc.weight);
                return;
            }

            visited[loc.index] = true;
            Iterator<Edge> itr = map[loc.index].iterator();
            while(itr.hasNext()){
                Edge edge = itr.next();
                if(!visited[edge.to]){
                    int newWeight = loc.weight < edge.weight ? loc.weight : edge.weight;
                    pq.add(new Node(edge.to, newWeight));
                }
            }

        }
    }

    static class Edge{
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node>{
        int index, weight;

        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight > o.weight? -1 : 1;
        }
    }
}
